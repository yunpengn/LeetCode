# Write your MySQL query statement below
SELECT employee.name AS Employee
FROM Employee employee, Employee manager
WHERE employee.ManagerId = manager.Id AND employee.Salary > manager.Salary;