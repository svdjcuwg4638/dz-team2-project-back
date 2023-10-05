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
		if (flag.equalsIgnoreCase("item")) {
			data.setTableName("item");
			data.setColumn_code("item_code");
			data.setColumn_name("item_name");
			ArrayList<HashMap<String, Object>> listMap = commonHelpMapper.getValue(data);
			for (HashMap<String, Object> map : listMap) {
				HelpResultDto dto = new HelpResultDto();
				dto.setCode((String) map.get("item_code"));
				dto.setCode_name((String) map.get("item_name"));
				list.add(dto);
			}
		} else if (flag.equalsIgnoreCase("partner")) {
			data.setTableName("partner");
			data.setColumn_code("partner_code");
			data.setColumn_name("partner_name");
			ArrayList<HashMap<String, Object>> listMap = commonHelpMapper.getValue(data);
			for (HashMap<String, Object> map : listMap) {
				HelpResultDto dto = new HelpResultDto();
				dto.setCode((String) map.get("partner_code"));
				dto.setCode_name((String) map.get("partner_name"));
				list.add(dto);
			}
		} else if (flag.equalsIgnoreCase("storage")) {
			data.setTableName("storage");
			data.setColumn_code("storage_code");
			data.setColumn_name("storage_name");
			ArrayList<HashMap<String, Object>> listMap = commonHelpMapper.getValue(data);
			for (HashMap<String, Object> map : listMap) {
				HelpResultDto dto = new HelpResultDto();
				dto.setCode((String) map.get("storage_code"));
				dto.setCode_name((String) map.get("storage_name"));
				list.add(dto);
			}
		} else if (flag.equalsIgnoreCase("location")) {
			data.setTableName("detail_location");
			data.setColumn_code("location_code");
			data.setColumn_name("location_name");
			ArrayList<HashMap<String, Object>> listMap = commonHelpMapper.getValue(data);
			for (HashMap<String, Object> map : listMap) {
				HelpResultDto dto = new HelpResultDto();
				dto.setCode((String) map.get("location_code"));
				dto.setCode_name((String) map.get("location_name"));
				list.add(dto);
			}
		} else if (flag.equalsIgnoreCase("line")) {
			data.setTableName("production_line");
			data.setColumn_code("line_code");
			data.setColumn_name("line_name");
			ArrayList<HashMap<String, Object>> listMap = commonHelpMapper.getValue(data);
			for (HashMap<String, Object> map : listMap) {
				HelpResultDto dto = new HelpResultDto();
				dto.setCode((String) map.get("line_code"));
				dto.setCode_name((String) map.get("line_name"));
				list.add(dto);
			}
		} else if (flag.equalsIgnoreCase("emp")) {
			data.setTableName("emp");
			data.setColumn_code("emp_id");
			data.setColumn_name("emp_name");
			ArrayList<HashMap<String, Object>> listMap = commonHelpMapper.getValue(data);
			for (HashMap<String, Object> map : listMap) {
				HelpResultDto dto = new HelpResultDto();
				dto.setCode(String.valueOf( map.get("emp_id")));
				dto.setCode_name((String) map.get("emp_name"));
				list.add(dto);
			}
		}else {
			data.setTableName("code_common");
			data.setColumn_code("common_code");
			data.setColumn_name("common_name");
			data.setForCommonType(flag.toUpperCase());
			ArrayList<HashMap<String, Object>> listMap = commonHelpMapper.getValue(data);
			for (HashMap<String, Object> map : listMap) {
				HelpResultDto dto = new HelpResultDto();
				dto.setCode((String) map.get("common_code"));
				dto.setCode_name((String) map.get("common_name"));
				list.add(dto);
			}
		}
		return list;
	}

}
