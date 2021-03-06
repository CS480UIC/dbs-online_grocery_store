SELECT * from customer
where username = 'itsalighani98'
order by username asc;

SELECT * from fruit
where product_id = 1
order by product_id asc;

SELECT * from meat
where product_id = 124
order by product_id asc;

SELECT * from vegetable
where product_name = 'Brocolli'
order by product_name asc;

SELECT product_name from fruit
where count(product_name) = 1
order by product_name asc;

SELECT order_id, order_date
from history
where DATE(order_date) > '2021-10-14'
order by order_id asc;

SELECT REVERSE(first_name) from customer
where last_name = "Pickle";

SELECT product_name from fruit
order by product_name asc
having COUNT(fruit_quantity) = 1;

SELECT product_id from fruit
where fruit_price > (SELECT AVG(fruit_price) from fruit);

SELECT product_id from fruit
where EXISTS (SELECT fruit_price from fruit where fruit_name = "Banana");

SELECT product_name from shopping_cart
join on fruit.product_id=shopping_cart.product_id
where product_id =  9876
order by product_name asc;

SELECT delivery_info.driver_id, delivery_info.vehicle_type, customer.first_name
from delivery_info
join customer on delivery_info.username = customer.username
order by customer.first_name asc;
