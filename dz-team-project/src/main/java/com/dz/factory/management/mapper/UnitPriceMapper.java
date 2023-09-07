package com.dz.factory.management.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.UnitPrice;


@Mapper
public interface UnitPriceMapper {

	ArrayList<UnitPrice> selectAll();

	void insert(UnitPrice unitPrice);

}
