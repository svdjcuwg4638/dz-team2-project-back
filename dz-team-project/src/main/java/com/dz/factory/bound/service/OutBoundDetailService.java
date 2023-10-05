package com.dz.factory.bound.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dz.factory.bound.dto.OutBoundDetailDto;
import com.dz.factory.bound.mapper.OutBoundDetailMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OutBoundDetailService {

private final OutBoundDetailMapper outBoundDetailMapper;
	
	@Transactional
	public void insertOutboundDetail(OutBoundDetailDto outboundDetailDto) {
		outBoundDetailMapper.insertOutboundDetail(outboundDetailDto);
	}
	
	public List<OutBoundDetailDto> selectOutboundDetailAll(){
		return outBoundDetailMapper.selectOutboundDetailAll();
	}
	
	public Integer getStock(String item_code, String storage_code, String location_code) {
		return outBoundDetailMapper.getStock(item_code, storage_code, location_code);
	}
}
