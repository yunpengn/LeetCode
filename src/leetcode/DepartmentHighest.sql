# Write your MySQL query statement below
SELECT Department.Name AS Department, e1.Name AS Employee, Salary
FROM Employee e1 INNER JOIN Department
    ON e1.DepartmentId = Department.Id
WHERE e1.Salary = (
  SELECT max(e2.Salary)
  FROM Employee e2
  WHERE e2.DepartmentId = e1.DepartmentId
);