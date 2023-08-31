package com.dz.factory.management.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.common.domain.Partner;
import com.dz.factory.management.mapper.PartnerMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PartnerService {

	private final PartnerMapper partnerMapper;

	@Transactional
	public void insert(Partner partner) {
		partnerMapper.insertPartner(partner);
	}

	public ArrayList<Partner> selAllPartner() {
		return partnerMapper.seletAllPartner();
	}

	@Transactional
	public void delete(List<String> codes) {
		for(String code : codes) {
			partnerMapper.deletePartner(code);
		}
	}

	public ArrayList<Partner> search(HashMap<String, String> search) {
		return partnerMapper.selectSearchPartner(search);
	}
	
	
}
