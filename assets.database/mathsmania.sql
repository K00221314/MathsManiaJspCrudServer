-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MathsMania
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `MathsMania` ;

-- -----------------------------------------------------
-- Schema MathsMania
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MathsMania` DEFAULT CHARACTER SET latin1 ;
USE `MathsMania` ;

-- -----------------------------------------------------
-- Table `MathsMania`.`SubjectCategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MathsMania`.`SubjectCategory` ;

CREATE TABLE IF NOT EXISTS `MathsMania`.`SubjectCategory` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MathsMania`.`QuestionDifficulty`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MathsMania`.`QuestionDifficulty` ;

CREATE TABLE IF NOT EXISTS `MathsMania`.`QuestionDifficulty` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MathsMania`.`MultipleChoiceQuizQuestion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MathsMania`.`MultipleChoiceQuizQuestion` ;

CREATE TABLE IF NOT EXISTS `MathsMania`.`MultipleChoiceQuizQuestion` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `QuestionText` VARCHAR(255) NOT NULL,
  `AnswerText` VARCHAR(255) NOT NULL,
  `IncorrectAnswer1` VARCHAR(255) NOT NULL,
  `IncorrectAnswer2` VARCHAR(255) NOT NULL,
  `IncorrectAnswer3` VARCHAR(255) NOT NULL,
  `SubjectCategory` INT NOT NULL,
  `QuestionDifficulty` INT NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `QuestionText_UNIQUE` (`QuestionText` ASC) VISIBLE,
  INDEX `fk_MultipleChoiceQuizQuestion_SubjectCategory_idx` (`SubjectCategory` ASC) VISIBLE,
  INDEX `fk_MultipleChoiceQuizQuestion_QuestionDifficulty1_idx` (`QuestionDifficulty` ASC) VISIBLE,
  CONSTRAINT `fk_MultipleChoiceQuizQuestion_SubjectCategory`
    FOREIGN KEY (`SubjectCategory`)
    REFERENCES `MathsMania`.`SubjectCategory` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MultipleChoiceQuizQuestion_QuestionDifficulty1`
    FOREIGN KEY (`QuestionDifficulty`)
    REFERENCES `MathsMania`.`QuestionDifficulty` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `MathsMania`.`UserType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MathsMania`.`UserType` ;

CREATE TABLE IF NOT EXISTS `MathsMania`.`UserType` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MathsMania`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MathsMania`.`User` ;

CREATE TABLE IF NOT EXISTS `MathsMania`.`User` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `AvatarFilename` VARCHAR(45) NOT NULL,
  `Bio` VARCHAR(500) NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Firstname` VARCHAR(45) NOT NULL,
  `Lastname` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  `Username` VARCHAR(45) NOT NULL,
  `UserType` INT NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Username_UNIQUE` (`Username` ASC) VISIBLE,
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE,
  INDEX `fk_User_UserType1_idx` (`UserType` ASC) VISIBLE,
  CONSTRAINT `fk_User_UserType1`
    FOREIGN KEY (`UserType`)
    REFERENCES `MathsMania`.`UserType` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `MathsMania`.`SubjectCategory`
-- -----------------------------------------------------
START TRANSACTION;
USE `MathsMania`;
INSERT INTO `MathsMania`.`SubjectCategory` (`Id`, `Name`) VALUES (1, 'Math');
INSERT INTO `MathsMania`.`SubjectCategory` (`Id`, `Name`) VALUES (2, 'English');
INSERT INTO `MathsMania`.`SubjectCategory` (`Id`, `Name`) VALUES (3, 'History');

COMMIT;


-- -----------------------------------------------------
-- Data for table `MathsMania`.`QuestionDifficulty`
-- -----------------------------------------------------
START TRANSACTION;
USE `MathsMania`;
INSERT INTO `MathsMania`.`QuestionDifficulty` (`Id`, `Name`) VALUES (1, 'Easy');
INSERT INTO `MathsMania`.`QuestionDifficulty` (`Id`, `Name`) VALUES (2, 'Medium');
INSERT INTO `MathsMania`.`QuestionDifficulty` (`Id`, `Name`) VALUES (3, 'Difficult');
INSERT INTO `MathsMania`.`QuestionDifficulty` (`Id`, `Name`) VALUES (4, 'Advanced');

COMMIT;


-- -----------------------------------------------------
-- Data for table `MathsMania`.`UserType`
-- -----------------------------------------------------
START TRANSACTION;
USE `MathsMania`;
INSERT INTO `MathsMania`.`UserType` (`Id`, `Name`) VALUES (1, 'Administrators');
INSERT INTO `MathsMania`.`UserType` (`Id`, `Name`) VALUES (2, 'Students');
INSERT INTO `MathsMania`.`UserType` (`Id`, `Name`) VALUES (3, 'Quiz Masters');

COMMIT;


-- -----------------------------------------------------
-- Data for table `MathsMania`.`User`
-- -----------------------------------------------------
START TRANSACTION;
USE `MathsMania`;
INSERT INTO `MathsMania`.`User` (`Id`, `AvatarFilename`, `Bio`, `Email`, `Firstname`, `Lastname`, `Password`, `Username`, `UserType`) VALUES (1, 'Admin.png', 'The admin for the system.', 'admin@noreply.ie', 'Admin', 'System', 'password', 'Admin', 1);

COMMIT;

