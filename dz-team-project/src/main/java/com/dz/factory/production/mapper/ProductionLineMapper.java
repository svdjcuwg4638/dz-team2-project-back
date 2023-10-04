package com.dz.factory.production.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.ProductionLine;
import com.dz.factory.production.dto.ComponentDto;
import com.dz.factory.production.dto.ProductionDetailDto;
import com.dz.factory.production.dto.ProductionDto;
import com.dz.factory.production.dto.ProductionLineDto;

@Mapper
public interface ProductionLineMapper {
	ArrayList<ProductionLineDto> getAllLine();
	void addLine(ProductionLine lineDto);
	void updateLine(ProductionLine lineDto);
	void deleteLine(ArrayList<String> keyList);
}
