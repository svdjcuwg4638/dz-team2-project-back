package com.dz.factory.management.api;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.dz.factory.common.domain.Bound;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoundService {

	private final BoundMapper boundMapper;

	public int getBound_id(int i) {
		int result = 1 ;
		
		HashMap<String, Integer> top_bound_Id =  boundMapper.getFind_id(i);
		
		if(top_bound_Id != null && top_bound_Id.get("top_bound_Id") != null) {
			result = top_bound_Id.get("top_bound_Id") + 1;
		}
		
		return result ;
	}
	
}
