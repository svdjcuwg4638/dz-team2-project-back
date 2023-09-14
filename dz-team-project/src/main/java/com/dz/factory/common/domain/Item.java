package com.dz.factory.common.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Item {
	
	private String location_code;
	private String storage_code; 
	private String item_code;
	private int company_id;
	private String item_name;
	private LocalDateTime registDate;
	private String category;
	private String description;
	private String partner_code;
	private String width;
	private String length;
	private String height;
	private String volume;
	private String weight;
	private String unit;
	private String unit_price;
	private String type;
}
