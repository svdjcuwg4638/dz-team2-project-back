package com.dz.factory.bound.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.bound.dto.BoundDto;
import com.dz.factory.bound.dto.SearchInboundDetailDto;
import com.dz.factory.bound.dto.SearchInboundDto;
import com.dz.factory.bound.mapper.SearchBoundMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SearchBoundService {
	private final SearchBoundMapper searchBoundMapper;
	
	@Transactional
	public List<BoundDto> searchBounds(SearchInboundDto searchInboundDto){
		return searchBoundMapper.searchBounds(searchInboundDto);
	}
	
	public List<BoundDto> searchOutBounds(SearchInboundDto searchInboundDto){
		return searchBoundMapper.searchOutBounds(searchInboundDto);
	}
	
	public List<BoundDto> searchBoundDetailsWithMaster(SearchInboundDetailDto searchInboundDetailDto){
		return searchBoundMapper.searchBoundDetailsWithMaster(searchInboundDetailDto);
	}
}
