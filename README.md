# **NoteApp_**

# **Step-by-step guide**

Spring Boot, MySQL, JPA, Hibernate Rest API Tutorial; Build Restful CRUD API for a Note Application using Spring Boot, mySQL and JPA. 

For the following demonstration I have used IntelliJ Community Edition; it did not come with Spring Boot, so I can to use external ways of creating my project. I have used 
https://start.spring.io/ in order to generate my Spring Boot project. Underneath are all settings I have used generating the project.

![Spring_Initializr](https://github.com/sisath/NoteApp_/blob/main/Documentation/Spring_Initializr/spring_initializr.png?raw=true)

1. **Clone the application**

`git clone https://github.com/sisath/NoteApp_.git`

2. **Create mySQL database and set the configurations**

`drop database if exists "dataBaseName";`

`create database if not exists "dataBaseName";`

`select Host, User from mysql.user;`

`select * from "dataBaseName"."tableName";`

`CREATE USER 'YourUsername'@'localhost' IDENTIFIED BY 'yourPassword';`

`GRANT ALL PRIVILEGES ON * . * TO 'YourUsername'@'localhost';`

`FLUSH PRIVILEGES;`

3. **Configure your application.properties found in src/main/resources:**

`spring.jpa.hibernate.ddl-auto=update`

`spring.datasource.url=jdbc:mysql://localhost:3306/"dataBaseName"`

`spring.datasource.usertitle="yourUserName"`

`spring.datasource.password="yourPassword"`

`spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`


4. **Opening the application**

Open your choice of IDE and click on `File -> Open` and navigate to the folder where you have cloned the project.


5. **Run the Application via `src/main/java/NoteAppApplication.java` and click on the `Run` (Shift +F10) button in the top right corner; and you'll be able to see that `Tomcat has successfully initialised with port(s): 8080 (http)`.**

6. **Explore the API's functionality using Postman.**

Post Request - `localhost:8080/api/v1/notes, by passing "title":"titleHere" and "body":"bodyHere"` 

Get Request - `localhost:8080/api/v1/notes`

Put Request - `localhost:8080/api/v1/notes/"id of note you'd like to update"` 

Delete Request - `localhost:8080/api/v1/notes/"id of note you'd like to delete"`



# **Why are we doing this?** 

Application Programming Interfaces(APIs) are an essential component in order to
bring applications together, so they can perform a designated function built
around sharing data and execute processes that have been pre-defined. APIs work
as the middle man, they are between the database and front-end.

# **How I expected the challenge to go.**

I am expecting to encounter many challenges along the way, I am not expecting
this to be an easy task, however I am confident that I am going to be able to
resolve most, if not all, of the issues and produce a fully working API.

# **What went well? / What didn't go as planned?**

In general, everything has gone well in the end, I have managed to produce an API with fully functioning CRUD functionality. While doing my tests I have encountered many 
different errors, but in the end I have achieved 100% test coverage. There were also many other obstacles along the way, I will give several examples below.

`warning: adding embedded git repository: extractor/annotator-server hint: You've added another git repository inside your current repository...` I resolved the issue by
committing/pushing to a brand-new repository and deleting the mixed repository. 

Another issue occurred that the table in SQL was not being updated because the model wasn't updated after the API call; fixed by "reload"-ing the table by querying the backend again. 

Moreover, while trying to set uo my SQL database, I received the message `Access denied for user 'test'@'localhost' (using password: YES) except root user`; I resolved the issue by `GRANT <privileges> ON database.* TO 'user'@'localhost' IDENTIFIED BY 'password'` in SQL.  

The error that ended up being the most problematic was `java.lang.AssertionError: No value at JSON path "$"` I managed to fix it by printing my response with `andDo(print())`

# **Possible improvements for future revisions of the project.**
 
 A more advanced User Interface (UI) can be added, for example with hashtags, as well as more exceptions.


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


