package com.dz.factory.production.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionDetailDto {
	private int company_id;
	private String item_code;
	private int quantity;
	private String line_code;
	private int production_id;
	private String description;
	private String storage_code;
	private String location_code;
	private int emp_id;
	private String partner_code;
	private String lead_time;
	private int work_force;
	private String team;	
}
