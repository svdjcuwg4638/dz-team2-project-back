package com.dz.factory.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.domain.product.Product;

@Mapper
public interface ProductMapper {

	void insertProduct(Product product);
	
}