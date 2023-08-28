package com.dz.factory.management.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.management.domain.Partner;


@Mapper
public interface PartnerMapper {

	void insertPartner(Partner partner);

	ArrayList<Partner> seletAllPartner();

	void deletePartner(int id);

}
