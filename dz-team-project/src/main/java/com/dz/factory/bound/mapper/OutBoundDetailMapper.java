package com.dz.factory.bound.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dz.factory.bound.dto.OutBoundDetailDto;

@Mapper
public interface OutBoundDetailMapper {

	void insertOutboundDetail(OutBoundDetailDto OutboundDetailDto);
	
	public List<OutBoundDetailDto> selectOutboundDetailAll();
	
	Integer getStock(@Param("item_code") String item_code, @Param("storage_code") String storage_code, @Param("location_code") String location_code);
}
 