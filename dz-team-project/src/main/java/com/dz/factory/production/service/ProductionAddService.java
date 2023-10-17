package com.dz.factory.production.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.common.domain.Inventory;
import com.dz.factory.common.domain.Item;
import com.dz.factory.common.domain.ProductRelation;
import com.dz.factory.production.dto.ComponentDto;
import com.dz.factory.production.dto.ComponentItemDto;
import com.dz.factory.production.dto.ProductionDetailDto;
import com.dz.factory.production.dto.ProductionDto;
import com.dz.factory.production.dto.RelationDto;
import com.dz.factory.production.mapper.ProductionAddMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductionAddService {

	private final ProductionAddMapper addMapper;
	
	//productionCode 조회
	public String getMaxProductionCode(String prefix) {
		if(addMapper.getMaxProductionCode(prefix)==null) {
			//System.out.println("NO DATE");
			return "P".concat(prefix.concat("5554"));
		}else{
			return addMapper.getMaxProductionCode(prefix);
		}
	}
	
	//item 으로 필요한 것 전부 조회
	public List<ComponentItemDto> getComponentItems(String itemCode){		
		return addMapper.getComponentItems(itemCode);
	}
	
	//relation 조회
	public List<RelationDto> getRelation (String itemCode){
		return addMapper.getRelation(itemCode);
	};
	
	//재고 조회
	public List<Inventory> getInventory (String itemCode, String storageCode, String locationCode){
		return addMapper.getInventory(itemCode, storageCode, locationCode);
	}
	
	//생산 등록
	@Transactional
	public void addProduction(HashMap<String,?> addData) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		
		ArrayList<HashMap> production= (ArrayList) addData.get("production");
		ArrayList<ArrayList<HashMap>> component=(ArrayList) addData.get("component");
	
		
		//production table
		ArrayList<ProductionDto> productionList = new ArrayList<ProductionDto>();
		ArrayList<Integer> productionIdList =new ArrayList<Integer>();
		for(HashMap data : production) {
			ProductionDto productionDto = new ProductionDto();
			ProductionDetailDto detailDto = new ProductionDetailDto();
		
			productionDto.setCompany_id((int) data.get("companyId"));
			productionDto.setProduction_date(String.valueOf(data.get("date")));
			productionDto.setProduction_code(String.valueOf(data.get("productionCode")));
			
			addMapper.addProduction(productionDto);
			productionList.add(productionDto);
			
		}
		
		
		//production_detail table
		ArrayList<ProductionDetailDto> detailList = new ArrayList<ProductionDetailDto>();
		for(int i=0;i<production.size();i++) {
			ProductionDetailDto detailDto = new ProductionDetailDto();
			detailDto.setCompany_id((int) production.get(i).get("companyId"));
			detailDto.setItem_code((String) production.get(i).get("itemCode"));
			detailDto.setProduction_code((String) production.get(i).get("productionCode"));
			detailDto.setQuantity(Integer.parseInt((production.get(i).get("quantity")).toString()));
			detailDto.setLine_code((String) production.get(i).get("lineCode"));
			detailDto.setDescription((String) production.get(i).get("description"));
			detailDto.setStorage_code((String) production.get(i).get("storageCode"));
			detailDto.setLocation_code((String) production.get(i).get("locationCode"));
			detailDto.setEmp_id(Integer.parseInt(production.get(i).get("empCode").toString()));
			detailDto.setPartner_code((String) production.get(i).get("partnerCode"));
			detailDto.setLead_time((String) production.get(i).get("leadTime"));
			if(!((String)production.get(i).get("workForce")).isEmpty()) {
				detailDto.setWork_force(Integer.parseInt(production.get(i).get("workForce").toString()));
			}
			detailDto.setTeam((String) production.get(i).get("teamCode"));
			detailDto.setProduction_id(productionList.get(i).getProduction_id());
			
			//production_detail_component table
			ArrayList<ComponentDto> componentList = new ArrayList();
			for(int j=0; j<component.get(i).size(); j++) {				
				ComponentDto componentDto = new ComponentDto();
				
				componentDto.setCompany_id((int) production.get(i).get("companyId"));

				String itemCode = (component.get(i).get(j).get("itemCode")).toString();
				String locationCode = (component.get(i).get(j).get("locationCode")).toString();
				String storageCode = (component.get(i).get(j).get("storageCode")).toString();
				int quantity = Integer.valueOf((component.get(i).get(j).get("quantity")).toString());
				int totalQuantity = Integer.valueOf((component.get(i).get(j).get("totalQuantity")).toString());
				
				
				componentDto.setItem_code(itemCode);
				componentDto.setLocation_code(locationCode);
				componentDto.setStorage_code(storageCode);
				componentDto.setQuantity(quantity);
				componentDto.setTotal_quantity(totalQuantity);
				
				componentDto.setProduction_id(productionList.get(i).getProduction_id());
				componentDto.setProduction_code(productionList.get(i).getProduction_code());
				
				componentList.add(componentDto);
			}
			addMapper.addComponent(componentList);
			addMapper.addDetail(detailDto);
		}		
		
		
	}
	
}






