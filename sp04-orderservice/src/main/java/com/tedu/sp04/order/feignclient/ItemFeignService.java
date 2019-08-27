package com.tedu.sp04.order.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.tedu.pojo.Item;
import com.tedu.pojo.User;
import com.tedu.sp04.order.feignclient.ItemFeignServiceFB;
import com.tedu.web.util.JsonResult;

@FeignClient(name="item-service",fallback=ItemFeignServiceFB.class)
public interface ItemFeignService {
	@GetMapping("/{OrderId}")
	JsonResult<List<Item>>getItems(@PathVariable String orderId);
	
	@GetMapping("/desreaseNumber")
	JsonResult descreaseNumber(@RequestBody List<Item>items);
;
}
