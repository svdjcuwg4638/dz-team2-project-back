package com.dz.factory.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Storage {

	private String storage_code;
	
	private String storage_name;
	
	private int company_id;
	
	
}
