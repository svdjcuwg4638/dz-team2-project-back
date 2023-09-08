package com.dz.factory.production.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.Code;
import com.dz.factory.production.dto.CodeDto;

@Mapper
public interface CommonCodeMapper {
	ArrayList<CodeDto> getAllTeam();
	ArrayList<CodeDto> getByCodeValue(String keyword);
	ArrayList<CodeDto> getByCodeName(String keyword);
	ArrayList<CodeDto> getByAll(String keyword);
}
