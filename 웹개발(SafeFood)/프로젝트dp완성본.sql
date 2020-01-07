create database  safefood;

use safefood;

create table boards(
	num INTEGER auto_increment primary key,
    title varchar(20),
    writer varchar(20),
    date date,
    contents varchar(200),
    hits integer,
    pw varchar(100) NOT NULL
);

CREATE TABLE nutrition (
    code INT UNIQUE NOT NULL PRIMARY KEY,
    name VARCHAR(30),
    supportpereat DOUBLE,
    calory DOUBLE,
    carbo DOUBLE,
    protein DOUBLE,
    fat DOUBLE,
    sugar DOUBLE,
    natrium DOUBLE,
    chole DOUBLE,
    fattyacid DOUBLE,
    transfat DOUBLE
);

CREATE TABLE product (
	code INT UNIQUE NOT NULL PRIMARY KEY,
    maker VARCHAR(30),
    material VARCHAR(1000),
    img VARCHAR(30),
    allergy VARCHAR(200)
);

CREATE TABLE members (
    id VARCHAR(20) PRIMARY KEY,
    pw VARCHAR(20),
    email varchar(50),
    name VARCHAR(20),
    cm int,
    kg int,
    gender varchar(1) check(gender IN ('M','F')),
    allergy VARCHAR(200),
    favor varchar(300),
    eating varchar(300),
    money int
);

create view food
as
select
b.code, b.name, b.supportpereat, b.calory, b.carbo, b.protein, b.fat, b.sugar,
b.natrium, b.chole, b.fattyacid, b.transfat, a.maker, a.material, a.img, a.allergy
from product a, nutrition b where a.code = b.code;


create table reset(id varchar(20),date date);
