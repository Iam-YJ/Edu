insert into resident (resi_name, resi_registration_num, gender, tel_num) values(
	"남길동", "1309149999999", "남", "01000001111"
);

insert into resident (resi_name, resi_registration_num, gender, tel_num) values(
	"남석환", "5405149999999", "남", "01023456789"
);

insert into resident (resi_name, resi_registration_num, gender, tel_num) values(
	"박한나", "5510229999999", "여", "01000001112"
);

insert into resident (resi_name, resi_registration_num, gender, tel_num, email) values(
	"남기준", "7905109999999", "남", "01012345678", "nam@nhnad.co.kr"
);

insert into resident (resi_name, resi_registration_num, gender, tel_num) values(
	"이주은", "8208219999999", "여", "01000001113"
);

insert into resident (resi_name, resi_registration_num, gender) values(
	"이선미", "851205", "여"
);

insert into resident (resi_name, resi_registration_num, gender) values(
	"남기석", "1203159999999", "남"
);

insert into family_relationship values(
	"조부", 1, 4, 2
);

insert into family_relationship values(
	"부", 2, 4, 1
);

insert into family_relationship values(
	"모", 3, 4, 1
);

insert into family_relationship values(
	"본인", 4, 4, 0
);

insert into family_relationship values(
	"배우자", 5, 4, 0
);

insert into family_relationship values(
	"처제", 6, 4, 2
);

insert into family_relationship values(
	"자녀", 7, 4, 1
);

insert into birth_info values(
	1, "19130914072200", "자택", "경기도 성남시 분당구 대왕판교로645번길"
);

insert into birth_info values(
	2, "19540514173000", "병원", "경기도 성남시 분당구 대왕판교로645번길"
);

insert into birth_info values(
	3, "19551022111500", "병원", "서울특별시 중구 세종대로 110번길"
);

insert into birth_info values(
	4, "19790510204500", "병원", "경기도 성남시 분당구 대왕판교로645번길"
);

insert into birth_info values(
	5, "19820821012800", "병원", "경기도 수원시 팔달구 효원로 1번길"
);

insert into birth_info values(
	6, "19851205220100", "병원", "경기도 수원시 팔달구 효원로 1번길"
);

insert into birth_info values(
	7, "20120315145900", "병원", "경기도 성남시 분당구 대왕판교로645번길"
);

insert into death_info values(
	1, '20210429090300', '주택', '강원도 고성군 금강산로 290번길'
);

select rel_name, resi_name, birth_datetime, resi_registration_num, gender
	from resident R
		inner join family_relationship F
			on F.rel_target_resi_num = R.resi_num
		inner join birth_info B
			on B.resi_num = R.resi_num
where rel_level <= 1
order by birth_datetime;