package com.dz.factory.management.service;

import java.util.ArrayList;

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
	public int addCode(Code data) {
		Code sameOne = codeMapper.selSameOne(data);
		if(sameOne != null) {
			return 0;
		}else {
			codeMapper.insertCode(data);
			return 1;
		}
	}

	@Transactional
	public void delCode(ArrayList<Code> codes) {
		for(Code code : codes) {
			codeMapper.deleteCode(code);
		}
	}
	
}
