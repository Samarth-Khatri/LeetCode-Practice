# Write your MySQL query statement below
Select e1.name as Employee
From Employee e1 join Employee e2 on e1.managerId = e2.id
Where e1.salary > e2.salary