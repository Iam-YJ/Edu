use nhnacademy_12


CREATE TABLE cust (
cust_no int(11) not null,
cust_nm varchar(50) not null,
join_dt date not null,
PRIMARY KEY (cust_no)
);

CREATE TABLE ord (
ord_no int(11) not null,
cust_no int(11) not null,
ord_dt date not null,
PRIMARY KEY (ord_no)
);

ALTER TABLE cust MODIFY COLUMN 
cust_nm VARCHAR(100) NULL;

ALTER TABLE ord DROP COLUMN 
ord_dt;

DROP TABLE ord;
DROP TABLE cust;