# Write your MySQL query statement below
SELECT Product.name, sum(Invoice.rest) as "rest", sum(Invoice.paid) as "paid", sum(Invoice.canceled) as "canceled", sum(Invoice.refunded) as "refunded"
FROM Product
INNER JOIN Invoice on Product.product_id = Invoice.product_id
group by Product.name
ORDER BY Product.name;
