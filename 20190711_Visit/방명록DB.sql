--�Ϸù�ȣ ������ü
create sequence seq_visit_idx

--���� ���̺� ����
create table visit
(
	idx		int,			 				--�Ϸù�ȣ
	name 	varchar2(10) 	not null,			--�ۼ���
	content varchar2(2000) 	not null,	--����
	pwd 	varchar2(100) 	not null,			--��й�ȣ
	ip		varchar2(100)	not null,			--�ۼ� ip
	regdate date						--�������
)

--�⺻Ű ����
alter table visit
	add constraint pk_visit_idx primary key(idx)
	
--sample data

insert into visit values(seq_visit_idx.nextVal,
'�ϱ浿','���� 1��~~','1234','127.0.0.1',sysdate);

insert into visit values(seq_visit_idx.nextVal,
'�̱浿','2�� 2�� �� �ֵι�������? �� �ֵι�������?','1234','127.0.0.1',sysdate);
select * from visit;

commit



