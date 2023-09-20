package com.dz.factory.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryDto {

	private int inventory_id; 
	private int total; 
	private String item_code;
	private String storage_code; 
	private String location_code;
	
	private int production_id;
	private int bound_id; 
	private int company_id;
	
	private String item_name; 
	private String category; 
	private String width; 
	private String length; 
	private String height; 
	private String volume; 
	private String weight; 
	private String storage_name;
	private String location_name;
	private String unit;
	
	private String standard;
	}
