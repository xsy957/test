package com.tedu.sp04.order.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tedu.pojo.User;
import com.tedu.sp04.order.feignclient.UserFeignServiceFB;
import com.tedu.web.util.JsonResult;

@FeignClient(name="user-service",fallback=UserFeignServiceFB.class)
public interface UserFeignService {
	@GetMapping("/{userId}")
	JsonResult<User>getUser(@PathVariable Integer userId);
	
	
	@GetMapping("/{userId}/score")
	JsonResult addScore(@PathVariable Integer userId,@PathVariable Integer score);

}
