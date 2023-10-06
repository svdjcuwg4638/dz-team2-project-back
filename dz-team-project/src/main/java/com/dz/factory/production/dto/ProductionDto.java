package com.dz.factory.production.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionDto {
	private String production_code;
	private String company_id;
	private String production_date;
	private String production_id;
}
