CREATE TABLE delivery (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    number VARCHAR(255) NOT NULL,
    complement VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    rate VARCHAR(255) NOT NULL,
    date_order DATE NOT NULL,
    date_end DATE NOT NULL,
    status_delivery VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)

);