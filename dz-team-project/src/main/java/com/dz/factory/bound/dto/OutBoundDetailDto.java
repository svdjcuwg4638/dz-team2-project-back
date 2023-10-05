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
public class OutBoundDetailDto {

	private int detail_id;
	private int bound_id;
	private String item_code;
	private String item_name;
	private int unit_price;
	private int stock;
	private int amount;
	private String tot_amount;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate detail_date;
	private String storage_code;
	private String location_code;
	private String description;
	private String detail_state;
	private int detail_isDelete;
	private String detail_type;
}
