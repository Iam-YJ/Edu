select issue_date as '발급일', cer_num as '증명서확인번호', permenant_addr as '등록기준지(본적)'
	from certification_record C
		inner join birth_info B
			on B.resi_num = C.resi_num
where cer_num like "12345678%";

select rel_name as '구분', resi_name as '성명', birth_datetime as '출생연월일', resi_registration_num as '주민등록번호', gender as '성별'
	from resident R
		inner join family_relationship F
			on F.rel_target_resi_num = R.resi_num
		inner join birth_info B
			on B.resi_num = R.resi_num
where rel_level <= 1 and F.resi_num = 4
order by birth_datetime;

select issue_date as '발급일', cer_num as '증명서확인번호', 
	(select resi_name as '세대주 성명' from household_composition H
	inner join resident R on H.resi_num = R.resi_num
	where householder_rel_name = "본인") resi_name, 
	change_reason as '세대구성 사유', change_date as '세대구성 일자'
	from household_composition H
		inner join certification_record C
			on H.resi_num = C.resi_num
where cer_num like "98765432%";


(select  '현 주소' as '주소', change_addr as '주소', addr_change_date as '신고일' 
   from transfer_address_record 
      where addr_change_date=(
         select MAX(addr_change_date) 
            from  transfer_address_record) and household_num = 1)
union all
(select  '전 주소' as '주소', change_addr as'주소', addr_change_date as '신고일'
   from transfer_address_record
      where addr_change_date<>(
         select MAX(addr_change_date)
            from  transfer_address_record) and household_num = 1);


(select  '전 주소' as '주소', change_addr as'주소', addr_change_date as '신고일'
   from transfer_address_record
      where addr_change_date<>(
         select MAX(addr_change_date)
            from  transfer_address_record) and household_num = 1
            order by addr_change_date desc);


select householder_rel_name as '세대주 관계', resi_name as '성명', resi_registration_num as '주민등록번호', change_date as '신고일', change_reason as '변동사유'
	from household_composition H
		inner join resident R
			on H.resi_num = R.resi_num
where household_num = 1
order by change_date;