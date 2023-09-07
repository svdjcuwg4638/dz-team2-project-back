package com.dz.factory.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Code {

	private int company_id;
	
	private String management_code;
	
	private String common_code;
	private String common_name;
}
