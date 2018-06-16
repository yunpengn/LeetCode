# Write your MySQL query statement below
SELECT Department.Name AS Department, e1.Name AS Employee, Salary
FROM Employee e1 INNER JOIN Department
    ON e1.DepartmentId = Department.Id
WHERE 3 >= (
  SELECT COUNT(DISTINCT e2.Salary)
  FROM Employee e2
  WHERE e2.DepartmentId = e1.DepartmentId AND e2.Salary >= e1.Salary
);