package com.launchacademy.dogs.models;

import com.launchacademy.dogs.models.Dog;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DogService {

  private EntityManager em;

  public DogService(EntityManager em) {
    this.em = em;
  }

  public List<Dog> findAll() {
    TypedQuery<Dog> query = em
        .createQuery("SELECT d FROM Dog d ORDER BY last_name, first_name ASC", Dog.class);
    return query.getResultList();
  }

  public boolean save(Dog dogToBeSaved) {
    try {
      em.getTransaction().begin();
      em.persist(dogToBeSaved);
      em.getTransaction().commit();
      return true;
    } catch (Exception err) {
      em.getTransaction().rollback();
      return false;
    }
  }
}
