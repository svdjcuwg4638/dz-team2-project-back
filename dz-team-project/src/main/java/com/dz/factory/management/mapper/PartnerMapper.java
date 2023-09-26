package com.dz.factory.management.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.Partner;


@Mapper
public interface PartnerMapper {

	void insertPartner(Partner partner);

	ArrayList<Partner> seletAllPartner();

	void deletePartner(String code);

	ArrayList<Partner> selectSearchPartner(HashMap<String, String> search);

	Partner getSameCode(String partner_code);

	void updatePartner(Partner partner);

}
