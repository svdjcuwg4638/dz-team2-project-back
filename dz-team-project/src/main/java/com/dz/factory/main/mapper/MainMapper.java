package com.dz.factory.main.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.production.dto.ComponentDto;
import com.dz.factory.production.dto.ProductionDetailDto;
import com.dz.factory.production.dto.ProductionDto;

@Mapper
public interface MainMapper {
	//내역조회
	public Integer getInventoryByDate();
	public Integer getInboundByDate();
	public Integer getOutBoundByDate();
	public Integer getProductionByDate();
}
