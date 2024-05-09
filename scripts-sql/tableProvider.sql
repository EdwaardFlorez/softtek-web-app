CREATE TABLE `softtek_schema`.`provider` (
  `provider_id` INT NOT NULL,
  `provider_name` VARCHAR(45) NOT NULL,
  `provider_identification` VARCHAR(10) NOT NULL,
  `provider_vehicles` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`provider_id`),
  UNIQUE INDEX `provider_identification_UNIQUE` (`provider_identification` ASC) VISIBLE);
  
  ALTER TABLE `softtek_schema`.`provider` 
CHANGE COLUMN `provider_id` `provider_id` INT NOT NULL AUTO_INCREMENT ;