#task3.2
SELECT projects.name, developers.name FROM dev_proj
LEFT JOIN developers
ON dev_proj.dev_id = developers.id
INNER JOIN projects ON dev_proj.proj_id=projects.id
WHERE projects.name = 'Web';
