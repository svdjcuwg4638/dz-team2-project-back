package com.dz.factory.management.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.common.domain.Code;
import com.dz.factory.common.domain.ManageCode;
import com.dz.factory.management.mapper.CodeMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CodeService {

	private final CodeMapper codeMapper;

	public ArrayList<Code> getAllCode() {
		return codeMapper.selCodeAll();
	}

	public ArrayList<ManageCode> getAllManageCode() {
		return codeMapper.selManageCodeAll();
	}

	@Transactional
	public void addCode(Code data) {
		codeMapper.insertCode(data);
	}

	@Transactional
	public void addManageCode(ManageCode data) {
		codeMapper.insertManageCode(data);
	}

	public ArrayList<ManageCode> getSearchList(HashMap<String, Object> codes) {
		return codeMapper.selManageSearchAll(codes);
	}

	@Transactional
	public void delManageCode(List<String> codes) {
		for(String code : codes) {
			codeMapper.deleteManageCode(code);
		}
	}

	public ArrayList<ManageCode> getSearchCodeList(HashMap<String, Object> codes) {
		return codeMapper.selSearchCodeList(codes);
	}

	@Transactional
	public void delCode(List<String> codes) {
		for(String code : codes) {
			codeMapper.deleteCode(code);
		}
	}
	
}
