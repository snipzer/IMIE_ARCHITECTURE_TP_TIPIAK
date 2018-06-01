CREATE TABLE `users` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`email` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	`firstname` varchar(255) NOT NULL,
	`lastname` varchar(255) NOT NULL,
	`birthdate` DATE NOT NULL,
	`role` INT NOT NULL DEFAULT '1',
	PRIMARY KEY (`id`)
);

CREATE TABLE `trips` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`driver` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `steps` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`departure_time` DATE NOT NULL,
	`departure_city` INT NOT NULL,
	`arrival_time` DATE NOT NULL,
	`arrival_city` INT NOT NULL,
	`price` FLOAT NOT NULL,
	`trip_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `passengers` (
	`user_id` INT NOT NULL,
	`step_id` INT NOT NULL
);

CREATE TABLE `cars` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`slots` INT NOT NULL,
	`model` varchar(255),
	`user_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `cities` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`label` varchar(255) NOT NULL,
	`postcode` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `messages` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`trip_id` INT NOT NULL,
	`body` varchar(255) NOT NULL,
	`date` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `trips` ADD CONSTRAINT `trips_fk0` FOREIGN KEY (`driver`) REFERENCES `users`(`id`);

ALTER TABLE `steps` ADD CONSTRAINT `steps_fk0` FOREIGN KEY (`departure_city`) REFERENCES `cities`(`id`);

ALTER TABLE `steps` ADD CONSTRAINT `steps_fk1` FOREIGN KEY (`arrival_city`) REFERENCES `cities`(`id`);

ALTER TABLE `steps` ADD CONSTRAINT `steps_fk2` FOREIGN KEY (`trip_id`) REFERENCES `trips`(`id`);

ALTER TABLE `passengers` ADD CONSTRAINT `passengers_fk0` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `passengers` ADD CONSTRAINT `passengers_fk1` FOREIGN KEY (`step_id`) REFERENCES `steps`(`id`);

ALTER TABLE `cars` ADD CONSTRAINT `cars_fk0` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `messages` ADD CONSTRAINT `messages_fk0` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `messages` ADD CONSTRAINT `messages_fk1` FOREIGN KEY (`trip_id`) REFERENCES `trips`(`id`);

