package com.dz.factory.management.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Storage {

	private int storage_id;
	
	private String storage_name;
	
	private int company_id;
	
	
}
