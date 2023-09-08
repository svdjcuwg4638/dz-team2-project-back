package com.dz.factory.management.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.Code;
import com.dz.factory.common.domain.ManageCode;

@Mapper
public interface CodeMapper {

	ArrayList<Code> selCodeAll();

	ArrayList<ManageCode> selManageCodeAll();

	void insertCode(Code data);

	void insertManageCode(ManageCode data);

	ArrayList<ManageCode> selManageSearchAll(HashMap<String, Object> codes);

	void deleteManageCode(String code);

	ArrayList<ManageCode> selSearchCodeList(HashMap<String, Object> codes);

	void deleteCode(String code);

}
