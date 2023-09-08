package com.dz.factory.storage.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.dz.factory.common.domain.Storage;
import com.dz.factory.storage.dto.CodeAll;
import com.dz.factory.storage.mapper.CodehelperMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CodeListService {

	private final CodehelperMapper codehelperMapper;
	
	public ArrayList<Storage> getStorageCode(){
		return codehelperMapper.selectStorageCode();
	}
}
