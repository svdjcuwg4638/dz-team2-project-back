package com.dz.factory.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Partner {

	private String partner_code;
	private String bizNum; 
	private String partner_name;
	private int company_id;
	private String owner;
	private String ph_num; 
	private String add; 
	private String email;
	private String createdate; 
	private String post_num;
	private String url;
	private String account_num; 
	private String account_holder; 
	private String collect_date;
	private String account_name;
}
