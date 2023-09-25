package com.dz.factory.management.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.common.aes.AESUtil;
import com.dz.factory.common.domain.Partner;
import com.dz.factory.management.mapper.PartnerMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PartnerService {

	private final PartnerMapper partnerMapper;
	private final AESUtil aesUtil;
	
	@Transactional
	public int insert(Partner partner) {
		
		Partner searchCode = partnerMapper.getSameCode(partner.getPartner_code());
		if(searchCode != null) {
			if(searchCode.getIsDelete() == 1) {
				try {
					partner.setIsDelete(0);
					partner.setBizNum(aesUtil.encrypt(partner.getBizNum()));
					partnerMapper.updatePartner(partner);
					return 1;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}else {
				return 2;
			}
		}else {
			try {
				partner.setBizNum(aesUtil.encrypt(partner.getBizNum()));
				partnerMapper.insertPartner(partner);
				return 1;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

    public ArrayList<Partner> selAllPartner() {
        ArrayList<Partner> partners = partnerMapper.seletAllPartner();
        for (Partner partner : partners) {
            try {
                String decryptedBizNum = aesUtil.decrypt(partner.getBizNum());
                partner.setBizNum(decryptedBizNum);
            } catch (Exception e) {
            }
        }
        return partners;
    }

	@Transactional
	public void delete(List<String> codes) {
		for (String code : codes) {
			partnerMapper.deletePartner(code);
		}
	}

	public ArrayList<Partner> search(HashMap<String, String> search) {
		return partnerMapper.selectSearchPartner(search);
	}

	public void modify(Partner partner) {
		partnerMapper.updatePartner(partner);
	}

}
