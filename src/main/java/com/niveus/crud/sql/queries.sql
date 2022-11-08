CREATE TABLE emp_mast (empId serial PRIMARY KEY, empName VARCHAR (50) NOT NULL, empDesignation VARCHAR (50) NOT NULL, empDepartment VARCHAR (50) NOT NULL, empEmailId VARCHAR (50) NOT NULL);


INSERT INTO emp_mast (empId,empName,empDesignation,empDepartment,empEmailId) VALUES (101,'Paul','Developer','App Mod','paul@abc.com');

INSERT INTO emp_mast (empId,empName,empDesignation,empDepartment,empEmailId) VALUES (102,'Steve','Engineer','Admin','steve@abc.com');


SELECT * FROM emp_mast;



UPDATE emp_mast SET empDepartment='IT' where empId=102;


DELETE FROM emp_mast where empId=102;
