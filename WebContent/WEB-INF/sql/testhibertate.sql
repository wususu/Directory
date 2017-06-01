-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2017-06-01 23:15:31
-- 服务器版本： 5.7.16-0ubuntu0.16.04.1
-- PHP Version: 5.6.30-7+deb.sury.org~xenial+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testhibertate`
--

-- --------------------------------------------------------

--
-- 表的结构 `contacter`
--

CREATE TABLE `contacter` (
  `id` int(12) NOT NULL,
  `name` varchar(10) NOT NULL,
  `home_tel` int(30) DEFAULT NULL,
  `cellphone` bigint(100) DEFAULT NULL,
  `wechat` varchar(30) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL,
  `birthday` varchar(30) DEFAULT NULL,
  `pic` varchar(300) DEFAULT NULL,
  `work` varchar(30) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `zip_code` int(10) DEFAULT NULL,
  `remarks` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `contacter`
--

INSERT INTO `contacter` (`id`, `name`, `home_tel`, `cellphone`, `wechat`, `mail`, `birthday`, `pic`, `work`, `address`, `zip_code`, `remarks`) VALUES
(1, '吴叔叔2', 83839617, 17666544566, 'wususua', 'jankewu', '2017-06-15', '/home/janke/workspace/Demo/WebContent/WEB-INF/image/0.吴叔叔.png', '学生', '华南农业大学', NULL, '备注'),
(2, '小乔', 1008611, 13602809963, 'xiaoqiao', '123@123.com', '2017-06-07', '/home/janke/workspace/Demo/WebContent/WEB-INF/image/2.测试人员.png', '法师', '王者农药', 20010, '萌妹子'),
(3, '兰陵王', 83831101, 13601100211, 'lanlingKing', '123', '2016-12-28', '/home/janke/workspace/Demo/WebContent/WEB-INF/image/3.123.png', '刺客', '王者荣耀', 10010, '帅哥'),
(4, '孙悟空', 123, 123, '132', '123', '2017-06-29', '/home/janke/workspace/Demo/WebContent/WEB-INF/image/4.123.png', '123', '123', NULL, '1231'),
(5, 'name', 123, 123, 'wechat', 'mail', '1996-02-14', '/home/janke/workspace/Demo/WebContent/WEB-INF/image/5.name.png', '123', '123', NULL, 'remarks'),
(7, '李白', 1008208820, 12345678910, 'xiaogouDOG', 'Dog@163.com', '2017-06-29', '/home/janke/workspace/Demo/WebContent/WEB-INF/image/7.拉布拉多.png', '看门', '华南农业大学', NULL, '小狗'),
(8, '不知火舞', 838398210, 13602809963, 'wususua', 'jankewu@163.com', '2017-06-29', '/home/janke/workspace/Demo/WebContent/WEB-INF/image/8.联系人.png', '学生', '华南农业大学', NULL, '备注');

-- --------------------------------------------------------

--
-- 表的结构 `contacter_in_groups`
--

CREATE TABLE `contacter_in_groups` (
  `id` int(100) NOT NULL,
  `contacter_id` int(120) NOT NULL,
  `group_id` int(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `contacter_in_groups`
--

INSERT INTO `contacter_in_groups` (`id`, `contacter_id`, `group_id`) VALUES
(6, 2, 5),
(9, 8, 5),
(10, 3, 5),
(11, 4, 5),
(12, 5, 5),
(14, 7, 5);

-- --------------------------------------------------------

--
-- 表的结构 `EMPLOYEE`
--

CREATE TABLE `EMPLOYEE` (
  `id` int(11) NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `EMPLOYEE`
--

INSERT INTO `EMPLOYEE` (`id`, `first_name`, `last_name`, `salary`) VALUES
(1, 'Zara', 'Ali', 5000),
(3, 'John', 'Paul', 100000),
(4, 'Zara', 'Ali', 5000),
(6, 'John', 'Paul', 100000),
(7, 'Zara', 'Ali', 5000),
(9, 'John', 'Paul', 100000),
(10, 'Zara', 'Ali', 5000),
(12, 'John', 'Paul', 100000);

-- --------------------------------------------------------

--
-- 表的结构 `groups`
--

CREATE TABLE `groups` (
  `id` int(12) NOT NULL,
  `name` varchar(20) NOT NULL,
  `count` int(100) NOT NULL DEFAULT '0' COMMENT '分组成员'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `groups`
--

INSERT INTO `groups` (`id`, `name`, `count`) VALUES
(4, '测试3', 0),
(5, '王者荣耀', 7);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `id` int(12) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'wususu', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contacter`
--
ALTER TABLE `contacter`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contacter_in_groups`
--
ALTER TABLE `contacter_in_groups`
  ADD PRIMARY KEY (`id`),
  ADD KEY `contacter_in_groups_ibfk_1` (`contacter_id`),
  ADD KEY `contacter_in_groups_ibfk_2` (`group_id`);

--
-- Indexes for table `EMPLOYEE`
--
ALTER TABLE `EMPLOYEE`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `contacter`
--
ALTER TABLE `contacter`
  MODIFY `id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- 使用表AUTO_INCREMENT `contacter_in_groups`
--
ALTER TABLE `contacter_in_groups`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- 使用表AUTO_INCREMENT `EMPLOYEE`
--
ALTER TABLE `EMPLOYEE`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- 使用表AUTO_INCREMENT `groups`
--
ALTER TABLE `groups`
  MODIFY `id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- 限制导出的表
--

--
-- 限制表 `contacter_in_groups`
--
ALTER TABLE `contacter_in_groups`
  ADD CONSTRAINT `contacter_in_groups_ibfk_1` FOREIGN KEY (`contacter_id`) REFERENCES `contacter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `contacter_in_groups_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
