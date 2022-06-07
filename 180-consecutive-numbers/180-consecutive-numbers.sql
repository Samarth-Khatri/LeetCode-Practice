# Write your MySQL query statement below
SELECT DISTINCT a.num AS "ConsecutiveNums" 
FROM LOGS a 
JOIN LOGS b ON a.id = (b.id+1) AND a.num = b.num
JOIN LOGS c ON a.id = (c.id+2) AND a.num = c.num;