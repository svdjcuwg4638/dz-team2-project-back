package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomValidationException extends RuntimeException{

	// 시리얼번호는 객체를 구분할때 사용된다
	private static final long serialVersionUID = 1L;

	private Map<String, String> errorMap;
	
	public CustomValidationException(String massage,  Map<String, String> errorMap) {
		super(massage); // 메세지는 부모에게 넘김(Exception)
		this.errorMap = errorMap;
	}
	
	public Map<String, String> getErrorMap(){
		return errorMap;
	}
}
