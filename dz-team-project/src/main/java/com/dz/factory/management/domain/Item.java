package com.dz.factory.management.domain;

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

	private int item_id;
	private String item_name;
	private int location_id;
	private LocalDateTime registDate;
	private String itemSKU; 
	private int storage_id;
	private int company_id;
	private int partner_id;
	private String category;
	
	private String item_code;
	private String width;
	private String length;
	private String height;
	private String volume;
	private String weight;
	private String discription;
	private String partner_code;
}
