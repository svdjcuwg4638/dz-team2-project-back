package com.dz.factory.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Movement {

	private int movement_id; 
	private int company_id; 
	private String item_code; 
	private String outbound_storage_code; 
	private String outbound_location_code; 
	private String inbound_storage_code; 
	private String inbound_location_code; 
	private String movement_date; 
	private int movement; 
	private String description;
	private String emp_id;
}
