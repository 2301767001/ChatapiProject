--Съобщения

CREATE TABLE IF NOT EXISTS td_message(
     id INT PRIMARY KEY AUTO_INCREMENT,
     sender VARCHAR(256),
     receiver VARCHAR(256),
     content TEXT,
     date DATE,
     is_active INT DEFAULT 1

    );