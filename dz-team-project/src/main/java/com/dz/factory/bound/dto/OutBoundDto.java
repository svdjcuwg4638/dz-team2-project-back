package com.dz.factory.bound.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OutBoundDto {

	private int bound_id;
	private int company_id;
	private int emp_id;
	private String bound_no;
	private String bound_category;
	private String partner_code;
	private LocalDate bound_date;
	private String bound_type;
	private String bound_state;
	private int isDelete;
}
