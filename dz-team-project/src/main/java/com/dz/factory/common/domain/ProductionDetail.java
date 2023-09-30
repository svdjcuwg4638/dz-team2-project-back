package com.dz.factory.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionDetail {
	private int company_id;
	private String production_code;
	private int quantity;
	private String description;
	private int isDelete;
	private String lead_time;
	private int work_force;
	private String team_code;
	private String line_code;
	private String location_code;
	private String storage_code;
	private int emp_id;
	private String partner_code;
	private String item_code;

}
