package com.dz.factory.bound.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.bound.dto.OutBoundDetailDto;

@Mapper
public interface OutBoundDetailMapper {

	void insertOutboundDetail(OutBoundDetailDto OutboundDetailDto);
	
	public List<OutBoundDetailDto> selectOutboundDetailAll();
}
