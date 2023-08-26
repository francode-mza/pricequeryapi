CREATE TABLE BRAND (
                       ID BIGINT PRIMARY KEY AUTO_INCREMENT,
                       BRAND_NAME VARCHAR(255)
);

CREATE TABLE PRODUCTS (
                          ID BIGINT PRIMARY KEY,
                          PRODUCT_NAME VARCHAR(255)
);

CREATE TABLE PRICES (
                        ID BIGINT PRIMARY KEY AUTO_INCREMENT,
                        START_DATE TIMESTAMP,
                        END_DATE TIMESTAMP,
                        PRODUCT_ID BIGINT,
                        PRIORITY INT,
                        PRICE DECIMAL(19, 2),
                        CURR VARCHAR(255),
                        BRAND_ID BIGINT,
                        FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCTS(ID),
                        FOREIGN KEY (BRAND_ID) REFERENCES BRAND(ID)
);