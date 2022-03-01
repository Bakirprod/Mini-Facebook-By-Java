-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 16, 2022 at 07:48 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `facebook`
--

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `titre` varchar(150) DEFAULT NULL,
  `text` varchar(1000) DEFAULT NULL,
  `file` varchar(255) NOT NULL DEFAULT 'null',
  `path` varchar(255) NOT NULL DEFAULT 'null',
  `time_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`id`, `titre`, `text`, `file`, `path`, `time_added`, `user_id`) VALUES
(1, 'Novak Djokovic leaves Australia after court rejects visa challenge', 'The saga around Novak Djokovics participation in this years Australian Open finally reached its conclusion on Sunday after days of confusion.\r\nThe tennis star departed Australia on an Emirates flight bound for Dubai after losing his legal challenge against a decision to revoke his visa for the second time.\r\nIn a virtual hearing earlier in the day, three Federal Court judges unanimously dismissed Djokovics application to overturn the immigration ministers decision to cancel his visa, but did not publish reasons for the ruling.', '220111111709-djokovic-tease-medium-plus-169.jpg', 'C://Users//LENOVO//Desktop//the Real Projects//project//src//main//webapp//images//220111111709-djokovic-tease-medium-plus-169.jpg', '2022-01-16 19:28:52', 1),
(2, 'Putin presents a profound threat to peace in Europe as drumbeat of war sounds on Russia-Ukraine border', 'Europe has a long and bloody history of wars, of borders brutally contested, of nations and empires carving destructive furrows far from home. But a sad harvest of sorrow and loss after the Second World War was followed by decades of relative peace and prosperity, even during a Cold War that did not become hot.\r\n\r\nToday that peace is being severely tested by Russian President Vladimir Putin as he masses troops on Ukraines border and diplomats are raising the alarm in stark terms. The US ambassador to the 57 nation, globe straddling Organization for Cooperation and Security in Europe, Michael Carpenter, warned on Thursday that European security is facing a \"crisis\" and \"the drumbeat of war is sounding loud.\"', '220114100127-putin-1230-medium-plus-169.jpg', 'C://Users//LENOVO//Desktop//the Real Projects//project//src//main//webapp//images//220114100127-putin-1230-medium-plus-169.jpg', '2022-01-16 19:32:17', 1),
(3, 'Italian fashion pioneer Nino Cerruti dies aged 91', 'talian fashion designer and entrepreneur Nino Cerruti died Saturday at the age of 91, the Italian family business Lanificio Fratelli Cerruti said in a statement.\r\nHe died at the hospital in Vercelli, Italy, where he was hospitalized for a hip operation, CNN affiliate SkyTg24 reported Saturday.\r\n\"For the family, friends, collaborators, and employees of Lanificio Cerruti, and the entire world of Italian fashion, today is a very sad day, because of the death of Signor Nino,\" said the Lanificio Fratelli Cerruti company statement posted on Facebook.\r\n\"We have lost a man of talent, an extraordinary designer, a man before his time, and a wonderful mentor, to whom many people owe so much,\" the statement said.\r\n\"Through his commitment and dedication to his work, which for him was his mission, he will become an everlasting example of a life lived in the constant search for style and harmony,\" the business said.', 'http___cdn.cnn.com_cnnnext_dam_assets_220116110627-nino-cerruti-lead-image.jpg', 'C://Users//LENOVO//Desktop//the Real Projects//project//src//main//webapp//images//http___cdn.cnn.com_cnnnext_dam_assets_220116110627-nino-cerruti-lead-image.jpg', '2022-01-16 19:33:51', 3),
(4, 'Martin Luther King Jr.’s life in pictures', '\r\nPreaching a message of nonviolent resistance, the Rev. Martin Luther King Jr. was the leading voice of the American civil rights movement.\r\n\r\nThe protests he organized, the marches he led and the speeches he delivered continue to resonate today. They were also key in bringing about landmark legislation such as the Civil Rights Act of 1964 and the Voting Rights Act of 1965.\r\n\r\nFor his efforts to fight racial inequality, King became the youngest person to win the Nobel Peace Prize. And years after his death, his birthday became a national holiday. Many schools, streets and buildings are named after King, and in 2011 he became the first African-American to receive a monument on the National Mall in Washington.\r\nAs we pause to remember King’s legacy, here’s a look back at his defining years in pictures.', '02.jpg', 'C://Users//LENOVO//Desktop//the Real Projects//project//src//main//webapp//images//\02.jpg', '2022-01-16 19:35:32', 3),
(5, 'Millions under weather alerts as major winter storm hits US and Canada', 'A winter storm is bringing heavy snow and ice to parts of the US and Canada, with millions under weather warnings.\r\n\r\nThousands of flights have been cancelled, and power cuts have been reported in some south-eastern states.\r\n\r\nVirginia, Georgia, and North and South Carolina declared states of emergency.\r\n\r\nThe US National Weather Service (NWS) said the storm would hit much of the eastern third of the country over the next two days, with more than 1ft (30cm) of snow expected in some areas.\r\n\r\nThe huge storm system is approaching the eastern US from the Midwest.\r\n\r\nSnow and ice could result in \"dangerous travel, power outages, and tree damage\", the NWS warned.\r\n\r\nThere were also forecasts of possible coastal flooding in some areas, including New York city and parts of Connecticut, with warnings that roads and infrastructure could be affected.', '_122736314_gettyimages-1237763047.jpg', 'C://Users//LENOVO//Desktop//the Real Projects//project//src//main//webapp//images//\\_122736314_gettyimages-1237763047.jpg', '2022-01-16 19:39:02', 2),
(6, 'Prince Andrew s lawyers say accuser may have false memories', 'Court documents show they want Virginia Giuffre s husband, Robert, and psychologist Dr Judith Lightfoot to be examined under oath.\r\nMs Giuffre s legal team want to call the prince s former assistant.\r\nPrince Andrew has repeatedly denied the allegations.\r\nWith a trial due to go ahead after a judge threw out the prince s motion to dismiss the civil case, both parties are requesting help with calling witnesses overseas to give evidence.\r\nJudge Lewis Kaplan, who is hearing the case in New York, has asked for witnesses evidence to be taken by lawyers by 14 July and said a trial could take place in court later this year.', '_122707823_hi073075378.jpg', 'C://Users//LENOVO//Desktop//the Real Projects//project//src//main//webapp//images//\\_122707823_hi073075378.jpg', '2022-01-16 19:41:32', 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `dob` date NOT NULL,
  `gender` varchar(6) NOT NULL,
  `phone` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `dob`, `gender`, `phone`) VALUES
(1, 'bakir', 'bakir', '2002-04-26', 'Male', '0557827577'),
(2, 'donya', 'donya', '2022-01-01', 'Female', '0656515946'),
(3, 'zaki', 'zaki', '2022-01-06', 'Male', '0557827577');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
