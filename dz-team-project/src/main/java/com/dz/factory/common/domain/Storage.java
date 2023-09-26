package com.dz.factory.common.domain;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Storage {

	@NotEmpty(message = "storage_code")
	private String storage_code;
	
	@NotEmpty(message = "storage_name")
	private String storage_name;
	private int company_id;
	
	private int isDelete;
	
	
}
