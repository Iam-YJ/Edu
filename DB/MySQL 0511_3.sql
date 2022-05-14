use nhn_academy_12;

-- 1. 기존 테이블 삭제
-- DROP TABLE mem;
-- DROP TABLE book;
-- DROP TABLE book_rent;

-- 2. 테이블 생성
CREATE TABLE mem (
   mem_no     INT(11)     NOT NULL,
   mem_nm     VARCHAR(50) NOT NULL,
   mem_grd_cd VARCHAR(10) NOT NULL,
   birth_dt   DATE            NULL,
   tel_no     VARCHAR(20)     NULL,
   PRIMARY KEY(mem_no)
);

CREATE TABLE book (
   book_no     INT(11)     NOT NULL,
   book_typ_cd VARCHAR(10) NOT NULL,
   book_nm     VARCHAR(50) NOT NULL,
   wrtr_nm     VARCHAR(50) NOT NULL,
   publ_nm     VARCHAR(50) NOT NULL,
   PRIMARY KEY(book_no)
);

CREATE TABLE book_rent (
   book_rent_no INT(11) NOT NULL,
   mem_no       INT(11) NOT NULL,
   book_no      INT(11) NOT NULL,
   rent_dt      DATE    NOT NULL,
   expt_retn_dt DATE    NOT NULL,
   actu_retn_dt DATE        NULL,
   PRIMARY KEY(mem_no, book_no)
);


-- 3. mem 테이블 데이터 추가
INSERT INTO mem VALUES(1, '유민상', '일반', '19910521', '01145678965');
INSERT INTO mem VALUES(2, '문세윤', '일반', '19891225', '0298745632' );
INSERT INTO mem VALUES(3, '김민경', '골드', NULL      , '01854786985');
INSERT INTO mem VALUES(4, '김준현', '일반', NULL      , ''           );
INSERT INTO mem VALUES(5, '이영식', '골드', '19850112', '0245678965' );
INSERT INTO mem VALUES(6, '강호동', '실버', '19811101', '01756781234');
INSERT INTO mem VALUES(7, '이수근', '실버', '19791014', NULL         );
INSERT INTO mem VALUES(8, '송민호', '일반', NULL      , NULL         );

COMMIT;


-- 4. book 테이블 데이터 추가
INSERT INTO book VALUES(1, '소설', '완전한 행복', '정유정', '은행나무');
INSERT INTO book VALUES(2, '소설', '미드나잇 라이브러리', '매트 헤이그', '인플루엔셜');
INSERT INTO book VALUES(3, '경제/경영', '부의 시나리오', '오건영', '페이지2북스');
INSERT INTO book VALUES(4, '경제/경영', '메타버스', '김상균', '플랜비디자인');
INSERT INTO book VALUES(5, '에세이', '그러라 그래', '양희은', '김영사' );
INSERT INTO book VALUES(6, '자기개발', '초생산성', '마이클 하얏트', '로크미디어');
INSERT INTO book VALUES(7, '인문', '공정하다는 착각', '마이클 샌델', '와이즈베리');
INSERT INTO book VALUES(8, '소설', '인간 실격', '다자이 오사무', '민음사' );
INSERT INTO book VALUES(9, '소설', '아몬드', '손원평', '창비');

COMMIT;


-- 5. book_rent 테이블 데이터 추가
INSERT INTO book_rent VALUES(1, 1, 9, '20210701', '20210708', NULL);
INSERT INTO book_rent VALUES(2, 1, 1, '20210701', '20210708', '20210712');
INSERT INTO book_rent VALUES(3, 1, 3, '20210721', '20210729', '20210730');
INSERT INTO book_rent VALUES(4, 2, 9, '20210625', '20210702', NULL);
INSERT INTO book_rent VALUES(5, 2, 4, '20210315', '20210322', '20210401');
INSERT INTO book_rent VALUES(6, 3, 5, '20210805', '20210812', NULL);
INSERT INTO book_rent VALUES(7, 3, 6, '20210102', '20210109', '20210521');
INSERT INTO book_rent VALUES(8, 4, 9, '20210608', '20210615', '20210812');
INSERT INTO book_rent VALUES(9, 4, 7, '20210708', '20210715', NULL);
INSERT INTO book_rent VALUES(10, 4, 8, '20210711', '20210718', NULL);
INSERT INTO book_rent VALUES(11, 5, 9, '20210213', '20210220', '20210301');
INSERT INTO book_rent VALUES(12, 5, 1, '20210315', '20210322', '20210405');
INSERT INTO book_rent VALUES(13, 5, 2, '20210425', '20210430', '20210505');
INSERT INTO book_rent VALUES(14, 6, 3, '20210505', '20210512', '20210601');
INSERT INTO book_rent VALUES(15, 7, 5, '20210622', '20210629', NULL);
INSERT INTO book_rent VALUES(16, 9, 9, '20210630', '20210707', NULL);

COMMIT;