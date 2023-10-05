package com.dz.factory.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationDto {

	private int location_id;
	private String location_code;
	private String location_name;
	private String storage_name;
	private String storage_code;
}
