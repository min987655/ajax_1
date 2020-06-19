### ajax_Product 과제

1. 테이블명 : product
2. 칼럼 : id, name, type, price, count
3. type(enum) : 과일, 문구, 옷
4. 삭제(해당 행만 remove) 

## 오라클 사용자 생성
```sql
alter session set "_ORACLE_SCRIPT"=true;
CREATE USER cos IDENTIFIED BY bitc5600;

GRANT CREATE SESSION TO cos;
GRANT CREATE TABLESPACE TO cos;
GRANT CREATE TABLE TO cos;
GRANT RESOURCE, CONNECT to cos;
GRANT CREATE SEQUENCE to cos;
ALTER user cos DEFAULT TABLESPACE users QUOTA UNLIMITED on users;
```

## 테이블
```sql
CREATE TABLE product (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) not null,
    type VARCHAR2(100) not null,
    price number not null,
    count number
);
```
## DB 시퀀스
```sql
CREATE SEQUENCE PRODUCT_SEQ
    START WITH 1
    INCREMENT BY 1;
```

## DB 데이터
```
INSERT INTO product VALUES(1, '사과', '과일', 2000, 20);
INSERT INTO product VALUES(2, '딸기', '과일', 5000, 40);
INSERT INTO product VALUES(3, '연필', '문구', 500, 100);
INSERT INTO product VALUES(4, '지우개', '문구', 500, 50);
INSERT INTO product VALUES(5, '무지티', '옷', 10000, 300);
INSERT INTO product VALUES(6, '줄무늬티', '옷', 15000, 150);
```