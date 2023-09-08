package com.dz.factory.management.dto;

import java.util.ArrayList;

import com.dz.factory.common.domain.ProductRelation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRelationDto {

	private int productId;
	private ArrayList<ProductRelation> components;
	
}
