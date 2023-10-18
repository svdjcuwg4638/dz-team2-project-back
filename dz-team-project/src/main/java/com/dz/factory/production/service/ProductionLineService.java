package com.dz.factory.production.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.ProductionLine;
import com.dz.factory.production.dto.ComponentDto;
import com.dz.factory.production.dto.ProductionDetailDto;
import com.dz.factory.production.dto.ProductionDto;
import com.dz.factory.production.dto.ProductionLineDto;
import com.dz.factory.production.mapper.ProductionLineMapper;
import com.dz.factory.production.mapper.ProductionListMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductionLineService {
	private final ProductionLineMapper lineMapper;

	public ArrayList<ProductionLineDto> getAllLine() {
		return lineMapper.getAllLine();

	}

	public String addLine(ArrayList<HashMap<String, ?>> addData) {
		String errorMsg="";
//		ArrayList<ProductionLine> addList = new ArrayList<ProductionLine>();

		for (int i = 0; i < addData.size(); i++) {
			ProductionLine lineDto = new ProductionLine();
			lineDto.setLine_code(addData.get(i).get("lineCode").toString());
			lineDto.setLine_name(addData.get(i).get("line").toString());
			lineDto.setCompany_id(Integer.parseInt(addData.get(i).get("companyId").toString()));
			if (addData.get(i).get("empId") != null) {
			    lineDto.setEmp_id(Integer.parseInt(addData.get(i).get("empId").toString()));
			}

			if (addData.get(i).get("empCode") != null) {
			    lineDto.setEmp_id(Integer.parseInt(addData.get(i).get("empCode").toString()));
			}

			if (addData.get(i).get("uses") != null) {
			    lineDto.setUses(addData.get(i).get("uses").toString());
			}

			if (addData.get(i).get("place") != null) {
			    lineDto.setPlace(addData.get(i).get("place").toString());
			}

			if (addData.get(i).get("description") != null) {
			    lineDto.setDescription(addData.get(i).get("description").toString());
			}
			
			try {
				lineMapper.addLine(lineDto);
			} catch (Exception e) {
				e.printStackTrace();
				errorMsg=addData.get(i).get("lineCode").toString();
			}
		}
		return errorMsg;
	}

//	==============생산라인 수정==============
	public void editLine(ArrayList<HashMap<String, ?>> editData) {
		
		//ArrayList<ProductionLine> editList = new ArrayList<ProductionLine>();

		for (int i = 0; i < editData.size(); i++) {
			ProductionLine lineDto = new ProductionLine();
			lineDto.setLine_code(editData.get(i).get("lineCode").toString());
			lineDto.setLine_name(editData.get(i).get("line").toString());
			lineDto.setCompany_id(Integer.parseInt(editData.get(i).get("companyId").toString()));
			if (editData.get(i).get("empId") != null) {
			    lineDto.setEmp_id(Integer.parseInt(editData.get(i).get("empId").toString()));
			}

			if (editData.get(i).get("empCode") != null) {
			    lineDto.setEmp_id(Integer.parseInt(editData.get(i).get("empCode").toString()));
			}

			if (editData.get(i).get("uses") != null) {
			    lineDto.setUses(editData.get(i).get("uses").toString());
			}

			if (editData.get(i).get("place") != null) {
			    lineDto.setPlace(editData.get(i).get("place").toString());
			}

			if (editData.get(i).get("description") != null) {
			    lineDto.setDescription(editData.get(i).get("description").toString());
			}
			
			try {
				lineMapper.updateLine(lineDto);
			} catch (Exception e) {
				e.printStackTrace();
//				errorMsg=addData.get(i).get("lineCode").toString();
			}
		}
//		return errorMsg;
	}
	//==========생산라인 삭제===============
	public void deleteLine(ArrayList<String> keyList) {
		for(String key : keyList) {			
			lineMapper.deleteLine(key);
		}
	}
}
