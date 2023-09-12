package com.dz.factory.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonHelpDto {

	private String searchOption ;
	private String keyword;
	private String codeType;
	private String tableName;
	private String column_name;
	private String column_code;
	private String forCommonType;
	
}
