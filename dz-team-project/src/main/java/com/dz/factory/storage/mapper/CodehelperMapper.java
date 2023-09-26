package com.dz.factory.storage.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.Storage;
import com.dz.factory.storage.dto.CodeAll;

@Mapper
public interface CodehelperMapper {

	ArrayList<Storage> selectStorageCode();
	}
