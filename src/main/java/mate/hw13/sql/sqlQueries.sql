#1
ALTER TABLE developers ADD COLUMN salary INT NOT NULL;

#2
SELECT dev_proj.proj_id, SUM(developers.salary) FROM dev_proj
LEFT JOIN developers
ON dev_proj.dev_id = developers.id
GROUP BY dev_proj.proj_id
LIMIT 1;

#3
SELECT SUM(salary) FROM developers
INNER JOIN dev_skill
ON dev_skill.dev_id = developers.id
WHERE (skill_id=1 OR skill_id=2 OR skill_id=3);

#4
ALTER TABLE projects
ADD COLUMN cost INT NULL;

#5
SELECT dev_proj.proj_id, projects.name, AVG(developers.salary) FROM dev_proj
LEFT JOIN developers
ON dev_proj.dev_id = developers.id
INNER JOIN projects ON dev_proj.proj_id=projects.id
GROUP BY dev_proj.proj_id
ORDER BY SUM(developers.salary)
LIMIT 1;
