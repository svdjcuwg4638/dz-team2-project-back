package com.dz.factory.common.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.dz.factory.common.dto.CommonHelpDto;
import com.dz.factory.common.dto.HelpResultDto;
import com.dz.factory.common.mapper.CommonHelpMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonHelpService {
	
	private final CommonHelpMapper commonHelpMapper;
	
	
	public ArrayList<?> searchHelp(CommonHelpDto data) {
		ArrayList<HelpResultDto> list = new ArrayList<>();
		String flag = data.getCodeType();
		if(flag.equalsIgnoreCase("item")) {
			data.setTableName("item");
			data.setColumn_code("item_code");
			data.setColumn_name("item_name");
			ArrayList<HashMap<String, Object>> listMap = commonHelpMapper.getValue(data);
			for(HashMap<String, Object> map : listMap) {
				HelpResultDto dto = new HelpResultDto();
				dto.setCode((String)map.get("item_code"));
				dto.setCode_name((String)map.get("item_name"));
				list.add(dto);
			}
		}
		return list;
	}

}
