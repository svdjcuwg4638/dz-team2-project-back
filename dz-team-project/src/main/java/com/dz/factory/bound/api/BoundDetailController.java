package com.dz.factory.bound.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.bound.dto.BoundDetailDto;
import com.dz.factory.bound.service.BoundDetailService;
import com.dz.factory.common.domain.CMRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoundDetailController {

	private final BoundDetailService boundDetailService;
	
	@PostMapping("/inbound/detailAdd")
	public ResponseEntity<?> insertInboundDetail(@RequestBody BoundDetailDto boundDetailDto){
		System.out.println(boundDetailDto);
		boundDetailService.insertInboundDetail(boundDetailDto);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",boundDetailDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/inbound/detailall")
	public ResponseEntity<?> selectInboundDetailAll(){
		List<BoundDetailDto> inboundDetailList = boundDetailService.selectInboundDetailAll();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",inboundDetailList),HttpStatus.CREATED);
	}
	
	@PostMapping("/inbound/updateOngoing")
	public ResponseEntity<?> updateByDetailId(@RequestBody List<BoundDetailDto> boundDetailDtos){
		System.out.println("지금시간"+boundDetailDtos);
	    for (BoundDetailDto boundDetailDto : boundDetailDtos) {
	        boundDetailService.updateByDetailId(boundDetailDto);
	    }
	    return new ResponseEntity<>(new CMRespDto<>(1,"성공", boundDetailDtos), HttpStatus.CREATED);
	}

}
