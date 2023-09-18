package com.dz.factory.management.api;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.Bound;

@Mapper
public interface BoundMapper {

	HashMap<String, Integer> getFind_id(int i);

	
	
}
