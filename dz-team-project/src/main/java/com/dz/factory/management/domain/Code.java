package com.dz.factory.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Code {

	private String common_code;
	private String common_name;
	private int  management_code_id;
	
}
