SELECT * FROM User WHERE ID='userid';

INSERT INTO User (Name, Surname, Birthday)
VALUES('Name','Surname','1970-01-01');

SELECT * FROM Login
WHERE (Username='username' OR Email='username') AND Password=0000;

INSERT INTO Login (Userid, Username, Email, Password)
VALUES('UserID','Username','Email',0000);

SELECT * FROM Activity 
WHERE Userid='userid';