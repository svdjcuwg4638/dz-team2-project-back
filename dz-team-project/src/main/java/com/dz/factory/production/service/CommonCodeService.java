package com.dz.factory.production.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.common.domain.Code;
import com.dz.factory.common.domain.ManageCode;
import com.dz.factory.management.mapper.CodeMapper;
import com.dz.factory.production.dto.CommonCodeDto;
import com.dz.factory.production.mapper.CommonCodeMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommonCodeService {
	
	private final CommonCodeMapper ccMapper;
	
	
	public ArrayList<CommonCodeDto> getAllTeam(){
		try {
			return ccMapper.getAllTeam();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public ArrayList<CommonCodeDto> getByCodeValue(String keyword){
		try {
			return ccMapper.getByCodeValue(keyword);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public ArrayList<CommonCodeDto> getByCodeName(String keyword){
		try {
			return ccMapper.getByCodeName(keyword);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public ArrayList<CommonCodeDto> getByAll(String keyword){
		try {
			return ccMapper.getByAll(keyword);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
}











