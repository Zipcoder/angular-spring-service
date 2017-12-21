# MVP Spring and Angular Communication
* **Purpose**
    * Using this micro-project, demonstrate your ability to communicate between two different technology stacks: [Spring](https://spring.io/), and [Angular](https://angular.io/).
    
* **Objective**
    * Implement a class `UserController` which adds `User` objects to a `UserRepository` using a composite `UserService` object.
    * The `UserController` should invoke the `add` method upon clicking the `submit` button on the angular application.
    * You are expected to implement any tests you deem _necessary_.

* **Project details**
    * The root directory of this project contains 2 notable directories
        * The `app` directory
            * Use [this URI](https://github.com/Zipcoder/angular-spring-service-client.git) to clone your client-side application. 
            * Contains all of the angular content.
            * Navigate to this directory and run `npm start` or `ng serve` to begin serving your webpage.
            
        * The `src` directory
            * Contains all of the java content.
            * Navigate tot his directory and run `mvn spring-boot:run`
            
* **Helpful hints**:
    * Kill zombie processes running on port 8080 via this command.
    * ```kill -kill `lsof -t -i tcp:8080` ``
