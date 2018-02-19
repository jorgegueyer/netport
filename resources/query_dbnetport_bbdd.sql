USE DBNETPORT;

SELECT DATE_FORMAT(CDate, '%d/%m/%Y') FROM Activities

INSERT INTO User (Name, Surname, Birthday) VALUES ("Administrador","Administrador","2018/01/05");
INSERT INTO Login (Userid, Username, Email, Password) 
VALUES ((SELECT ID FROM User WHERE Name="Administrador"),"admin","admin@jgy.es",1234);

SELECT User.Name, User.Surname, Login.Username, Login.Email FROM User LEFT JOIN Login ON User.ID = Login.Userid;

VALUES ((SELECT ID FROM User WHERE Name="Administrador"),"admin","admin@jgy.es",1234);

INSERT INTO Activity (Userid, Name, Type, Duration, AverageRhythm, CDate) 
VALUES (1,'Carrera Tarde','Carrera','00:01:12', '00:04:48',STR_TO_DATE('07-01-2018', '%d-%m-%Y'));

INSERT INTO Activity (Userid, Name, Type, Duration, AverageRhythm, CDate) 
VALUES (1,'Natación Noche','Natación','00:55:12', '00:01:19',STR_TO_DATE('08-01-2018', '%d-%m-%Y'));

UPDATE Activity SET Duration='01:12:34' WHERE ID=1;

SELECT * FROM Activity;

ALTER TABLE User
MODIFY COLUMN Name varchar(25); 

ALTER TABLE User
MODIFY COLUMN Surname varchar(30);

ALTER TABLE Login
MODIFY COLUMN Username varchar(15); 

ALTER TABLE Login
MODIFY COLUMN Email varchar(35); 

ALTER TABLE Login
MODIFY COLUMN Password varchar(6); 

ALTER TABLE Activity
MODIFY COLUMN Name varchar(30); 

ALTER TABLE Activity
MODIFY COLUMN Type varchar(15); 
