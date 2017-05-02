SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

create schema if not exists `Fogshop` default character set utf8;

create table if not exists `Customer` (

`customerId` int (12) unique not null,
`userName` varchar (36) not null,
`userLastname` varchar (36) not null,
`userAddress` varchar (36) not null,
`userZip` int (10) not null,
`userCity` varchar (20) not null,
`userPhone` int (12) not null,
`userEmail` varchar (36) unique not null,
`password` varchar (36) not null,
primary key (`customerId`))
engine = InnoDB;

create table if not exists `FogUser`  (
`empId` int (12) unique not null,
`empEmail` varchar (36) unique not null,
`empName` varchar (36) not null,
`password` varchar (36) not null,
primary key (`empId`))
engine = InnoDB;

create table if not exists `Part` (
`partId` int (12) not null,
`type` varchar (36) not null,
`category` varchar (12) not null,
`length` int (10) null,
`packetSize` int (10) null,
`unitName` varchar (10) null,
`desc` varchar (100) null,
`typeCategory` varchar (20) not null,
primary key (`partId`))
engine = InnoDB;

create table if not exists `Orders` (
`orderId` int (12) unique not null,
`customerId` int (12) not null,
`datetime` datetime not null,
primary key (`orderId`),
foreign key (`customerId`) references `Customer` (`customerId`))
engine = InnoDB;

create table if not exists `Odetails` (
`odetailsId` int (12) unique not null,
`orderId` int (12) not null,
`partId` int (12) not null,
`partQuantity` int (12) not null,
primary key (`odetailsId`),
foreign key (`orderId`) references `Orders` (`orderId`),
foreign key (`partId`) references `Part` (`partId`)
)
engine = InnoDB;


create table if not exists `Svg` (
`svgId` int (12) unique not null,
`customerId` int (12) not null,
`dateCreate` datetime not null,
`empId` int (12) not null,
`dateAccept` datetime not null,
`svgImage` longtext,
primary key (`svgId`),
foreign key (`customerId`) references `Customer` (`customerId`),
foreign key (`empId`) references `FogUser` (`empId`))
engine = InnoDB;
