package com.dz.factory.production.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CodeDto {
	private String management_code;
	private String management_name;
}
