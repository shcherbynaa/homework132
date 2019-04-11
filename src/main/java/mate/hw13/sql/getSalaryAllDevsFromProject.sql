#task3.1
SELECT dev_proj.proj_id, projects.name, sum(developers.salary) FROM dev_proj
LEFT JOIN developers
ON dev_proj.dev_id = developers.id
INNER JOIN projects ON dev_proj.proj_id=projects.id
WHERE projects.name = 'Web'
GROUP BY dev_proj.proj_id;
