package com.dz.factory.bound.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.bound.dto.BoundDto;
import com.dz.factory.bound.mapper.BoundMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoundService {

	private final BoundMapper boundMapper;
	
	@Transactional
	public void insertInBound(BoundDto boundDto) {
		boundMapper.insertInbound(boundDto);
	}
	
	public List<BoundDto> selectInboundAll() {
		return boundMapper.selectInboundAll();
	}
	
	public Long getMaxBoundId() {
		return boundMapper.getMaxBoundId();
	}
	
	public String getMaxBoundNo(String prefix) {
		return boundMapper.getMaxBoundNo(prefix);
	}
}
