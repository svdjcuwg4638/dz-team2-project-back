package com.dz.factory.production.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.production.dto.ComponentDto;
import com.dz.factory.production.dto.ProductionDetailDto;
import com.dz.factory.production.dto.ProductionDto;
import com.dz.factory.production.mapper.ProductionListMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductionListService {
	private final ProductionListMapper listMapper;

	//생산내역 조회
	public HashMap<String,ArrayList<?>> getProductionList(HashMap<String, ?> searchFilter) {
		System.out.println(searchFilter);
		ArrayList<HashMap<String, ?>> productionList = new ArrayList<>();

		productionList = listMapper.getProductionList(searchFilter);
		//production 받아온 후 code array get
		ArrayList<String> productionCode = new ArrayList<String>();
		for(HashMap<String,?> map : productionList) {
			productionCode.add((map.get("production_code")).toString());
		}
		//production code로 select 쿼리
		ArrayList<ArrayList<HashMap<String,?>>> componentList = new ArrayList<ArrayList<HashMap<String,?>>>();
		for(String code : productionCode) {
			
			componentList.add(listMapper.getComponentList(code));
		}
		
		HashMap<String,ArrayList<?>> result=new HashMap<String,ArrayList<?>>();
		result.put("production", productionList);
		result.put("component", componentList);
		
		return result;
	}

	//생산내역 수정
	@Transactional
	public void updateProductionList(HashMap<String, ?> searchFilter) {
		System.out.println(searchFilter);

		if (searchFilter.get("production")!=null) {
			editProduction((ArrayList) (searchFilter.get("production")));
		}
		if (searchFilter.get("component")!=null) {
			editComponent((ArrayList) searchFilter.get("component"));
		}
		if (searchFilter.get("productionDelete")!=null) {
			deleteProduction((ArrayList) searchFilter.get("productionDelete"));
		}
	}
	
	//production 수정
	public void editProduction(ArrayList<HashMap<String,?>> edited) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
	
		//production table
		ArrayList<Integer> productionIdList =new ArrayList<Integer>();
		for(HashMap<String,?> data : edited) {
			ProductionDto productionDto = new ProductionDto();
			ProductionDetailDto detailDto = new ProductionDetailDto();
		
			
			Integer productionId = (Integer) data.get("companyId");
			productionDto.setCompany_id(productionId != null ? productionId : 0);
			
			productionDto.setProduction_date(String.valueOf(data.get("date")));
			productionDto.setProduction_code(String.valueOf(data.get("productionCode")));
			
			listMapper.updateProduction(productionDto);
			
		}
		
		//production_detail table
		for(int i=0;i<edited.size();i++) {
			ProductionDetailDto detailDto = new ProductionDetailDto();
			
			Integer companyId = (Integer) edited.get(i).get("companyId");
			detailDto.setCompany_id(companyId != null ? companyId : 0);
			Integer productionId = (Integer) edited.get(i).get("productionId");
			detailDto.setProduction_id(productionId != null ? productionId : 0);
			detailDto.setItem_code((String) edited.get(i).get("itemCode"));
			
			detailDto.setQuantity(Integer.parseInt((edited.get(i).get("quantity")).toString()));
			detailDto.setLine_code((String) edited.get(i).get("lineCode"));
			detailDto.setDescription((String) edited.get(i).get("description"));
			detailDto.setStorage_code((String) edited.get(i).get("storageCode"));
			detailDto.setLocation_code((String) edited.get(i).get("locationCode"));
			detailDto.setEmp_id(Integer.parseInt(edited.get(i).get("empId").toString()));
			detailDto.setPartner_code((String) edited.get(i).get("partnerCode"));
			detailDto.setLead_time((String) edited.get(i).get("leadTime"));
			if(!((String)edited.get(i).get("workForce")).isEmpty()) {
				detailDto.setWork_force(Integer.parseInt(edited.get(i).get("workForce").toString()));
			}
			detailDto.setTeam((String) edited.get(i).get("teamCode"));
			
			listMapper.updateDetail(detailDto);
		}			
	}
	//자재 수정
	public void editComponent(ArrayList<HashMap<String,?>> component) {
		//production_detail_component table
		ArrayList<ComponentDto> componentList = new ArrayList();
		for(int i=0; i<component.size(); i++) {				
			ComponentDto componentDto = new ComponentDto();
			
			Integer companyId = (Integer) component.get(i).get("companyId");
			componentDto.setCompany_id(companyId != null ? companyId : 0);

			String itemCode = (String) component.get(i).get("itemCode");
			String locationCode = (String) component.get(i).get("locationCode");
			String storageCode = (String) component.get(i).get("storageCode");
			String productionCode = (String) component.get(i).get("productionCode");

			Integer productionIdInteger = (Integer) component.get(i).get("productionId");
			int productionId = productionIdInteger != null ? productionIdInteger : 0;

			Integer quantityInteger = (Integer) component.get(i).get("quantity");
			int quantity = quantityInteger != null ? quantityInteger : 0;

			
			componentDto.setItem_code(itemCode);
			componentDto.setLocation_code(locationCode);
			componentDto.setStorage_code(storageCode);
			componentDto.setQuantity(quantity);
				
			listMapper.updateComponent(componentDto);
		}	
	}
	
	//생산내역 삭제
	public void deleteProduction(ArrayList<HashMap<String,?>> delete) {
		for(HashMap<String,?> data : delete) {
			ProductionDto productionDto = new ProductionDto();

			Integer companyId = (Integer) data.get("companyId");
			productionDto.setCompany_id(companyId != null ? companyId : 0);

			Integer productionIdInteger = (Integer) data.get("productionId");
			productionDto.setProduction_id(productionIdInteger != null ? productionIdInteger : 0);

			productionDto.setProduction_code(String.valueOf(data.get("productionCode")));

			System.out.println("======delete======");
			System.out.println(productionDto);
			listMapper.deleteProduction(productionDto);

		}
	}
}
