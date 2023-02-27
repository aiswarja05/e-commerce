# e-commerce
# Overview
This e-commerce project is an API project that allows customers to browse and purchase products online. The application is built using Spring Boot, Java 8, and MySQL, Docker and provides the following features:
<ul>
   <li>Product catalog: Customers can view a catalog of available products, including product details, pricing, and availability.This is a database of products that are    available for sale. It may include information.</li>
   <li> Customer management: Customer can be added with their details with their purchased product list.</li>
    <li>Shopping/purchase : Customers can add items to their shopping cart and view a summary of their order. Managemnet can see all purchase details and modify</li>
</ul>

# Dependency
For JPA
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
# Configure Spring Datasource, JPA, App properties
Open src/main/resources/application.properties
  
spring.datasource.url=jdbc:mysql://localhost:3306/e-commerce?allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=12345678
spring.jpa.hibernate.ddl-auto=update
spring.mvc.pathmatch.matching-strategy=ant_path_matcher
server.error.whitelabel.enabled=false

server.port=9008

##Hibernate Properties
#The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

# Json Collection
  <b><h3>Find the collection of this service from <b> <a href="https://api.postman.com/collections/8359942-cd6be9c6-aeb2-4088-ad55-746c6d4e9041?access_key=PMAT-01GT8PVHTAVYSR6YF29KNK01NQ" target="_blank">here</a><h3>
