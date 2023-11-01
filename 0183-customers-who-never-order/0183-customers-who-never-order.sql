# Write your MySQL query statement below

SELECT name as Customers from Customers left join Orders on Customers.id = Orders.CustomerId where Orders.CustomerId is null;