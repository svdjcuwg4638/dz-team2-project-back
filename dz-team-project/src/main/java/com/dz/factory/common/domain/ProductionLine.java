package com.dz.factory.common.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductionLine {
	private String line_code;
	private String line_name;
	private int company_id;
	private int emp_id;
	private String state;
	private String uses;
	private String place;
	private String description;
	private int isDelete;
}
