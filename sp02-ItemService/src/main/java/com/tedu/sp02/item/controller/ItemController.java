package com.tedu.sp02.item.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.pojo.Item;
import com.tedu.service.ItemService;
import com.tedu.web.util.JsonResult;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@Value("${server.port}")//动态获取服务器 的端口号
	private int port;
	
	@GetMapping("/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable String orderId) throws InterruptedException {
		log.info("server.port="+port+", orderId="+orderId);
		
		long t = new Random().nextInt(5000);
		if(Math.random()<0.6) { 
			log.info("item-service-"+port+" - 暂停 "+t);
			Thread.sleep(t);
		}
		
		List<Item> items = itemService.getItems(orderId);
		return JsonResult.ok(items).msg("port="+port);
	}
	
	@PostMapping("/decreaseNumber")
	public JsonResult decreaseNumber(@RequestBody List<Item> items) {
		itemService.decreaseNumbers(items);
		return JsonResult.ok();
	}
}
