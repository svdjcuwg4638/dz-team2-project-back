package com.dz.factory.bound.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.bound.dto.OutBoundDto;

@Mapper
public interface OutBoundMapper {

	void insertOutbound(OutBoundDto OutboundDto);
	
	public List<OutBoundDto> selectOutboundAll();
	
	public Long getMaxBoundId();
}
