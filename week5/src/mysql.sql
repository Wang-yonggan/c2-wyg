
#1
create database db1 charset=utf8;
use db1
set names gbk;
create table cqupt_student(studentid varchar(10),name varchar(20),sex varchar(2),age integer,
fee decimal(10,2),address varchar(50),memo varchar(300));

#2
create table  CourseAa(Aal varchar(20),Aa2 integer,Aa3 decimal(10));

#3
create table ChooseBb(Bb1 varchar(30),Bb2 integer,Bb3 decimal(6));

#4
alter table ChooseBb

#4
add Bb4 varchar(20) not null default "系统测试值"

#5
alter table choosebb add bb5 varchar(10) PRIMARY key;

#6
create view view_choosebb as select bb1,bb4,bb5 from choosebb;

#7
drop view view_choosebb;

#8
create index index_bb2 on choosebb (bb2 asc);
create index index_bb4 on choosebb (bb4 desc);

#9
alter table choosebb drop index index_bb2;

#10
create table test (name varchar(20),age int,score numeric(10,2),address varchar(60));

#11
insert into test values('赵一',20,580.00,'重邮宿舍12-3-5');
insert into test values('钱二',19,540.00,'南福苑5-2-9'),('孙三',21,555.50,'学生新区21-5-15'),('李四',22,505.00,' 重邮宿舍 8-6-22');
insert into test values('周五',20,495.50,'学生新区23-4-8'),('吴六',19,435.00,'南福苑 2-5-12');

#12
create table test_temp (name varchar(20),age int,score numeric(10,2),address varchar(60));

#13
insert into test_temp values('郑七',21,490.50,'重邮宿舍 11-2-1'),('张八',20,560.00,'南福苑 3-3-3'),('王九',10,515.00,'学生新区 19-7-1');

#14
insert into test select * from test_temp;

#15
update test set score=score+5 where age<=20;

#16
update test set age=age-1 where address like '南%';

#17
delete from test where age>=21 and score>=500;

#18
delete from test where score<500 and address like '重邮宿舍%';

#19
create table course(courseid varchar(15),coursename varchar (30),coursebeforeid varchar(15));

#20
create table student (sno varchar(20) ,name varchar(10),age int ,college varchar (30));

#21
create table choose (sno varchar(20),courseid varchar(30),score decimal(5,2));

#22
insert into student values('s00001','张三',20,'计算机学院'),('s00002','李四',19,'通信学院'),('s00003','王五',21,'计算机学院');

#23
insert into course values('C1','计算机导论',null),('C2','C语言','C1'),('C3','数据结构','C2');

#24
insert into choose values('s00001','C1',95),('s00001','C2',80),('s00001','C3',84),('s00002','C1',80);
insert into choose values('s00002','C2',85),('s00003','C1',78),('s00003','C3',70);

#25
select name ,sno from student where college='计算机学院';

#26
select * from student where age between 20 and 23 ;

#27
select count(*) from student;

#28
select max(score) from choose;
select avg(score) from choose;
select min(score) from choose;
select sum(score) from choose;

#29
select courseid,coursename from course where coursebeforeid is null;

#30
select a.sno,a.name ,b.coursename,a.score from (select a.sno ,a.name ,b.courseid,b.score from student a inner join choose b on a.sno=b.sno) a inner join course b on a.courseid=b.courseid;

#31
select * from student a where exists ( select * from student b where b.name='张三'and b.college=a.college);

#32
select sno,score from choose where score<(select a.score from choose a,student b where a.sno=b.sno and b.name='张三'  and courseid='C1') and courseid='C1';

#33
select sno from choose where courseid='C1' union all select sno from choose where courseid='C3';

#34
select sno from choose where courseid='C1' union select sno from choose where courseid='C3';
