package com.dz.factory.common.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.dto.CommonHelpDto;

@Mapper
public interface CommonHelpMapper {

	ArrayList<HashMap<String, Object>> getValue(CommonHelpDto data);

	ArrayList<HashMap<String, Object>> getCommonValue(CommonHelpDto data);

}
