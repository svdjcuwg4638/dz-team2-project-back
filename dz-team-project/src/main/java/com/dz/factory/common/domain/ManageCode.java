package com.dz.factory.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageCode {

	private int company_id;
	
	private String management_code;
	private String management_name;
	
}
