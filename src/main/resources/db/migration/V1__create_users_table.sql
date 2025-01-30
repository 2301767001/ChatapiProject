--Потребители

  CREATE TABLE IF NOT EXISTS td_users(
      id INT PRIMARY KEY AUTO_INCREMENT,
      name VARCHAR(256),
      password VARCHAR(256),
      is_active INT DEFAULT 1

  );