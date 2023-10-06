package com.dz.factory.bound.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.bound.dto.BoundDto;
import com.dz.factory.bound.dto.SearchInboundDetailDto;
import com.dz.factory.bound.dto.SearchInboundDto;

@Mapper
public interface SearchBoundMapper {

	public List<BoundDto> searchBounds(SearchInboundDto searchInboundDto);
	
	public List<BoundDto> searchOutBounds(SearchInboundDto searchInboundDto);
	
	public List<BoundDto> searchBoundDetailsWithMaster(SearchInboundDetailDto searchInboundDetailDto);
}
