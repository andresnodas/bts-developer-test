CREATE TABLE IF NOT EXISTS user (

    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(255),
    email VARCHAR(50),
    phone VARCHAR(50),
    country VARCHAR(50),
    city VARCHAR(50),
    postcode VARCHAR(50),
    name VARCHAR(50),
    address VARCHAR(255),

    PRIMARY KEY(id)

);

CREATE TABLE IF NOT EXISTS shopping (

    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    createddate DATE,

    PRIMARY KEY(id)

);