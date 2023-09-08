package com.dz.factory.production.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CodeDto {
	private String common_code;
	private String common_name;
}
