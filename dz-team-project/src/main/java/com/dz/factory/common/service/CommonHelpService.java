package com.dz.factory.common.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.dz.factory.common.dto.CommonHelpDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonHelpService {
	
	
	public ArrayList<?> searchHelp(CommonHelpDto data) {
		String flag = data.getCodeType();
		
		return null;
	}

}
