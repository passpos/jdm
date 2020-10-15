/**
 * Author:  passpos <paiap@outlook.com>
 * Created: 2020年9月22日
 */
USE jdm_mybatis;
-- SELECT u.id, u.user_name, p.id, p.name 
-- FROM users u, pets p
-- WHERE u.id = 4
-- AND p.master_id = u.id;

SELECT 
    u.id, u.user_name, u.age,
    r.id rid, r.role_name
FROM users u, roles r, user_role a
WHERE u.id = 4
AND a.user_id = u.id
AND a.role_id = r.id;