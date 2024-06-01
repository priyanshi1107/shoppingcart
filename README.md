# Shopping Cart Application



> ### Spring boot MVC project containing shopping cart application(CRUD,Thymeleaf, email, Dto patterns, Customized Exception Handling etc).
This Spring Boot Application was created to demonstrate a fully fledged full-stack application built with Spring boot + MySql + Thymeleaf + JavaScript and Jquery including CRUD operations, email sending, form validations and more.

# Structure

The application uses Spring Boot, MySql, JavaScript and Jquery.

* Uses the DTO design pattern to interact with Web layer.
* Uses customized exception handling wherever required.


And the code is organized as this:

1. `controller` is the web layer implemented by Spring MVC.
2. `dao` is the repository layer.
3. `service` contains all the business logic.
4. `entity` contains all the entities that are required.
5. `dto` contains all the Dtos for the entities .
6. `exceptions` contains all customized exceptions for product not found.
7. All the thymeleaf templates are inside template directory and all the .js and .css files are under static.

#Dependencies
* You can set email and password in `application.properties` like `spring.mail.username=example@gmail.com
  spring.mail.password=****`.

# How To Run Application

1. First thing we need to update the database with the products. For that I have made a StaticProducts controller for the same and I am using `PostMan` to post the data.You can find the shoppingcart postman collection attached with the project structure itself.You should use http://localhost:8181/saveProducts in postman to post the data.
2. If you don't update the DB  an exception will be fired, and you will see a product-not-found page on the browser.
3. Once you have updated DB you can access Home Page with entry point address for the backend API at : http://localhost:8181/all
4. Whenever you click on Add To Cart button, that product will be added to the cart and you will be directed to the cart page.I am using sessionStorage to add the product into the cart.
5. On Cart Page you will find `continue shopping` button for adding more products, `update cart` button for getting the price of the cart and `next` button for moving on to the User detail page.
6. For moving on to the User Details Page you need to update the cart first and then press next button.
7. At User Detail page I have provided form validations. So you need to provide valid email and a valid Indian Mobile number along with other user details or the data wont save.
8. After you provide valid data on User Details Page and save the data the application will send the receipt of the cart on the email mentioned in the User Details Page.
9. Then you will be redirected to the thank-you page i.e. final page where I have provided a link to Home Page.


# Database

* Database : MySql (Schema: shoppingcart, Username : root, Password : aayu13)
* Other required details you can find in `application.properties`.


# Run test

I have created test cases for all the service and repository methods inside service and repository packages of test respectively.

    




