package com.tedu.service;

import java.util.List;

import com.tedu.pojo.Item;

public interface ItemService {
	List<Item> getItems(String orderId);
	
	void decreaseNumbers(List<Item> list);
}
