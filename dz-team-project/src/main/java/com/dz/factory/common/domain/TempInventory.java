package com.dz.factory.common.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TempInventory {
	private int temp_inventory_id;
	private int company_id;
	private String item_code;
	private int total;
	private String storage_code;
	private String location_code;
}
