CREATE TABLE IF NOT EXISTS loginUser(
  userId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(64) NOT NULL,
  password VARCHAR(128) NOT NULL
);
