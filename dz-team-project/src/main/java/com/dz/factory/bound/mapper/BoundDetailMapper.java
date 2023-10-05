package com.dz.factory.bound.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.bound.dto.BoundDetailDto;

@Mapper
public interface BoundDetailMapper {

	void insertInboundDetail(BoundDetailDto boundDetailDto);
	
	public List<BoundDetailDto> selectInboundDetailAll();
	
	void updateByDetailId (BoundDetailDto boundDetailDto);
}
