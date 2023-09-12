package com.dz.factory.production.service;

import java.util.ArrayList;

import com.dz.factory.production.dto.CodeDto;

public interface CodeService {
	public ArrayList<CodeDto> getAllCode();
	public ArrayList<CodeDto> getByCodeValue(String keyword);
	public ArrayList<CodeDto> getByCodeName(String keyword);
	public ArrayList<CodeDto> getByAll(String keyword);
}
