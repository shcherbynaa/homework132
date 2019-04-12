SELECT developers.name FROM dev_skill
LEFT JOIN developers
ON dev_skill.dev_id = developers.id
INNER JOIN skills ON dev_skill.dev_id=skills.id
WHERE skills.branch = 'middle';
