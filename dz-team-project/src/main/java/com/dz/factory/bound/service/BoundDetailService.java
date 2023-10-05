package com.dz.factory.bound.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.bound.dto.BoundDetailDto;
import com.dz.factory.bound.mapper.BoundDetailMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoundDetailService {

	private final BoundDetailMapper boundDetailMapper;
	
	@Transactional
	public void insertInboundDetail(BoundDetailDto boundDetailDto) {
		boundDetailMapper.insertInboundDetail(boundDetailDto);
	}
	
	public List<BoundDetailDto> selectInboundDetailAll(){
		return boundDetailMapper.selectInboundDetailAll();
	}
	
	public void updateByDetailId (BoundDetailDto boundDetailDto) {
		boundDetailMapper.updateByDetailId(boundDetailDto);
	}
	
	
}
