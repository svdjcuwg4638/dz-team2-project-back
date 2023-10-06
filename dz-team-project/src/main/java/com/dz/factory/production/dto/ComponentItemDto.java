package com.dz.factory.production.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComponentItemDto {
	private String item_code;
	private String item_name;
	private String quantity;
	private String storage_code;
	private String storage_name;
	private String location_code;
	private String location_name;
	private String total;
	private String description;
}

