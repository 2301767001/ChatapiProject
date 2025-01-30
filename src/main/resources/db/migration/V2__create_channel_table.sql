    -- Канали

      CREATE TABLE IF NOT EXISTS td_channel(
          id INT PRIMARY KEY AUTO_INCREMENT,
          name VARCHAR(256),
          user_id INT,
          is_active INT DEFAULT 1

      );
