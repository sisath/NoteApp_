# **NoteApp_**

# **Step-by-step guide**

Spring Boot, MySQL, JPA, Hibernate Rest API Tutorial; Build Restful CRUD API for a Note Application using Spring Boot, mySQL and JPA. 

For the following demonstration I have used IntelliJ Community Edition; it did not come with Spring Boot, so I can to use external ways of creating my project. I have used 
https://start.spring.io/ in order to generate my Spring Boot project. Underneath are all settings I have used generating the project.

![Spring_Initializr](https://github.com/sisath/NoteApp_/blob/main/Documentation/Spring_Initializr/spring_initializr.png?raw=true)

1. **Clone the project**

Create a folder on your PC where you'd like to save the project. Once created, right click inside the folder and clone the project using `git clone https://github.com/sisath/NoteApp_.git`.


2. **Opening the project**

Open your choice of IDE and click on `File -> Open` and navigate to the folder where you have cloned the project.


3. **Configure your application.properties found in src/main/resources:**

`spring.jpa.hibernate.ddl-auto=update`

`spring.datasource.url=jdbc:mysql://localhost:3306/"dataBaseName"`

`spring.datasource.usertitle="yourUserName"`

`spring.datasource.password="yourPassword"`

`spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`

4. **Create mySQL Database and set the following configurations so you would be able to connect to the DB.**

`drop database if exists note_db;`

`create database if not exists note_db;`

`select Host, User from mysql.user;`

`select * from note_db.notes;`

`CREATE USER 'YourUsername'@'localhost' IDENTIFIED BY 'pass';`

`GRANT ALL PRIVILEGES ON * . * TO 'YourUsername'@'localhost';`

`FLUSH PRIVILEGES;`


5. **Run the Application via `src/main/java/NoteAppApplication.java` and click on the `Run` (Shift +F10) button in the top right corner; and you'll be able to see that `Tomcat has successfully initialised with port(s): 8080 (http)`.**

6. **Explore the API's functionality using Postman.**

Post Request - `localhost:8080/api/v1/notes, by passing "title":"titleHere" and "body":"bodyHere"` 

Get Request - `localhost:8080/api/v1/notes`

Put Request - `localhost:8080/api/v1/notes/"id of note you'd like to update"` (localhost:8080/api/v1/notes/1) for example

Delete Request - `localhost:8080/api/v1/notes/"id of note you'd like to delete"`



# **Why are we doing this?** 

Application Programming Interfaces(APIs) are an essential component in order to
bring applications together, so they can perform a designated function built
around sharing data and execute processes that have been pre-defined. APIs work
as the middle man, they are between the database and front-end.

# **How I expected the challenge to go.**

I am expecting to encounter many challenges along the way, I am not expecting
this to be an easy task, however I am confident that I am going to be able to
resolve most, if not all, of the issues and produce a fully working API with a
user interface (UI).

# **What went well? / What didn't go as planned?**

In general, everything has gone well in the end, however there were many
obstacles along the way, one such example being "warning: adding embedded git repository: extractor/annotator-server
hint: You've added another git repository inside your current repository...". I resolved the issue by
committing/pushing to a brand-new repository and deleting the mixed repository. In Angular, I have faced an
issue where my variables were undefined, because the observable did not finish. I have resolved it by
creating a separate function and called it inside the subscription. I have also struggled with refreshing
components in Angular; fixed by adding a function to reload the same component instead of reloading the entire
page. Another issue occurred that the table in SQL was not being updated because the model wasn't updated
after the API call; fixed by "reload"-ing the table by querying the backend again. Another issue was
"No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor"; fixed by adding
"spring.jackson.serialization.fail-on-empty-beans=false" in the application.properties file. Another issue being
"Property '...' has no initializer and is not definitely assigned in the constructor"; have fixed it by
going into the tsconfig.json file and setting the "strictPropertyInitialization" from "true" to "false". 
Moreover, while trying to set uo my SQL database, I received the message "Access denied for user 'test'@'localhost' 
(using password: YES) except root user"; I resolved the issue by 
GRANT <privileges> ON database.* TO 'user'@'localhost' IDENTIFIED BY 'password'; in SQL.  

# **Possible improvements for future revisions of the project.**
  
While creating the UI(Not App) for the Note App API there was a rather noticeable
bug which I couldn't resolve at the time. It was an issue that the UI might not
automatically refresh the page so that the Create and Update CRUD functionality
wouldn't get updated at the same time, you would need to refresh the website (F5)
so the changes would take place. A possible improvement would be to implement a
method that would fix that, an async could be created to check for that.


# **Screenshots showing your postman requests and the output from the API. Screenshots of your database to prove that data is being persisted.**
  
![PostRequest](https://github.com/sisath/NoteApp_/blob/main/Documentation/CRUD_Function/PostReq.png?raw=true)
![UpdateRequest](https://github.com/sisath/NoteApp_/blob/main/Documentation/CRUD_Function/UpdReq.png?raw=true)
![DeleteRequest](https://github.com/sisath/NoteApp_/blob/main/Documentation/CRUD_Function/DelReq.png?raw=true)
![GetRequest](https://github.com/sisath/NoteApp_/blob/main/Documentation/CRUD_Function/GetReq.png?raw=true)
![DataBase](https://github.com/sisath/NoteApp_/blob/main/Documentation/CRUD_Function/DB.png?raw=true)
  
![CoverageReportController](https://github.com/sisath/NoteApp_/blob/main/Documentation/Coverage_Report/CoverageReportController.png?raw=true)
![CoverageReportRepo](https://github.com/sisath/NoteApp_/blob/main/Documentation/Coverage_Report/CoverageReportRepo.png?raw=true)
  
![ERDDiagramNotes](https://github.com/sisath/NoteApp_/blob/main/Documentation/ERDDiagram/ERDDiagramNotes.png?raw=true)
  
![JiraBacklog](https://github.com/sisath/NoteApp_/blob/main/Documentation/Jira/JiraBacklog.png?raw=true)
![JiraProjectComplete](https://github.com/sisath/NoteApp_/blob/main/Documentation/Jira/JiraProjectComplete.png?raw=true)
  
# **Jira Board**

https://sisoathc.atlassian.net/jira/software/projects/NOTE/boards/3/roadmap?shared=&atlOrigin=eyJpIjoiOGQ1ZTRhNWU1OGVkNGJjZTgzODQ4NDhiYjVmYWVkMGQiLCJwIjoiaiJ9


