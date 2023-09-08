package com.dz.factory.production.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.Code;

@Mapper
public interface CommonCodeMapper {
	ArrayList<Code> selectAllTeam();
	ArrayList<Code> getByCodeValue(String keyword);
	ArrayList<Code> getByCodeName(String keyword);
	ArrayList<Code> getByAll(String keyword);
}
