CREATE TABLE cust (
cust_no INT(11) not null,
cust_nm VARCHAR(50) not null,
join_dt DATE not null,
PRIMARY KEY (cust_no)
);

INSERT INTO cust VALUES(1, '이영식', '20210721');
INSERT INTO cust (cust_no, cust_nm, join_dt) VALUES (2, '이진호', '20210730');
COMMIT;

UPDATE cust 
SET cust_nm='이용식'
WHERE cust_no=1;

COMMIT;


DELETE FROM cust
WHERE cust_no = 2;

COMMIT;






