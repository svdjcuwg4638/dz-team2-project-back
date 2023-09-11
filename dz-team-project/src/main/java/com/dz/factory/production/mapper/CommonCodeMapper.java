package com.dz.factory.production.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.Code;
import com.dz.factory.production.dto.CommonCodeDto;

@Mapper
public interface CommonCodeMapper {
	ArrayList<CommonCodeDto> getAllTeam();
	ArrayList<CommonCodeDto> getByCodeValue(String keyword);
	ArrayList<CommonCodeDto> getByCodeName(String keyword);
	ArrayList<CommonCodeDto> getByAll(String keyword);
}
