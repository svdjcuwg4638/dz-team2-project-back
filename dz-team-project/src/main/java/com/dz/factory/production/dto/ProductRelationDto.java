package com.dz.factory.production.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ProductRelationDto {
	private int relation_id;
	private String item_code;
	private int quantity;
	private String component_code;

}
