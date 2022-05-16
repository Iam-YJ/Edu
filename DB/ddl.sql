use nhn_academy_12;

drop table certification_record;
drop table report;
drop table family_relationship;
drop table resident;
drop table birth_info;
drop table death_info;
drop table household_composition;
drop table household;
drop table transfer_address_record;

create table certification_record(
	cer_num varchar(16) not null,
    resi_num int not null,
    issue_date date not null,
    primary key(cer_num)
);

create table report(
	report_num int auto_increment not null,
    reporter_num int not null,
    report_class varchar(20) not null,
    report_qualification varchar(20) not null,
    report_date date not null,
    primary key(report_num)
);

create table family_relationship(
	rel_name varchar(10) not null,
    rel_target_resi_num int not null,
    resi_num int not null,
	rel_level int not null,
    primary key(rel_name, rel_target_resi_num)
);

create table resident(
	resi_num int auto_increment not null,
    resi_name varchar(10) not null,
    resi_registration_num varchar(300) not null,
    gender varchar(2) not null,
    tel_num varchar(20),
    email varchar(20),
    primary key(resi_num)
);

create table birth_info(
	resi_num int not null,
    birth_datetime datetime not null,
    birth_place_class varchar(20) not null,
    permenant_addr varchar(100) not null,
    primary key(resi_num)
);

create table death_info(
	resi_num int not null,
    birth_datetime datetime,
    birth_place_class varchar(20),
    permenant_addr varchar(100),
    primary key(resi_num)
);

create table household_composition(
    householder_rel_name varchar(10) not null,
	household_num int not null,
	resi_num int not null,
    change_reason varchar(10) not null,
    change_date date not null,
    primary key(householder_rel_name, household_num)
);

create table household(
	household_num int not null,
    primary key(household_num)
);

create table transfer_address_record(
	addr_change_date date not null,
    household_num int not null,
    change_addr varchar(100) not null,
    addr_class varchar(5) not null,
    primary key(addr_change_date, household_num)
);