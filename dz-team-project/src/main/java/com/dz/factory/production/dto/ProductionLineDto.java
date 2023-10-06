package com.dz.factory.production.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductionLineDto {
	private String line_code;
	private String line_name;
	private String company_id;
	private String emp_id;
	private String uses;
	private String place;
	private String description;
	private String emp_name;
}
