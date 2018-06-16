# Write your MySQL query statement below
SELECT Score,
  (SELECT COUNT(*) FROM (SELECT DISTINCT Score s FROM Scores) temp WHERE s >= Score) Rank
FROM Scores
ORDER BY Score DESC;
