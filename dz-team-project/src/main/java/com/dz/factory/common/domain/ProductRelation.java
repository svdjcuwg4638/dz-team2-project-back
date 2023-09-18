package com.dz.factory.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class ProductRelation {

	private int relation_id;
	private String item_code;
	private int company_id;
	private String component_code;
	private int quantity;

	
	
}
