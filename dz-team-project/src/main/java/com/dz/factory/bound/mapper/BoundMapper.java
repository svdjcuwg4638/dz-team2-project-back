package com.dz.factory.bound.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.bound.dto.BoundDto;

@Mapper
public interface BoundMapper {

	void insertInbound(BoundDto boundDto);
	
	public List<BoundDto> selectInboundAll();
	
	public Long getMaxBoundId();
	
	public String getMaxBoundNo(String prefix);
}
