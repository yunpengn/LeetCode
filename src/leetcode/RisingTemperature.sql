# Write your MySQL query statement below
Select w1.Id
FROM Weather AS w1, Weather AS w2
WHERE w1.Date = DATE_ADD(w2.Date, INTERVAL 1 Day) AND w1.Temperature > w2.Temperature;
