package com.dz.factory.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CodeAll {

	private String storage_name;
	private String storage_code; 
	private String item_code; 
	private String item_name; 
}
