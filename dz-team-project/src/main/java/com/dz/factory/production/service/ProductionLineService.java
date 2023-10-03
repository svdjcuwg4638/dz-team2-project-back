package com.dz.factory.production.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.ProductionLine;
import com.dz.factory.production.dto.ComponentDto;
import com.dz.factory.production.dto.ProductionDetailDto;
import com.dz.factory.production.dto.ProductionDto;
import com.dz.factory.production.mapper.ProductionLineMapper;
import com.dz.factory.production.mapper.ProductionListMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductionLineService {
	private final ProductionLineMapper lineMapper;
	
	public ArrayList<ProductionLine> getAllLine(){
		return lineMapper.getAllLine();
		
	}
	
}
