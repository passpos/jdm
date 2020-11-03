/**
 * Author:  passpos <paiap@outlook.com>
 * Created: 2020年9月21日
 */

USE jdm_mybatis;
CREATE TABLE users(
    id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(255) DEFAULT NULL COLLATE utf8mb4_general_ci,
    age INT(11) DEFAULT NULL,
    PRIMARY KEY (id)
)
CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
ENGINE=InnoDB;

CREATE TABLE roles(
    id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    role_name VARCHAR(255) DEFAULT NULL COLLATE utf8mb4_general_ci,
    PRIMARY KEY (id)
)
CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
ENGINE=InnoDB;