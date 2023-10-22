# qp-assessment
###Project Title###

Grocery booking application

###Requirements###

Design API endpoints -
1. Admin Responsibilities:
- Add new grocery items to the system
- View existing grocery items
- Remove grocery items from the system
- Update details (e.g., name, price) of existing grocery items
- Manage inventory levels of grocery items

2. User Responsibilities:
- View the list of available grocery items
- Ability to book multiple grocery items in a single order

###Database Design###
Database: MySQL.
![alt text](https://github.com/shivanikpatni97/qp-assessment/blob/main/databaseDesign.png)

###API Testing###
https://www.postman.com/shivanipatni/workspace/qp-assessment/collection/27776867-5c49d77a-0517-4275-b54d-7b7e3c518adc?action=share&creator=27776867

###Assumptions###
1. User is logged in and they are placing the order in valid session.
2. Shipment level details would be in a different table with different services.
3. If a user is selecting a single product multiple times then ideally it should be handled by the frontend to send aggregated value, but currently, it is being handled by the service.
4. Currently implementing access control as a role-based in the same table.
5. Admin and user-facing websites have the same host with different endpoints.

WIP
Currently working on containerising.
