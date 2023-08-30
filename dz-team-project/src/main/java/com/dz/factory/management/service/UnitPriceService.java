package com.dz.factory.management.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

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

	public void addUnitPrice(UnitPrice unitPrice) {
		unitPriceMapper.insert(unitPrice);
	}
}
