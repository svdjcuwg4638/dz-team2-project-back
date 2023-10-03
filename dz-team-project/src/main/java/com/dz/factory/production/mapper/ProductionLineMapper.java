package com.dz.factory.production.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.ProductionLine;
import com.dz.factory.production.dto.ComponentDto;
import com.dz.factory.production.dto.ProductionDetailDto;
import com.dz.factory.production.dto.ProductionDto;

@Mapper
public interface ProductionLineMapper {
	ArrayList<ProductionLine> getAllLine();

}
