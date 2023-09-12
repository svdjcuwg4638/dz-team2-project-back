package com.dz.factory.production.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.dz.factory.production.dto.CodeDto;
import com.dz.factory.production.dto.CodeDto;
import com.dz.factory.production.mapper.CommonCodeMapper;
import com.dz.factory.production.mapper.ItemCodeMapper;

import lombok.RequiredArgsConstructor;

@Service("itemCodeService")
@RequiredArgsConstructor
public class ItemCodeService implements CodeService{
private final ItemCodeMapper itemMapper;
	
	public ArrayList<CodeDto> getAllCode(){
		try {
			return itemMapper.getAll();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public ArrayList<CodeDto> getByCodeValue(String keyword){
		try {
			return itemMapper.getByCodeValue(keyword);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public ArrayList<CodeDto> getByCodeName(String keyword){
		try {
			return itemMapper.getByCodeName(keyword);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public ArrayList<CodeDto> getByAll(String keyword){
		try {
			return itemMapper.getByAll(keyword);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
