package com.dz.factory.storage.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovementDto {

	private int movement_id; 
	private int company_id; 
	private String item_code; 
	private String outbound_storage_code; 
	private String outbound_location_code; 
	private String inbound_storage_code; 
	private String inbound_location_code; 
	private String item_name; 
	private String outbound_storage_name; 
	private String outbound_location_name; 
	private String inbound_storage_name; 
	private String inbound_location_name; 
	private String movement_date; 
	private int movement; 
	private String description;
	private String emp_id;
	private String emp_name;

}
