package com.dz.factory.common.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UnitPrice {

	private int unit_price_id;
	private String item_code;
	private String partner_code;
	private String unit_price;
	private LocalDate start_date;
	private LocalDate end_date;
	private String type;
	private int company_id;
	
}
