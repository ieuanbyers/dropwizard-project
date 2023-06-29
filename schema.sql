-- Use Statement
USE gitActionMen_KeelanS;

DROP TABLE IF EXISTS DeliveryEmployeeProject;
DROP TABLE IF EXISTS Project;
DROP TABLE IF EXISTS DeliveryEmployee;
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS SalesEmployee;

CREATE TABLE SalesEmployee (
	SalesEmployeeID smallint unsigned auto_increment,
    Name varchar(50) NOT NULL,
    Salary decimal(9,2) NOT NULL,
    BankAccountNo varchar(20) NOT NULL,
    NatInsuranceNo char(9) NOT NULL,
    CommissionRate decimal(4,3) NOT NULL,
    PRIMARY KEY(SalesEmployeeID)
);

CREATE TABLE DeliveryEmployee (
	DeliveryEmployeeID smallint unsigned auto_increment,
    Name varchar(50) NOT NULL,
    Salary decimal(9,2) NOT NULL,
    BankAccountNo varchar(20) NOT NULL,
    NatInsuranceNo char(9) NOT NULL,
    PRIMARY KEY(DeliveryEmployeeID)
);

CREATE TABLE Client (
	ClientID smallint unsigned auto_increment,
    Name varchar(50) NOT NULL,
    Address varchar(255) NOT NULL,
    PhoneNo varchar(15) NOT NULL,
    JoinDate DATE NOT NULL,
    SalesEmployeeID smallint unsigned NOT NULL,
    PRIMARY KEY(ClientID),
    FOREIGN KEY(SalesEmployeeID) REFERENCES SalesEmployee(SalesEmployeeID)
);

CREATE TABLE Project (
	ProjectID smallint unsigned auto_increment,
    Name varchar(50) NOT NULL,
    Value decimal(12,2) NOT NULL,
    StartDate DATE NOT NULL,
    CompletedDate DATE,
    TechLeadID smallint unsigned NOT NULL,
    ClientID smallint unsigned NOT NULL,
    PRIMARY KEY(ProjectID),
	FOREIGN KEY(TechLeadID) REFERENCES DeliveryEmployee(DeliveryEmployeeID),
    FOREIGN KEY(ClientID) REFERENCES Client(ClientID)
);

CREATE TABLE DeliveryEmployeeProject (
	DeliveryEmployeeID smallint unsigned auto_increment,
    ProjectID smallint unsigned NOT NULL,
    StartDate date NOT NULL,
    EndDate date NULL,
    PRIMARY KEY(DeliveryEmployeeID, ProjectID),
    FOREIGN KEY(ProjectID) REFERENCES Project(ProjectID),
    FOREIGN KEY(DeliveryEmployeeID) REFERENCES DeliveryEmployee(DeliveryEmployeeID)
);

-- Test Data

-- SalesEmployee Table
INSERT INTO SalesEmployee (Name, Salary, BankAccountNo, NatInsuranceNo, CommissionRate) VALUES('John Doe', 55000.00, '1234556', '123456789', 0.2);
INSERT INTO SalesEmployee (Name, Salary, BankAccountNo, NatInsuranceNo, CommissionRate) VALUES('Jane Doe', 48000.00, '6543213', '987654321', 0.2);

-- DeliveryEmployee Table
INSERT INTO DeliveryEmployee (Name, Salary, BankAccountNo, NatInsuranceNo) VALUES('John Smyth', 55000.00, '4355433', '123456789');
INSERT INTO DeliveryEmployee (Name, Salary, BankAccountNo, NatInsuranceNo) VALUES('Jane Smyth', 48000.00, '6564343', '748249291');

-- Client Table
INSERT INTO Client (Name, Address, PhoneNo, JoinDate, SalesEmployeeID) VALUES('Netflix', '2 High Street', '07712343434', "2022-05-21", 2);
INSERT INTO Client (Name, Address, PhoneNo, JoinDate, SalesEmployeeID) VALUES('Amazon', '5 Main Street', '0778387435', "2021-03-12", 1);

-- Project Table
INSERT INTO Project (Name, Value, StartDate, CompletedDate, TechLeadID, ClientID) VALUES('Netflix Rebuild', 5000000.00, "2022-06-01", "2023-06-20",  1, 1);
INSERT INTO Project (Name, Value, StartDate, CompletedDate, TechLeadID, ClientID) VALUES('Amazon Project', 2000000.00, "2023-04-25", null,  2, 2);

-- DeliveryEmployeeProject Table
INSERT INTO DeliveryEmployeeProject (DeliveryEmployeeID, ProjectID, IsActive) VALUES (2, 1, 1);
INSERT INTO DeliveryEmployeeProject (DeliveryEmployeeID, ProjectID, IsActive) VALUES (1, 2, 0);

