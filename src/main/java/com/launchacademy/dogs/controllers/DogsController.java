package com.launchacademy.dogs.controllers;

import com.launchacademy.dogs.models.Dog;
import com.launchacademy.dogs.models.DogService;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/dogs", "/dogs/new"})
public class DogsController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if (req.getServletPath().equals("/dogs/new")) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/dogs/new.jsp");
      dispatcher.forward(req, resp);
    } else if (req.getServletPath().equals("/dogs")) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/dogs/index.jsp");
      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();
      DogService service = new DogService(em);
      List<Dog> allDogsFromDatabase = service.findAll();
      req.setAttribute("dogsJspVariable", allDogsFromDatabase);
      dispatcher.forward(req, resp);
      em.close();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Dog newDogObject = new Dog();
    try {
      BeanUtils.populate(newDogObject, req.getParameterMap());
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    EntityManagerFactory emf = getEmf();
    EntityManager em = emf.createEntityManager();
    DogService service = new DogService(em);
    service.save(newDogObject);
    if (!service.save(newDogObject)) {
      System.out.println("Error in persistence");
    } else {
      System.out.println("Persistence was successful");
    }
    resp.sendRedirect("/dogs");
    em.close();
  }

  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory) this.getServletContext().getAttribute("emf");
  }
}

