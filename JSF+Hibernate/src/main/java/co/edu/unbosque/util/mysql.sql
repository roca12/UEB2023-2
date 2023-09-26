CREATE TABLE IF NOT EXISTS `uokplago_programacion2`.`usertable` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `passkey` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id`));
