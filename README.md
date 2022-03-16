# NoteApp_

#Why are we doing this?

Application Programming Interfaces(APIs) are an essential component in order to
bring applications together, so they can perform a designated function built
around sharing data and execute processes that have been pre-defined. APIs work
as the middle man, they are between the database and front-end.

#How I expected the challenge to go.

I am expecting to encounter many challenges along the way, I am not expecting
this to be an easy task, however I am confident that I am going to be able to
resolve most, if not all, of the issues and produce a fully working API with a
user interface (UI).

#What went well? / What didn't go as planned?
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

#Possible improvements for future revisions of the project.
While creating the UI(Not App) for the Note App API there was a rather noticeable
bug which I couldn't resolve at the time. It was an issue that the UI might not
automatically refresh the page so that the Create and Update CRUD functionality
wouldn't get updated at the same time, you would need to refresh the website (F5)
so the changes would take place. A possible improvement would be to implement a
method that would fix that, an async could be created to check for that.


#Screenshots showing your postman requests and the output from the API. Screenshots of your database to prove that data is being persisted.

![PostReq](https://paste.pics/GD3O1)

![GetReq](https://paste.pics/GD3OH)

![UpdReq](https://paste.pics/GD3ON)

![DeleteReq](https://paste.pics/GD3P0)

#Screenshot of your test results, including coverage report.

![NoteController](https://paste.pics/GDNXJ)

![RepoController](https://paste.pics/GDNXP)

#Link to Jira Board - You must add your trainer(s) as collaborators also.

![Jira1](https://paste.pics/GDNXU)

![Jira2](https://paste.pics/GDNY1)

https://sisoathc.atlassian.net/jira/software/projects/NOTE/boards/3/roadmap?shared=&atlOrigin=eyJpIjoiOGQ1ZTRhNWU1OGVkNGJjZTgzODQ4NDhiYjVmYWVkMGQiLCJwIjoiaiJ9


