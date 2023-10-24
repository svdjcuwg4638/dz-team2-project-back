package com.dz.factory.management.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.UnitPrice;


@Mapper
public interface UnitPriceMapper {

	ArrayList<UnitPrice> selectAll();

	void insert(UnitPrice unitPrice);

	UnitPrice selOldOne(UnitPrice unitPrice);

	void updateEndDate(HashMap<String, Object> map);

	UnitPrice selOverOldOne(UnitPrice unitPrice);

	ArrayList<UnitPrice> currnetUnitPrice();

	ArrayList<UnitPrice> expectedPrice();

	void deletePrice(int i);
}
