package com.dz.factory.storage.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dz.factory.common.domain.Location;
import com.dz.factory.common.domain.Storage;
import com.dz.factory.storage.dto.InventoryForm;
import com.dz.factory.storage.dto.InventoryDto;


@Mapper
public interface InventoryMapper {

	ArrayList<InventoryDto> selectInventoryAll();
    List<InventoryDto> searchInventoryByTable(@Param("locationCodes") String locationCodes, @Param("storageCodes") String storageCodes, @Param("categorys") String categorys);
    List<InventoryDto> searchInventoryByForm(InventoryForm searchinventorydata);
}
