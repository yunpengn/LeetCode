# Write your MySQL query statement below
SELECT t.Request_at AS Day,
       ROUND(SUM(case when t.Status like 'cancelled_%'
         then 1
                 else 0
                 end) /
             count(*), 2) AS 'Cancellation Rate'
FROM Trips t INNER JOIN Users u
    on t.Client_Id = u.Users_Id
WHERE t.Request_at BETWEEN '2013-10-01' AND '2013-10-03'
      AND u.Banned='No'
GROUP BY t.Request_at