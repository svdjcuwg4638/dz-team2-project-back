package com.dz.factory.production.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.common.domain.Code;
import com.dz.factory.common.domain.ManageCode;
import com.dz.factory.management.mapper.CodeMapper;
import com.dz.factory.production.mapper.CommonCodeMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommonCodeService {
	
	private final CommonCodeMapper ccMapper;
	
	
	public ArrayList<Code> getAllTeamCode(){
		try {
			return ccMapper.selectAllTeam();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public ArrayList<Code> getByCodeValue(String keyword){
		try {
			return ccMapper.getByCodeValue(keyword);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public ArrayList<Code> getByCodeName(String keyword){
		try {
			return ccMapper.getByCodeName(keyword);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public ArrayList<Code> getByAll(String keyword){
		try {
			return ccMapper.getByAll(keyword);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
}











