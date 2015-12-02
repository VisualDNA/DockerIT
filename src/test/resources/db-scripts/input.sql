CREATE DATABASE testDb;
USE testDb;
CREATE TABLE `sample_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstAttribute` text NOT NULL,
  `secondAttribute` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;