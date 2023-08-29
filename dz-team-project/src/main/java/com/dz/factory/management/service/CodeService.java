package com.dz.factory.management.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.management.domain.Code;
import com.dz.factory.management.domain.ManageCode;
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

	public void addManageCode(ManageCode data) {
		codeMapper.insertManageCode(data);
	}
	
}
