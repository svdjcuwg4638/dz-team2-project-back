package com.dz.factory.main.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.main.mapper.MainMapper;
import com.dz.factory.production.dto.ComponentDto;
import com.dz.factory.production.dto.ProductionDetailDto;
import com.dz.factory.production.dto.ProductionDto;
import com.dz.factory.production.mapper.ProductionListMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainService {
	private final MainMapper mainMapper;

	//생산내역 조회
	public HashMap<String,Integer> getSummary(){
		HashMap<String,Integer> result = new HashMap<String,Integer>();
		
		result.put("inventory", mainMapper.getInventoryByDate());
		result.put("outBound", mainMapper.getOutBoundByDate());
		result.put("inBound", mainMapper.getInboundByDate());
		result.put("production", mainMapper.getProductionByDate());
		
		return result;
	}

	
}
