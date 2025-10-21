# one-bank

----------------------------------------- OneBank system -----------------------------------------
OneBank bu foydalanuchilar kartalardan kartaga pul o'tkaza olish imkonini beradigan tirimdir.
Unda Foydalanuvchilar ro'yhatdan o'qib kartalarini kiritib, kiritilgan kartalardan turli pul o'tkazmalarini amalga oshirishlari umkun bo'ladi.
Undan tashqari Xarxil o'zkazmalar xaqida Notirication yuborish  va qabul qilish imkoniyani bor.

Bu loyihadi microservice larda bajaring. Quyidagi microservice-lar realizatsiya qilinsin.


Gateway Service: Acts as an entry point for all incoming requests and routes them to the appropriate microservices. It should handle authentication and request routing.

Discovery Service: Provides service registration and discovery capabilities using Spring Cloud Netflix Eureka. All microservices should register themselves with the discovery service upon startup, and other microservices should be able to discover and communicate with each other through it.

Config Server: Manages the configuration files for all microservices centrally. Each microservice should connect to the config server upon startup to fetch its configuration.

Auth Server: Generate token

Card Service: Profile card-lar bilan ishlaydi.
 1. Create card. 
	Request: honeNumber,cardNumber, amount, ownerId,createdAt.
 		- yaratilganda card-ning statusi ACTIVE qilamiz.
 	Response: OK	
 2. Get card by id.
	 Request: cardId
 	 Response: card full info
 3. yaratilgan kartalarni o'zgartirish imkonini beradi.

Cardni quyidagi filed-lar bor:id, phoneNumber,cardNumber,status (ACTIVE, BLOCKED), amount, ownerId,createdAt



Requirements:

Implement the Gateway Service, Discovery Service, Config Server, Book Service, Order Service, and User Service as separate Spring Boot applications.
Configure each microservice to register itself with the Discovery Service upon startup and use service discovery to communicate with other microservices.
Configure each microservice to fetch its configuration from the Config Server upon startup.
Implement the necessary RESTful APIs for each microservice, adhering to RESTful best practices.
Implement authentication and authorization using JWT in the User Service. Ensure that only authenticated users can access protected APIs in other microservices.
Implement proper error handling and validation in each microservice.
Implement appropriate unit tests and integration tests for each microservice.
Use appropriate database technologies for storing data in each microservice (e.g., MySQL, MongoDB, etc.).
Document the APIs of each microservice using Swagger or any other API documentation tool of your choice.
Use Git for version control and commit your code to a repository regularly.
Evaluation Criteria:





Good luck mazgios!
