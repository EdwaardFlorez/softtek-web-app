CREATE TABLE `softtek_schema`.`vehicle` (
  `vehicle_id` INT NOT NULL AUTO_INCREMENT,
  `vehicle_plate` VARCHAR(6) NOT NULL,
  `vehicle_brand` VARCHAR(45) NOT NULL,
  `vehicle_model` VARCHAR(4) NOT NULL,
  `vehicle_driver_identification` VARCHAR(10) NOT NULL,
  `vehicle_driver_name` VARCHAR(45) NOT NULL,
  `vehicle_status` TINYINT NOT NULL,
  `vehicle_shcedule` JSON NULL,
  `vehicle_provider` INT NOT NULL,
  PRIMARY KEY (`vehicle_id`),
  UNIQUE INDEX `vehicle_plate_UNIQUE` (`vehicle_plate` ASC) VISIBLE,
  INDEX `FK_provider_idx` (`vehicle_provider` ASC) VISIBLE,
  CONSTRAINT `FK_provider`
    FOREIGN KEY (`vehicle_provider`)
    REFERENCES `softtek_schema`.`provider` (`provider_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
DROP TRIGGER IF EXISTS `softtek_schema`.`vehicle_AFTER_INSERT`;

DELIMITER $$
USE `softtek_schema`$$
CREATE DEFINER = CURRENT_USER TRIGGER `softtek_schema`.`vehicle_AFTER_INSERT` AFTER INSERT ON `vehicle` FOR EACH ROW
BEGIN
	DECLARE provider_id_val INT;
    DECLARE provider_vehicles_val INT;

    -- Get the provider_id for the newly inserted vehicle
    SELECT provider_id INTO provider_id_val FROM provider WHERE provider_id = NEW.vehicle_provider;

    -- Get the current value of provider_vehicles for the provider
    SELECT provider_vehicles INTO provider_vehicles_val FROM provider WHERE provider_id = NEW.vehicle_provider;

    -- Increment provider_vehicles by 1
    SET provider_vehicles_val = provider_vehicles_val + 1;

    -- Update the provider_vehicles column for the provider
    UPDATE provider SET provider_vehicles = provider_vehicles_val WHERE provider_id = NEW.vehicle_provider;
END$$
DELIMITER ;
DROP TRIGGER IF EXISTS `softtek_schema`.`vehicle_AFTER_DELETE`;

DELIMITER $$
USE `softtek_schema`$$
CREATE DEFINER = CURRENT_USER TRIGGER `softtek_schema`.`vehicle_AFTER_DELETE` AFTER DELETE ON `vehicle` FOR EACH ROW
BEGIN
	DECLARE provider_id_val INT;
    DECLARE provider_vehicles_val INT;

    -- Get the provider_id for the deleted vehicle
    SELECT provider_id INTO provider_id_val FROM provider WHERE provider_id = OLD.vehicle_provider;

    -- Get the current value of provider_vehicles for the provider
    SELECT provider_vehicles INTO provider_vehicles_val FROM provider WHERE provider_id = OLD.vehicle_provider;

    -- Decrement provider_vehicles by 1
    SET provider_vehicles_val = provider_vehicles_val - 1;

    -- Update the provider_vehicles column for the provider
    UPDATE provider SET provider_vehicles = provider_vehicles_val WHERE provider_id = OLD.vehicle_provider;
END$$
DELIMITER ;
DROP TRIGGER IF EXISTS `softtek_schema`.`vehicle_AFTER_UPDATE`;

DELIMITER $$
USE `softtek_schema`$$
CREATE DEFINER = CURRENT_USER TRIGGER `softtek_schema`.`vehicle_AFTER_UPDATE` AFTER UPDATE ON `vehicle` FOR EACH ROW
BEGIN
	DECLARE old_provider_id INT;
	DECLARE new_provider_id INT;
	DECLARE old_provider_vehicles INT;
	DECLARE new_provider_vehicles INT;
	-- Check if the vehicle_provider field has been updated
    IF OLD.vehicle_provider <> NEW.vehicle_provider THEN
        
        -- Get the provider_id for the old and new vehicle providers
        SELECT provider_id INTO old_provider_id FROM provider WHERE provider_id = OLD.vehicle_provider;
        SELECT provider_id INTO new_provider_id FROM provider WHERE provider_id = NEW.vehicle_provider;

        -- Get the current value of provider_vehicles for the old and new providers
        SELECT provider_vehicles INTO old_provider_vehicles FROM provider WHERE provider_id = OLD.vehicle_provider;
        SELECT provider_vehicles INTO new_provider_vehicles FROM provider WHERE provider_id = NEW.vehicle_provider;

        -- Decrement provider_vehicles by 1 for the old provider
        SET old_provider_vehicles = old_provider_vehicles - 1;

        -- Increment provider_vehicles by 1 for the new provider
        SET new_provider_vehicles = new_provider_vehicles + 1;

        -- Update the provider_vehicles column for the old and new providers
        UPDATE provider SET provider_vehicles = old_provider_vehicles WHERE provider_id = OLD.vehicle_provider;
        UPDATE provider SET provider_vehicles = new_provider_vehicles WHERE provider_id = NEW.vehicle_provider;
    END IF;
END$$
DELIMITER ;