package com.dz.factory.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.management.domain.Storage;
import com.dz.factory.management.dto.LocationDto;
import com.dz.factory.management.mapper.StorageMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StorageService {

	private final StorageMapper storageMapper;

	@Transactional
	public void insert(Storage storage) {
		storageMapper.insertStorage(storage);
	}

	public ArrayList<Storage> getAll() {
		return storageMapper.selectAll();
	}

	@Transactional
	public void addLocation(LocationDto locationDto) {
		storageMapper.insertLocation(locationDto);
	}

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
