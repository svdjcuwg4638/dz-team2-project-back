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
public class BoundDetailDto {

	
	private int company_id;
	private int bound_id;
	private int unit_price_id;
	private int inventory_id;
	private String item_code;
	private String item_name;
	private int tot_amount;
	private String detail_state;
	private LocalDate detail_date;
	private int amount;
	private int detail_isDelete;
	private String description;
	
	
}
