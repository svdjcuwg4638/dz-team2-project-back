package com.dz.factory.production.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComponentDto {
	private String production_code;
	private String item_code;	
	private String company_id;
	private String production_id;
	private String location_code;
	private String storage_code;
	private String quantity;
}
