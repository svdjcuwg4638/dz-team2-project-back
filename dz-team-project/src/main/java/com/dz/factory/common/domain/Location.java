package com.dz.factory.common.domain;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Location {
	private int company_id;
	
	@NotEmpty(message="location_code")
	private String location_code;
	
	@NotEmpty(message="storage_code")
	private String storage_code;
	
	@NotEmpty(message="location_name")
	private String location_name;
	
	private int isDelete;
}
