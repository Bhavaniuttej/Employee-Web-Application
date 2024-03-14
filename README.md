# Employee-Web-Application


1. EmployeeRegistration Servlet:
   Main Aim: Manages the registration of employees.
   Description:
   This servlet facilitates the registration process for new employees. Upon receiving data from a registration form, it validates the inputs and inserts the employee details into a MySQL database.
   Usage:
   Deploy this servlet in a servlet container such as Apache Tomcat. Users can access the registration form by visiting the URL `/register` on your web application. Ensure the servlet is configured to handle GET requests.

3. registration.html:
   Main Aim: Provides a user interface for the employee registration form.
   Description:
   This HTML file serves as the front-end interface for the employee registration process. It includes input fields for capturing employee details such as name, email, age, and date of birth.
   Usage:
   Place this HTML file in the appropriate directory of your web application. Users can access the registration form by navigating to the corresponding URL. Ensure the form's action attribute points to the 
   EmployeeRegistration servlet (`/register`).

5. EmployeeDetailsFetching Servlet:
  Main Aim: Retrieves and displays employee details from the database.
  Description:
  This servlet fetches employee records stored in a MySQL database and presents them in a tabular format. It retrieves details such as employee ID, name, email, age, and date of birth.
  Usage:
  Deploy this servlet alongside other components of your web application. Users can view the employee details by visiting the corresponding URL `/EmployeeDetails`. Ensure the servlet is configured to handle GET requests.

