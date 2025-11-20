*Simple Blog Application* 
(CRUD Blog Website built with Java 21, Spring Boot 4, Thymeleaf & H2 Database)

*Features*
- Create a new blog post  
- Edit/update an existing post  
- View all posts  
- Delete posts (with confirmation)  
- Clean Bootstrap UI  
- H2 In-Memory Database  
- Spring Data JPA CRUD Repository

*Tech Stack*
| Category | Technology |
|----------|------------|
| Language | Java **21** |
| Framework | Spring Boot **4.x** |
| Frontend | Thymeleaf + Bootstrap 5 |
| Database | H2 (in-memory) |
| Build Tool | Maven |
| Architecture | MVC |

*Migration: Spring Boot 3 ➝ Spring Boot 4*
Originally on Spring Boot **3.x** and migrated to **4.x**.  
The migration focused on dependency updates and ensuring backward compatibility.

1) Updated Spring Boot Parent (pom.xml)

Before (Spring Boot 3.x)
<version>3.x.x</version>

After (Spring Boot 4.x)
<version>4.0.0</version>

2) Updated Java Version Requirement
Spring Boot 4 requires Java 21.

Before
<java.version>17</java.version>

After
<java.version>21</java.version>

3) Maven Plugin Cleanup
No explicit version needed — using default Spring Boot 4 plugin.

Removed
<plugin>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-maven-plugin</artifactId>
  <version>3.x.x</version>
</plugin>

Now
<plugin>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>

4) Jakarta & Code Changes
⚠ No extra Jakarta changes were needed because the project already used:

import jakarta.persistence.*;

and did not use outdated javax APIs.

5) Post-Migration Validation (Testing)
Test	                        Result
App Boot Up	                    Passed 
Database Integration (H2 + JPA)	Passed 
Thymeleaf Views	                Passed 
CRUD Features	                Passed 
Delete Confirm Dialog	        Passed 

✔ No controller, repository, or model code required modification after upgrading.

Area            Update	                        Impact
pom.xml	        Spring Boot 4 version	        Major framework upgrade
Java Version    21 required	                    Enables latest JVM improvements
Plugins	        Cleaned unnecessary versions	Simpler build
Code	        No breaking changes	            Fully compatible
Migration Risk	Very low	                    Minimal testing required

Branch --  Purpose
main --	Original Spring Boot 3 application
migrate-spring-boot-4 -- Updated Spring Boot 4 version

Run in terminal : .\mvnw spring-boot:run
Access in Browser : http://localhost:8080/