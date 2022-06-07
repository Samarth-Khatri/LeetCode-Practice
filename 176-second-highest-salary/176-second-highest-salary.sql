# Write your MySQL query statement below
SELECT MAX(salary) AS secondHighestSalary 
FROM employee
WHERE salary <> (SELECT MAX(salary) FROM employee);