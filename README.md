# Project: Inventory Management system 
## Shani McDonald

#### Objective
    Create an application using Java that interacts with a managed SQL database.

Prerequisites for running this application :
- Java
- Maven
- My SQL


## Installation:
#### From your termninal run the following commands: 
```
- git clone git@github.com:SHANIMCD/InventoryDatababseSM. git
- mvn package 
- java jar target/WeekFiveProjectSM-jar-with-dependencies.jar
```


### Cloud 
I started by selecting a cloud computing service to be able to host my database online. 
I picked Google Cloud platform. 
I navigated to SQL in the GCP console menu and created an instance. 

Choices made:
For connectivity, I enabled Public IP and entered *0.0.0.0/0* as an allowed network because this allows all iPv4 IP addresses to be able to access the instance.

Machine type:
I chose db-g1-small with a 1.7GB memory which provides less storage space than the db-n1 standard type of 3.75GB but as this project is for demonstration/testing, I found a smaller memory allowance of 1.7GB to suffice, however I did enable automatic storage increase in case that changes.


## SQL Schema design
![](2020-06-12-12-30-11.png)
## One to many:
#### Customer to order schemas
- A customer can have many orders but an order can only be unique to the customer that placed it.
#### Items to Order Schemas
- An order can contain many items but can only have one 
