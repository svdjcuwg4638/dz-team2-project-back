package com.dz.factory.storage.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dz.factory.common.domain.Location;
import com.dz.factory.common.domain.Storage;
import com.dz.factory.storage.dto.Inventory;

@Mapper
public interface InventoryMapper {

	ArrayList<Inventory> selectInventoryAll();
	List<Inventory> searchInventoryByStorage(@Param("storageCodes") String storageCodes);
    List<Inventory> searchInventoryByLocation(@Param("locationCodes") String locationCodes, @Param("storageCodes") String storageCodes);
    List<Inventory> searchInventoryByCategory(@Param("locationCodes") String locationCodes, @Param("storageCodes") String storageCodes, @Param("categorys") String categorys);

	    //	ArrayList<Inventory> selectSearchInventorybyStorage(Storage storage);
}
