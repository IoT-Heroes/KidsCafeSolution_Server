# heroes 
---

### DB : Postgre SQL
##### Version : 10.6-1
##### Link : 
	https://www.enterprisedb.com/thank-you-downloading-postgresql?anid=1256160
##### UI Tool : 
	https://www.postgresql.org/ftp/pgadmin/pgadmin4/v3.5/windows/

##### SQL Shell
1. ENTER -> ENTER -> ENTER -> ENTER -> HEROES -> ENTER
2. CREATE USER heroes WITH PASSWORD 'heroes'
3. CREATE DATABASE heroes;
4. select * from pg_database;	// check

##### ref
	https://m.blog.naver.com/PostView.nhn?blogId=blueday9404&logNo=110189437496&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F

##### create table example
1. http://127.0.0.1:49974/browser/
2. login and select database
3. tools ->  Query tool


CREATE TABLE departments (
    Department_id   integer PRIMARY KEY,
    Name        varchar(50)
);

insert into departments values( 1 , 'test1' );

insert into departments values( 2 , 'test2' );

insert into departments values( 3 , 'test3' );


##### Spring Quartz
###### version : 2.3.0
	https://offbyone.tistory.com/256