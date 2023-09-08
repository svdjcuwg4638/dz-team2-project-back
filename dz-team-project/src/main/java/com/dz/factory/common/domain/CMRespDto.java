package com.dz.factory.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CMRespDto<T> {

	private int code; // 1성공 , -1실패
	private String message;
	private T data;
}
