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

SELECT order_id from history
where DATE(order_date) = '10/14/2021'
order by order_id asc;

SELECT product_name from fruit
order by product_name asc
having COUNT(fruit_quantity) = 1;
