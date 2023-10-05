package com.dz.factory.common.domain;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Partner {

	
	@NotEmpty(message ="partner_code")
	private String partner_code;
	@NotEmpty(message ="bizNum")
	private String bizNum; 
	@NotEmpty(message ="partner_name")
	private String partner_name;
	private int company_id;
	private String representative;
	private String ph_num; 
	private String address; 
	private String address_detail;
	private String email;
	private String createdate; 
	private String post_num;
	private String company_url;
	private String account_num; 
	private String account_holder; 
	private String collect_date;
	private String account_code;
	private String fax_num;
	private int isDelete;
}
