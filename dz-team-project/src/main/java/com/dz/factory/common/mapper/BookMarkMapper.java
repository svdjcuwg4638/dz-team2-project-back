package com.dz.factory.common.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.BookMark;

@Mapper
public interface BookMarkMapper {

	ArrayList<BookMark> getBookMark();

	int insertBookMark(BookMark dto);


	int deleteBookMark(BookMark dto);

}
