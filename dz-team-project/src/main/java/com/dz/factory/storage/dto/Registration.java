package com.dz.factory.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Registration {

	private String item; 
	private String itemName; 
	private String location; 
	private String locationName; 
	private String standard; 
	private String storage; 
	private String storageName; 
	private String total;
	private String unit; 
	
}
