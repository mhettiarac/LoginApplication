CREATE TABLE testapp.user
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 firstName VARCHAR(64),
 lastName VARCHAR(64),
 email VARCHAR(64) NOT NULL UNIQUE,
 userName VARCHAR(10),
 password VARCHAR(64)
 );


CREATE TABLE testapp.books
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 title VARCHAR(64),
 author VARCHAR(32),
 format ENUM('paperback', 'hardback', 'ebook'),
 price DECIMAL(5,2)
);
