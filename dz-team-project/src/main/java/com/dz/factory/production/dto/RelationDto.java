package com.dz.factory.production.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RelationDto {
	private String item_code;
	private String component_code;
	private String component_name;
	private int quantity;
}
