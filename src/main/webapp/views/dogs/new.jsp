<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Add a dog Form</title>
  </head>
  <body>
    <form action="/dogs" method="post">
      <div>
        <label for="firstName">First Name: </label>
        <input type="text" name="firstName" />
      </div>
      <div>
        <label for="lastName">Last Name (family name): </label>
        <input type="text" name="lastName" />
      </div>
      <div>
        <label for="photoUrl">Photo URL: </label>
        <input type="text" name="photoUrl" />
      </div>
      <div>
          <label for="breed">Breed: </label>
          <input type="text" name="breed" />
      </div>
      <div>
          <label for="sex">Sex: </label>
          <input type="text" name="sex" />
      </div>
      <input type="submit" value="Add Dog!" />
    </form>
  </body>
</html>

