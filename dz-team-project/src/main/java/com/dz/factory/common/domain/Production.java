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
public class Production {
	private int production_id;
	private String production_code;
	private int company_id;
	private LocalDate production_date;
	private int isDelete;

}
