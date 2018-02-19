CREATE USER 'su'@'%' IDENTIFIED BY 'zaq12wsx';

GRANT ALL PRIVILEGES ON *.* TO 'su'@'%' IDENTIFIED BY 'zaq12wsx' WITH GRANT OPTION;

CREATE DATABASE IF NOT EXISTS DBNETPORT;

USE DBNETPORT;

DROP TABLE IF EXISTS users;

CREATE TABLE User (
    ID          int(10)         NOT NULL AUTO_INCREMENT,   
    Name        varchar(25)     NOT NULL,
    Surname     varchar(30)     NOT NULL,   
    Birthday    date            NOT NULL,   
    UNIQUE(ID),
    PRIMARY KEY (ID)    
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE Login (
    ID          int(10)         NOT NULL AUTO_INCREMENT,
    Userid      int(10)         NOT NULL,
    Username    varchar(15)     NOT NULL,
    Email       varchar(35)     NOT NULL,
    Password    varchar(6)     NOT NULL,   
    UNIQUE(ID,UserID,Username,Email),
    PRIMARY KEY (ID), 
    FOREIGN KEY (Userid) REFERENCES Users(ID) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE Activity (
    ID              int(10)       NOT NULL AUTO_INCREMENT,
    Userid          int(10)       NOT NULL,
    Name            varchar(30)   NOT NULL,
    Type            varchar(15)   NOT NULL,
    Duration        time          NOT NULL, 
    AverageRhythm   time          NOT NULL, 
    CDate           date          NOT NULL,
    UNIQUE(ID),
    PRIMARY KEY (ID), 
    FOREIGN KEY (UserID) REFERENCES Users(ID) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;