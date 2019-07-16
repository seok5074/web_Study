--일련번호 관리객체
create sequence swq_sungtb_no

--성적테이블
create table sungtb
(
	no int,
	name varchar2(100) not null,
	kor int,
	eng int,
	mat int
)

--기본키
alter table sungtb
	add constraint pk_sungtb_no primary key(no)
	
--체크제약( 점수 0~100사이)
alter table sungtb
	add constraint ck_sungtb_kor check(kor between 0 and 100)
	
alter table sungtb
	add constraint ck_sungtb_eng check(eng between 0 and 100)
	
alter table sungtb
	add constraint ck_sungtb_mat check(mat between 0 and 100)
	
--sample dats
insert into sungtb values(swq_sungtb_no.nextVal,'일길동',77,88,99);

insert into sungtb values(swq_sungtb_no.nextVal,'이길동',71,28,19);

insert into sungtb values(swq_sungtb_no.nextVal,'삼길동',17,68,49);

insert into sungtb values(swq_sungtb_no.nextVal,'사길동',77,88,99);
insert into sungtb values(swq_sungtb_no.nextVal,'오길동',97,98,99);



select * from sungtb

--총점 평균
create or replace view sungtb_view
as
	select 
		s.*,
		rank() over(order by tot desc)as rank
	from
	(
	select
		no,name,kor,eng,mat,
		(kor+eng+mat) as tot,
		round((kor+eng+mat)/3,1) as avg
	from sungtb
	) s
	order by no asc
	
--뷰사용
select * from sungtb_view
order by rank

--Dml(insert,update,delete) 수행되었된 명렬을 DB에 적용
commit

select * from SUNGTB

--수정명령
/*
update table명 set 필드명1 =값1,필드명2= 값2
where  조건에해당하는 필드
*/
update sungtb set name='하나길동'
where no =1


update sungtb set name='둘길동',kor=90,eng=90,mat=90
where no=2

--삭제명령
--		생략가능
/*
delete [from] table명 where 조건

delete			table명 where 조건
*/

delete from sungtb where no=3

delete sungtb where no > 5


select * from SUNGTB





