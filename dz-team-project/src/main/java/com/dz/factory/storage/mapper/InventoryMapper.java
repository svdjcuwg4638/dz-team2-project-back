package com.dz.factory.storage.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dz.factory.common.domain.Inventory;
import com.dz.factory.common.domain.Location;
import com.dz.factory.common.domain.Movement;
import com.dz.factory.common.domain.Storage;
import com.dz.factory.common.domain.TempInventory;
import com.dz.factory.storage.dto.InventoryForm;
import com.dz.factory.storage.dto.MovementDto;
import com.dz.factory.storage.dto.InventoryDto;


@Mapper
public interface InventoryMapper {

	ArrayList<InventoryDto> selectInventoryAll();
	ArrayList<Inventory> selectTempInventoryAll();
	void TempInventoryRegistration(TempInventory inventoryTemp);
	void TempInventoryDestory();

	void InventoryRegistrationUpdate(Inventory inventory);

    List<InventoryDto> searchInventoryByTable(@Param("locationCodes") String locationCodes, @Param("storageCodes") String storageCodes, @Param("categorys") String categorys);
    List<InventoryDto> searchInventoryByForm(InventoryForm searchinventorydata);
    
    String searchMovementStock(String storage_code, String location_code, String item_code); 
    
    void MovementUpdate(@Param("Type") String Type, @Param("storage_code") String storage_code, 
            @Param("location_code") String location_code, @Param("item_code") String item_code, 
            @Param("movement") int movement);
    
    void MovementInsert(Movement movement);
    
    List<MovementDto> searchMovements(@Param("outbound_storage_code") String outboundStorageCode,
            @Param("outbound_location_code") String outboundLocationCode,
            @Param("inbound_storage_code") String inboundStorageCode,
            @Param("inbound_location_code") String inboundLocationCode,
            @Param("item_code") String itemCode,
            @Param("movement_date") String movementDate,
            @Param("emp_id") String empId,
            @Param("startRow") int startRow,
            @Param("pageSize") int pageSize);

int countSearchMovements(@Param("outbound_storage_code") String outboundStorageCode,
      @Param("outbound_location_code") String outboundLocationCode,
      @Param("inbound_storage_code") String inboundStorageCode,
      @Param("inbound_location_code") String inboundLocationCode,
      @Param("item_code") String itemCode,
      @Param("movement_date") String movementDate,
      @Param("emp_id") String empId);
}
