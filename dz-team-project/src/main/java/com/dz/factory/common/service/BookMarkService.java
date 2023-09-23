package com.dz.factory.common.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.dz.factory.common.domain.BookMark;
import com.dz.factory.common.mapper.BookMarkMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookMarkService {

	private final BookMarkMapper bookMarkMapper;

	public ArrayList<BookMark> getAllBookMark() {
		return bookMarkMapper.getBookMark();
	}

	public int bookMarkAdd(BookMark dto) {
		int result = 0;
		ArrayList<BookMark> list = bookMarkMapper.getBookMark();
		boolean flag = false;
		for(BookMark fdto : list) {
			if(fdto.getPageUrl().equals(dto.getPageUrl())) {
				flag = true;
			}
		}
		if(flag) {
			result = bookMarkMapper.deleteBookMark(dto);
		}else {
			result = bookMarkMapper.insertBookMark(dto);
		}
		
		return result;
		
	}
	
}
