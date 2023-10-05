package com.dz.factory.bound.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.bound.dto.OutBoundDetailDto;
import com.dz.factory.bound.service.OutBoundDetailService;
import com.dz.factory.common.domain.CMRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OutBoundDetailController {

private final OutBoundDetailService outboundDetailService;
	
	@PostMapping("/outbound/detailAdd")
	public ResponseEntity<?> insertOutboundDetail(@RequestBody OutBoundDetailDto outboundDetailDto){
		System.out.println(outboundDetailDto);
		outboundDetailService.insertOutboundDetail(outboundDetailDto);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",outboundDetailDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/outbound/detailall")
	public ResponseEntity<?> selectOutboundDetailAll(){
		List<OutBoundDetailDto> outboundDetailList = outboundDetailService.selectOutboundDetailAll();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",outboundDetailList),HttpStatus.CREATED);
	}
	
	@GetMapping("/outbound/getstock")
	public ResponseEntity<?> getStock(@RequestParam String item_code, @RequestParam String storage_code, @RequestParam String location_code) {
        try {
            Integer stock = outboundDetailService.getStock(item_code, storage_code, location_code);
            if (stock != null) {
                return new ResponseEntity<>(stock, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
