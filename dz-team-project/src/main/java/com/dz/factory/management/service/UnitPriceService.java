package com.dz.factory.management.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.common.domain.UnitPrice;
import com.dz.factory.management.mapper.UnitPriceMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnitPriceService {

	private final UnitPriceMapper unitPriceMapper;

	public ArrayList<UnitPrice> getAll() {
		return unitPriceMapper.selectAll();
	}

	@Transactional
	public void addUnitPrice(UnitPrice unitPrice) {
		
		// 바로 이전것의 end_date를 수정
		UnitPrice oldData = unitPriceMapper.selOldOne(unitPrice);
		System.out.println(oldData);
		if(oldData != null && !unitPrice.getPartner_code().equals(oldData.getPartner_code())) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("id",  oldData.getUnit_price_id());
			map.put("date", unitPrice.getStart_date());
			unitPriceMapper.updateEndDate(map);
		}
		// 입력되는 날짜보다 예정되어있는 데이터가 있다면 예정되어있는 데이터의 start_date가 unitprice에 입력됨
		UnitPrice oldOverData = unitPriceMapper.selOverOldOne(unitPrice);
		if(oldOverData != null) {
			unitPrice.setEnd_date(oldOverData.getStart_date());
		}
		unitPriceMapper.insert(unitPrice);
	}

	public ArrayList<UnitPrice> getCurrentList() {
		return unitPriceMapper.currnetUnitPrice();
	}

	public ArrayList<UnitPrice> getExpectedList() {
		return unitPriceMapper.expectedPrice();
	}
}
