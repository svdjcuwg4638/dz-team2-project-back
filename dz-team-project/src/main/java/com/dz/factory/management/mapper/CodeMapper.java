package com.dz.factory.management.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.management.domain.Code;
import com.dz.factory.management.domain.ManageCode;

@Mapper
public interface CodeMapper {

	ArrayList<Code> selCodeAll();

	ArrayList<ManageCode> selManageCodeAll();

	void insertCode(Code data);

	void insertManageCode(ManageCode data);

}
