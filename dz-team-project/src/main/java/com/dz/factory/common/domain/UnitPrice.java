package com.dz.factory.common.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnitPrice {

	private int unit_price_id;
	
	@NotEmpty(message="itme_code")
	private String item_code;
	@NotEmpty(message="partner_code")
	private String partner_code;
	@NotEmpty(message="unit_price")
	private String unit_price;
	@NotNull(message="start_date")
	private LocalDate start_date;
	private LocalDate end_date;
	@NotEmpty(message="type")
	private String type;
	private int company_id;
	private int isDelete;
	
}
