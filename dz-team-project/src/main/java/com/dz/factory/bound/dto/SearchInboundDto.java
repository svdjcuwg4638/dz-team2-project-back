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
public class SearchInboundDto {
	
	private String bound_no;
	private String bound_category;
	private String partner_code;
	private LocalDate bound_start_date;
	private LocalDate bound_end_date;
	
}
