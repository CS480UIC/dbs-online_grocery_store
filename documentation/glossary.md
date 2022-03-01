Entity name: fruit
Synonyms: produce
Description: Fruit is a category of food items that are available for purchase by users. 

Entity name: shopping_cart 
Synonyms: order
Description: Shopping cart contains information of all the food items that a user is interested to purchase in a single order. It will have the product Id, product price and quantity of each product that the user wants to order. 

Entity name: meat
Synonyms: 
Description: Meat is a category of food items that is available for purchase by users.

Entity name: vegetable
Synonyms: produce
Description: A category of food items that is available for purchase by the users.

Entity name: delivery_info
Synonyms: 
Description: Delivery Info contains details about the delivery such as the id of the driver that will complete the delivery, the vehicle type, and driver proximity.

Entity name: history
Synonyms: 
Description: history shows all the items that the user bought at a certain date.

Entity: credit_card
Synonyms: payment
Description: credit_card contains the information of a user’s credit card information.



Relationships:

Relationship name: user-has-history
Maxima: one-many
Minima: one-zero

Relationship name: user-has-credit_card
Maxima: many-many
Minima: one-one

Relationship name: user-uses-shopping_cart
Maxima: one-one
Minima: one-one

Relationship name: shopping_cart-contains-fruit
Maxima: one-many
Minima:  one-zero

Relationship name: shopping_cart-contains-vegetable 
Maxima: one-many
Minima: one-zero

Relationship name: shopping_cart-contains-meat
Maxima: one-many
Minima: one-zero

Relationship name: user-receives-delivery_info
Maxima: one-one
Minima: one-zero

Attributes maxima and minima:
username 1-1(1)
password M-1(1)
first_name M-1(1)
last_name M-1(1)
email 1-1(1)
address M-1(1)
driver_id 1-1(0)
user_id M-1(0)
driver_proximity M-1(1)
vehicle_type M-1(1)
veg_name M-1(1)
veg_price M-1(1)
veg_quantity M-1(1)
veg_picture M-1(1)
product_id M-1(0)
meat_name M-1(1)
meat_price M-1(1)
meat_weight M-1(1)
product_id M-1(0)
fruit_name M-1(1)
	fruit_price M-1(1)
fruit_quantity M-1(1)
fruit_picture M-1(1)
product_id M-1(0)
credit_card_number M-1(1)
cvv M-1(1)
expiration_date M-1(1)
credit_card_owner_name M-1(1)
product_id M-1(1)
product_price M-1(1)
quantity M-1(1)
username M-1(1)

Attribute Cardinalities: 
username NOT NULL
password NOT NULL
first_name NOT NULL
last_name NOT NULL
email NOT NULL
address NOT NULL

product_id NOT NULL
product_price NOT NULL
quantity NOT NULL

credit_card_number NOT NULL
cvv NOT NULL
expiration_date NOT NULL
credit_card_owner_name NOT NULL

driver_id NOT NULL
user_id NULL
driver_proximity NULL
vehicle_type  NOT NULL

veg_name NOT NULL
veg_price NOT NULL
veg_quantity NOT NULL
veg_picture NOT NULL
product_id NOT NULL

meat_name NOT NULL
meat_price NOT NULL
meat_quantity NOT NULL
meat_picture NOT NULL

fruit_name NOT NULL
fruit_price NOT NULL
fruit_quantity NOT NULL
fruit_picture NOT NULL


Supertypes, Subtypes, and Partitions:

Supertype: Inventory
Subtype: Food (meat, fruit, vegetable)

Supertype: Information
Subtype: user information (user, credit_card, history)

Attribute Types:

History: 
order_id VARCHAR(20)
items INT NOT NULL 
order_date DATE NOT NULL
username(FK) VARCHAR(20)

User:
username VARCHAR(20)
password VARCHAR (20) NOT NULL
first_name VARCHAR(20) NOT NULL
last_name VARCHAR(20) NOT NULL
email VARCHAR(50) NOT NULL
address VARCHAR(50) NOT NULL

Credit_card:
credit_card_number INT 
cvv INT NOT NULL 
expiration_date DATE NOT NULL 
credit_card_owner_name VARCHAR(20) NOT NULL

Delivery_info:
driver_id INT
 user_id INT (FK)
driver_proximity TIME NULL
vehicle_type VARCHAR(20) NOT NULL

Shopping_cart:
product_id INT
product_price FLOAT NOT NULL
quantity INT NOT NULL
username VARCHAR(20)

Vegetable:
product_id VARCHAR(20) 
veg_name VARCHAR(20)
veg_price FLOAT(5) NOT NULL
veg_quantity INT NOT NULL
veg_picture VARCHAR(20) NOT NULL 

Meat:
product_id VARCHAR(20)
meat_name VARCHAR(20)
meat_price FLOAT(5) NOT NULL
meat_weight FLOAT(5) NOT NULL
meat_picture VARCHAR(20)NOT NULL 

Fruit:
product_id VARCHAR(20)
fruit_name VARCHAR(20)
fruit_price FLOAT(5) NOT NULL
fruit_quantity INT NOT NULL
fruit_picture VARCHAR(20) NOT NULL 

Cascade and Restrict for dependency relationship:
Relationship name: user-has-history
	Cascade/Restrict: Restrict

Relationship name: user-has-credit_card
Cascade/Restrict: Restrict

Relationship name: user-uses-shopping_cart
Cascade/Restrict: Restrict

Relationship name: shopping_cart-contains-fruit
Cascade/Restrict: Cascade

Relationship name: shopping_cart-contains-vegetable 
Cascade/Restrict: Cascade

Relationship name: shopping_cart-contains-meat
https://docs.google.com/spreadsheets/d/1t4w7G7vTdsEsj9DJN0tzhmjPmC5rn5e6YtCeRwrFN50/edit?usp=sharingCascade/Restrict: Cascade

Relationship name: user-receives-delivery_info
Cascade/Restrict: Restrict 


Cascade and Restrict on foreign keys:
username: Restrict
user_id: Restrict
product_id: Cascade
