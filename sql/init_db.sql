--creation of the database
CREATE DATABASE product_management_db;

--creation of a new user
CREATE USER product_manager_user LOGIN PASSWORD '123456';

--giving privileges to the user
GRANT CREATE ON SCHEMA public TO product_manager_user; --the user can create a table
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO product_manager_user; --CRUD on existent tables
