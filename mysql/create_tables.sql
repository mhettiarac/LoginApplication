CREATE TABLE testapp.user
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 username VARCHAR(64),
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
