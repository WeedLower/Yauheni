DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS books;

-- create table authors (
--                          id INT primary key ,
--                          first_name VARCHAR(50),
--                          last_name VARCHAR(50)
-- );

CREATE TABLE authors(
    id INT AUTO_INCREMENT PRIMARY KEY,
    authorID VARCHAR(250) NOT NULL
);

CREATE TABLE  books(
id INT AUTO_INCREMENT PRIMARY KEY,
authorID INT FOREIGN KEY REFERENCES authors(id),
title VARCHAR(250) NOT NULL,
priceOld  VARCHAR(250) DEFAULT NULL,
price VARCHAR(250) DEFAULT NULL
);

-- CREATE TABLE  books(
--                        id INT AUTO_INCREMENT PRIMARY KEY,
--                        author VARCHAR(250) foreign key references authors(first_name, last_name) ,
--                        title VARCHAR(250) NOT NULL,
--                        priceOld  VARCHAR(250) DEFAULT NULL,
--                        price VARCHAR(250) DEFAULT NULL
-- );