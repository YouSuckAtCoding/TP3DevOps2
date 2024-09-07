CREATE DATABASE IF NOT EXISTS R2DBCDatabase;

CREATE TABLE IF NOT EXISTS R2DBCDatabase.produto (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(40) not null,
    price decimal not null,
    description varchar(40) not null,
    PRIMARY KEY (id)
);