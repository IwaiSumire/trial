CREATE TABLE IF NOT EXISTS ramen (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  shop varchar(255) DEFAULT NULL,
  type varchar(255) DEFAULT NULL,
  star varchar(255) DEFAULT NULL,
  day DATE,
  pic BLOB,
  PRIMARY KEY (id)
);

