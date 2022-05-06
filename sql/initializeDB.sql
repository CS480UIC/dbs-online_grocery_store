CREATE TABLE `customer` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `credit_card_number` bigint DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `credit_card_number` (`credit_card_number`)
);


CREATE TABLE `credit_card` (
  `credit_card_number` bigint NOT NULL,
  `cvv` varchar(3) NOT NULL,
  `expiration_date` varchar(20) NOT NULL,
  `credit_card_name` varchar(30) NOT NULL,
  PRIMARY KEY (`credit_card_number`),
  CONSTRAINT `credit_card_ibfk_1` FOREIGN KEY (`credit_card_number`) REFERENCES `customer` (`credit_card_number`)
);

CREATE TABLE `delivery_info` (
  `driver_id` int NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `driver_proximity` varchar(20) NOT NULL,
  `vehicle_type` varchar(20) NOT NULL,
  PRIMARY KEY (`driver_id`),
  KEY `username` (`username`),
  CONSTRAINT `delivery_info_ibfk_1` FOREIGN KEY (`username`) REFERENCES `customer` (`username`)
);

CREATE TABLE `fruit` (
  `product_id` int NOT NULL,
  `fruit_name` varchar(20) DEFAULT NULL,
  `fruit_price` decimal(4,2) NOT NULL,
  `fruit_quantity` int NOT NULL,
  `fruit_picture` varchar(20) NOT NULL,
  PRIMARY KEY (`product_id`)
);

CREATE TABLE `history` (
  `order_id` int NOT NULL,
  `items` int NOT NULL,
  `order_date` date NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `username` (`username`),
  CONSTRAINT `history_ibfk_1` FOREIGN KEY (`username`) REFERENCES `customer` (`username`)
);

CREATE TABLE `meat` (
  `product_id` int NOT NULL,
  `meat_name` varchar(20) DEFAULT NULL,
  `meat_price` decimal(4,2) NOT NULL,
  `meat_quantity` int NOT NULL,
  `meat_picture` varchar(20) NOT NULL,
  PRIMARY KEY (`product_id`)
);
CREATE TABLE `shopping_cart` (
  `username` varchar(20) NOT NULL,
  `product_id` int NOT NULL,
  `product_price` decimal(5,2) NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`username`,`product_id`),
  CONSTRAINT `shopping_cart_ibfk_1` FOREIGN KEY (`username`) REFERENCES `customer` (`username`)
);

CREATE TABLE `vegetable` (
  `product_id` int NOT NULL,
  `veg_name` varchar(20) DEFAULT NULL,
  `veg_price` decimal(4,2) NOT NULL,
  `veg_quantity` int NOT NULL,
  `veg_picture` varchar(20) NOT NULL,
  PRIMARY KEY (`product_id`)
);

