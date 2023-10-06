package com.dz.factory.bound.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.bound.dto.OutBoundDto;
import com.dz.factory.bound.mapper.OutBoundMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OutBoundService {
	
	private final OutBoundMapper outBoundMapper;
	
	@Transactional
	public void insertOutBound(OutBoundDto outboundDto) {
		outBoundMapper.insertOutbound(outboundDto);
	}
	
	public List<OutBoundDto> selectOutboundAll() {
		return outBoundMapper.selectOutboundAll();
	}
	
	public Long getMaxBoundId() {
		return outBoundMapper.getMaxBoundId();
	}
	
	
}
