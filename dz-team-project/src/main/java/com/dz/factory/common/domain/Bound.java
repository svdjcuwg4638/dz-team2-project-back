package com.dz.factory.common.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bound {

	private int bound_id;
	private int company_id;
	private int emp_id;
	private LocalDateTime bound_date;
	private String partner_code;
	private String bound_type;
	private String isDelete;
	private String bound_no;
	private String bound_state;
	
}
