
CREATE TABLE Toys (
    id int,
    price DECIMAL(20, 2),
    age int,
    name varchar(255),
    imageurl varchar(255),
    status varchar(255)    
);

INSERT INTO Toys (id, price, age, name, imageurl, status) VALUES (1,20.20,2,'Barbie','/img/product.jpg', 'available');
INSERT INTO Toys (id, price, age, name, imageurl, status) VALUES (2,12.20,1,'Tom','/img/product.jpg', 'available');
INSERT INTO Toys (id, price, age, name, imageurl, status) VALUES (3,15.34,3,'Popye','/img/product.jpg', 'unavailable');
