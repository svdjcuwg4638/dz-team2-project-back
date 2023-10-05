package com.dz.factory.common.domain;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Item {

	@NotEmpty(message = "item_code")
	private String item_code;
	@NotNull(message = "company_id")
	private String company_id;
	@NotEmpty(message = "item_name")
	private String item_name;
	private LocalDateTime registDate;
	private String category;
	private String description;
	private String width;
	private String length;
	private String height;
	private String volume;
	private String weight;
	private String unit;

	@NotEmpty(message = "storage_code")
	private String storage_code;
	@NotEmpty(message = "location_code")
	private String location_code;
	private int isDelete;
	private String unit_price;
	private String type;
	private String standard;

}
