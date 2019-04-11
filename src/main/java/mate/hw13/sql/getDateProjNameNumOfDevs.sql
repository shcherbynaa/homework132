SELECT projects.created_at, projects.name, count(projects.num_of_dev) FROM dev_proj
LEFT JOIN developers
ON dev_proj.dev_id = developers.id
INNER JOIN projects on dev_proj.dev_id=projects.id
GROUP BY projects.id;
