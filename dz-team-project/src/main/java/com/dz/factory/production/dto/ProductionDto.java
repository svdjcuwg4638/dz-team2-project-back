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
public class ProductionDto {
	private String production_code;
	private int company_id;
	private String production_date;
	private int production_id;
}
