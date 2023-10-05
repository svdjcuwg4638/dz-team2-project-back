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
public class SearchInboundDetailDto {
	
	private String item_code;
	private String item_name;
	private LocalDate detail_start_date;
	private LocalDate detail_end_date;
}
