package com.dz.factory.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryForm {

	private String storageCode; 
	private String storage; 
	private String locationCode; 
	private String location; 
	private String categoryCode;
	private String category; 
	private String unit; 
	private String itemCode; 
	private String item; 
}
