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
	private String company_id;
	private String item_code;
	private String production_code;
	private String quantity;
	private String line_code;
	private String production_id;
	private String description;
	private String storage_code;
	private String location_code;
	private String emp_id;
	private String partner_code;
	private String lead_time;
	private String work_force;
	private String team;	
}
