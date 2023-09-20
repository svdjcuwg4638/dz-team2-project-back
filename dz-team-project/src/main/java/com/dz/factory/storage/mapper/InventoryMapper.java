package com.dz.factory.storage.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dz.factory.common.domain.Inventory;
import com.dz.factory.common.domain.Location;
import com.dz.factory.common.domain.Storage;
import com.dz.factory.storage.dto.InventoryForm;
import com.dz.factory.storage.dto.InventoryDto;


@Mapper
public interface InventoryMapper {

	ArrayList<InventoryDto> selectInventoryAll();
	ArrayList<Inventory> selectTempInventoryAll();
	void TempInventoryRegistration(Inventory inventoryTemp);
	void TempInventoryDestory();
    List<InventoryDto> searchInventoryByTable(@Param("locationCodes") String locationCodes, @Param("storageCodes") String storageCodes, @Param("categorys") String categorys);
    List<InventoryDto> searchInventoryByForm(InventoryForm searchinventorydata);
}
