package com.dz.factory.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.common.domain.Location;
import com.dz.factory.common.domain.Storage;
import com.dz.factory.management.mapper.StorageMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StorageService {

	private final StorageMapper storageMapper;

	@Transactional
	public int insert(Storage storage) {
		Storage sameOne = storageMapper.storageSameOne(storage.getStorage_code());
		if(sameOne != null) {
			if(sameOne.getIsDelete() == 1) {
				storageMapper.updateStorage(storage);
				return 1;
			}else {
				return 0;
			}
		}else {
			storageMapper.insertStorage(storage);
			Location zeroLocation = new Location();
			zeroLocation.setCompany_id(storage.getCompany_id());
			zeroLocation.setStorage_code(storage.getStorage_code());
			zeroLocation.setLocation_code("0");
			zeroLocation.setLocation_name("미지정");
			storageMapper.insertLocation(zeroLocation);
			return 1;
		}
	}

	public ArrayList<Storage> getAll() {
		return storageMapper.selectAll();
	}

	@Transactional
	public int addLocation(Location locationDto) {
		Location sameOne = storageMapper.locationSameOne(locationDto);
		if(sameOne != null) {
			if(sameOne.getIsDelete() == 1) {
				storageMapper.updateLocation(locationDto);
				return 1;
			}else {
				return 0;
			}
		}else {
			storageMapper.insertLocation(locationDto);
			return 1;
		}
	}

	public ArrayList<Location> getLocationAll() {
		return storageMapper.selectLocationAll();
	}

	@Transactional
	public void editLocation(Location locationDto) {
		storageMapper.updateLocation(locationDto);
	}

	@Transactional
	public void delLocation(ArrayList<Location> dtos) {
		for (Location dto : dtos) {
			storageMapper.locationIsDeleteTrue(dto);
		}
	}

	@Transactional
	public void delStorage(List<String> codes) {
		for (String code : codes) {
			storageMapper.storageIsDeleteTrue(code);
		}
	}

}
