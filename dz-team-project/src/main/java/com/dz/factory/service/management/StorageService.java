package com.dz.factory.service.management;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.domain.management.Storage;
import com.dz.factory.mapper.management.StorageMapper;
import com.dz.factory.web.dto.management.LocationDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StorageService {

	private final StorageMapper storageMapper;

	@Transactional
	public void insert(Storage storage) {
		storageMapper.insertStorage(storage);
	}

	@Transactional
	public ArrayList<Storage> getAll() {
		return storageMapper.selectAll();
	}

	@Transactional
	public void addLocation(LocationDto locationDto) {
		storageMapper.insertLocation(locationDto);
	}

	@Transactional
	public ArrayList<LocationDto> getLocationAll() {
		return storageMapper.selectLocationAll();
	}

	@Transactional
	public void editLocation(LocationDto locationDto) {
		storageMapper.updateLocation(locationDto);
	}

	@Transactional
	public void delLocation(List<Integer> ids) {
		for (int id : ids) {
			storageMapper.deleteLocation(id);
		}
	}

	@Transactional
	public void delStorage(List<Integer> ids) {
		for (int id : ids) {
			storageMapper.deleteStorage(id);
		}
	}

}
