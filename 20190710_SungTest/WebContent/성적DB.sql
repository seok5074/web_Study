--�Ϸù�ȣ ������ü
create sequence swq_sungtb_no

--�������̺�
create table sungtb
(
	no int,
	name varchar2(100) not null,
	kor int,
	eng int,
	mat int
)

--�⺻Ű
alter table sungtb
	add constraint pk_sungtb_no primary key(no)
	
--üũ����( ���� 0~100����)
alter table sungtb
	add constraint ck_sungtb_kor check(kor between 0 and 100)
	
alter table sungtb
	add constraint ck_sungtb_eng check(eng between 0 and 100)
	
alter table sungtb
	add constraint ck_sungtb_mat check(mat between 0 and 100)
	
--sample dats
insert into sungtb values(swq_sungtb_no.nextVal,'�ϱ浿',77,88,99);

insert into sungtb values(swq_sungtb_no.nextVal,'�̱浿',71,28,19);

insert into sungtb values(swq_sungtb_no.nextVal,'��浿',17,68,49);

insert into sungtb values(swq_sungtb_no.nextVal,'��浿',77,88,99);
insert into sungtb values(swq_sungtb_no.nextVal,'���浿',97,98,99);



select * from sungtb

--���� ���
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
	
--����
select * from sungtb_view
order by rank

--Dml(insert,update,delete) ����Ǿ��� ����� DB�� ����
commit

select * from SUNGTB

--�������
/*
update table�� set �ʵ��1 =��1,�ʵ��2= ��2
where  ���ǿ��ش��ϴ� �ʵ�
*/
update sungtb set name='�ϳ��浿'
where no =1


update sungtb set name='�ѱ浿',kor=90,eng=90,mat=90
where no=2

--�������
--		��������
/*
delete [from] table�� where ����

delete			table�� where ����
*/

delete from sungtb where no=3

delete sungtb where no > 5


select * from SUNGTB





