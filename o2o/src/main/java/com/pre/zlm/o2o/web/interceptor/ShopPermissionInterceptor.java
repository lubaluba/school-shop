package com.pre.zlm.o2o.web.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pre.zlm.o2o.entity.Shop;

/**
 * 店铺操作权限拦截器,主要检查当前用户是否具有对店铺的操作权限
 */
public class ShopPermissionInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
		@SuppressWarnings("unchecked")
		List<Shop> shopList = (List<Shop>) request.getSession().getAttribute("shopList");
		if (currentShop != null && shopList != null) {
			for (Shop shop : shopList) {
				if (shop.getShopId() == currentShop.getShopId()) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}
