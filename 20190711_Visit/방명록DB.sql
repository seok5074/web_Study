--일련번호 관리객체
create sequence seq_visit_idx

--방명록 테이블 생성
create table visit
(
	idx		int,			 				--일련번호
	name 	varchar2(10) 	not null,			--작성자
	content varchar2(2000) 	not null,	--내용
	pwd 	varchar2(100) 	not null,			--비밀번호
	ip		varchar2(100)	not null,			--작성 ip
	regdate date						--등록일자
)

--기본키 설정
alter table visit
	add constraint pk_visit_idx primary key(idx)
	
--sample data

insert into visit values(seq_visit_idx.nextVal,
'일길동','내가 1등~~','1234','127.0.0.1',sysdate);

insert into visit values(seq_visit_idx.nextVal,
'이길동','2등 2등 어 왜두번써지지? 어 왜두번써지지?','1234','127.0.0.1',sysdate);
select * from visit;

commit



