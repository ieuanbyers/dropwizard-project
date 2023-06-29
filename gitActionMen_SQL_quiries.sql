
-- 	1. As a member of the HR team I want to be able to create a new delivery employee. 
-- I should be able to store a name, salary, bank account number and national insurance number
INSERT INTO `DeliveryEmployee`(`Name`,Salary, BankAccountNo, NatInsuranceNo) VALUES (?,?,?);


-- 2. As a member of the HR team I want to be able to update a delivery employee. I should be able to update a name, salary, bank account number
UPDATE `DeliveryEmployee` SET `Name` = ?, `Salary` = ?, BankAccountNo = ?, NatInsuranceNo = ? WHERE DeliveryEmployeeID = ?;


-- 	3. As a member of the HR team I want to be able to view a delivery employee. I should be able to view a name, salary, bank account number and national insurance number
SELECT (`Name`,Salary,BankAccountNo,NatInsuranceNo) FROM `DeliveryEmployee` WHERE DeliveryEmployeeID = ?;


-- 	4. As a member of the HR team I want to be able to view all delivery employees. I should be able to view a name, salary, bank account number and national insurance number
SELECT * FROM `DeliveryEmployee`;


-- 	5. As a member of the HR team I want to be able to delete a delivery employee
DELETE FROM `DeliveryEmployee` WHERE DeliveryEmployeeID = ?;

-- 	6. As a member of the Management team I want to be able to assign delivery employees to a project. 
-- I should be able to assign 1 or more employees per request
INSERT INTO `DeliveryEmployeeProject` (DeliveryEmployeeID, ProjectID, StartDate, EndDate) VALUES (?, ?, ?, ?);


-- 7. As a member of the Management team I want to be able to remove a delivery employee from a project.
--  A record should be retained to show that person worked on that project at some point
UPDATE DeliveryEmployeeProject SET EndDate = NOW() WHERE DeliveryEmployeeID = ?;

-- 	8. As a member of the HR team I want to be able to create a new sales employee. 
-- I should be able to store a name, salary, bank account number, national insurance number and commission rate
INSERT INTO `SalesEmployee` (`Name`, Salary, BankAccountNo, NatInsuranceNo, CommissionRate) VALUES(?, ?, ?, ?, ?);


-- 	9. As a member of the HR team I want to be able to update a sales employee. 
-- I should be able to update a name, salary, bank account number and commission rate
UPDATE `SalesEmployee` SET `Name` = ?, Salary = ?, BankAccountNo = ?, NatInsuranceNo = ?, CommissionRate = ? WHERE SalesEmployeeID = ?;


-- 	10. As a member of the HR team I want to be able to view a sales employee. 
-- I should be able to view a name, salary, bank account number, national insurance number and commission rate
SELECT (`Name`,Salary,BankAccountNo,NatInsuranceNo, CommissionRate) FROM `DeliveryEmployee` WHERE SalesEmployeeID = ?;


-- 	11. As a member of the HR team I want to be able to view all sales employees. 
-- I should be able to view a name, salary, bank account number, national insurance number and commission rate
SELECT * FROM `SalesEmployee`;


-- 	12. As a member of the HR team I want to be able to delete a sales employee
DELETE FROM `SalesEmployee` WHERE SalesEmployeeID = ?;


-- 	13. As a member of the Sales team I want to be able to assign a client to a project
-- 14. As a member of the Sales team I want to see a list of clients, the name of the sales employee who works with that client and the list of projects that the client has
-- 	15. As a member of the Sales team I want to see a client who has the highest value of projects
-- 	16. As a member of the Management team I want to be able to set a project as completed. Completed projects shouldn't be included in any of the lists
-- 	17. As a member of the Management team I want to be able to see a list of projects, the name of the Tech Lead and a list of all delivery employees assigned to the project