CREATE TABLE customer (
	username VARCHAR(20) UNIQUE NOT NULL,
	password VARCHAR(20 NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	email VARCHAR(50) UNIQUE NOT NULL,
	address VARCHAR(50) NOT NULL,
	PRIMARY KEY (username)
);


CREATE TABLE credit_card (
	credit_card_number bigint NOT NULL,
	cvv VARCHAR(3) NOT NULL, 
	expiration_date VARCHAR(20) NOT NULL,
	credit_card_name VARCHAR(30) NOT NULL,
	PRIMARY KEY (credit_card_number)
);

CREATE TABLE history(
	order_id VARCHAR(20),
	items INT NOT NULL,
	order_date DATE NOT NULL,
	username VARCHAR(20),
	PRIMARY KEY(order_id),
	FOREIGN KEY(username) REFERENCES customer(username)
);

CREATE TABLE delivery_info(
	driver_id INT,
	username VARCHAR(20),
	driver_proximity TIME NOT NULL,
	vehicle_type VARCHAR(20) NOT NULL,
	PRIMARY KEY(driver_id),
	FOREIGN KEY(username) REFERENCES customer(username)
);

CREATE TABLE shopping_cart(
	product_id INT,
	product_price DECIMAL(5,2) UNSIGNED NOT NULL,
	quantity INT NOT NULL,
	username VARCHAR(20),
	PRIMARY KEY(product_id),
	FOREIGN KEY(username) REFERENCES customer(username)
);


CREATE TABLE fruit(
	product_id INT,,
	fruit_name VARCHAR(20),
	fruit_price DECIMAL(4,2) NOT NULL,
	fruit_quantity int NOT NULL,
	fruit_picture VARCHAR(20) NOT NULL,
	PRIMARY KEY (product_id),
	FOREIGN KEY (product_id) references shopping_cart (product_id)
);
CREATE TABLE vegetable(
	product_id INT,
	veg_name VARCHAR(20),
	veg_price DECIMAL(4,2)NOT NULL,
	veg_quantity INT NOT NULL,
	veg_picture VARCHAR(20)NOT NULL,
	PRIMARY KEY(product_id),
	FOREIGN KEY(product_id) REFERENCES shopping_cart(product_id)
);

CREATE TABLE meat(
	product_id INT,
	meat_name VARCHAR(20),
	Meat_price DECIMAL(5,2) UNSIGNED NOT NULL,
	meat_weight INT NOT NULL,
	meat_picture VARCHAR(20)NOT NULL,
	PRIMARY KEY(product_id),
	FOREIGN KEY(product_id) REFERENCES shopping_cart(product_id)
);








CREATE TABLE user
(
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);


CREATE TABLE entity1 
(
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);

