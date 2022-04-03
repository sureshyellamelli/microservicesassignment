Project Setup

1.First run the Eureka Service Discovery project located in serviceregistry folder
Access the URL @ localhost:9001

2.Run the microservices Inventory service and Catalogues services located in the project inventory, catalogueservices

catalogue service @ locahost:9003  Inventory @locahost:9004

Swagger-ui @ locahost:9003/swagger-ui.html

3.Finally run the API service locate in apigate folder

post run both the microservices can be accessible from @ locahost:9002

catalogue service and inventory services can be accessible through API gateway

@locahost:9002/catalogue , locahost:9002/inventory

DB console can be accessible at locahost:9004/h2-console

Junit test cases can found at respective microservices test folders.

Below is the screen shot from Eureka service descovery

![image](https://user-images.githubusercontent.com/98443590/161444307-bf8eb609-1a47-4db3-8b9b-62ad7c10196d.png)






