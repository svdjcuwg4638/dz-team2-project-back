package com.dz.factory.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Location {
	private String location_code;
	private int company_id;
	private String storage_code;
	private String location_name;
	private String storage_name;
}
