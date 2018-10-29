 package com.pre.zlm.o2o.web.shopController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pre.zlm.o2o.dto.ImageHolder;
import com.pre.zlm.o2o.dto.ShopExecution;
import com.pre.zlm.o2o.entity.Area;
import com.pre.zlm.o2o.entity.Shop;
import com.pre.zlm.o2o.entity.ShopCategory;
import com.pre.zlm.o2o.entity.UserInfo;
import com.pre.zlm.o2o.enums.ShopStateEnum;
import com.pre.zlm.o2o.exception.ShopOperationException;
import com.pre.zlm.o2o.service.AreaService;
import com.pre.zlm.o2o.service.ShopCategoryService;
import com.pre.zlm.o2o.service.ShopService;
import com.pre.zlm.o2o.utils.HttpServletRequestUtils;
import com.pre.zlm.o2o.web.BaseController;
@Controller
@RequestMapping("/shopAdmin")
public class ShopController extends BaseController {
	
	@Autowired
	private ShopService service;
	
	@Autowired
	private ShopCategoryService shopCategoryService;
	
	@Autowired
	private AreaService areaService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/listshops", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listShop(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		int pageSize = HttpServletRequestUtils.getInt(request, "pageSize");
		int pageIndex = HttpServletRequestUtils.getInt(request, "pageIndex");
		if (pageSize > -1 && pageIndex > -1) {
			long parentId = HttpServletRequestUtils.getLong(request, "parentId");
			long shopCategoryId = HttpServletRequestUtils.getLong(request, "shopCategoryId");
			int areaId = HttpServletRequestUtils.getInt(request, "areaId");
			String shopName = HttpServletRequestUtils.getString(request, "shopName");
			Shop shopCondition = compactShopCondition(parentId, shopCategoryId, areaId, shopName);
			ShopExecution se = service.listShopByCondition(shopCondition, pageIndex, pageSize);
			result.put("shopList", se.getShopList());
			result.put("count", se.getCount());
			result.put("success", true);
		} else {
			exceptionResult(result, "查询失败");
		}
		return result;
	}
	
	/**
	 * 封装条件查询店铺的条件
	 */
	private Shop compactShopCondition(long parentId, long shopCategoryId, int areaId, String shopName) {
		Shop shopCondition = new Shop();
		if (parentId > 0L) {
			ShopCategory sc = new ShopCategory();
			sc.setParent(new ShopCategory(parentId));
			shopCondition.setShopCategory(sc);
		}
		if (shopCategoryId > 0L) {
			ShopCategory sc = new ShopCategory();
			sc.setShopCategoryId(shopCategoryId);
			shopCondition.setShopCategory(sc);
		}
		if (areaId > 0) {
			Area area = new Area();
			area.setAreaId(areaId);
			shopCondition.setArea(area);
		}
		if (shopName != null) {
			shopCondition.setShopName(shopName);
		}
		return shopCondition;
	}

	
	/**
	 *	获得店铺列表
	 */
	@RequestMapping(value = "/getshoplist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getShopList(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//TODO 这里从session中获取user
		UserInfo user = new UserInfo();
		user.setUserId(1L);
		user.setName("王小二");
		request.getSession().setAttribute("user", user);
		user = (UserInfo)request.getSession().getAttribute("user");
		
		try {
			Shop shopCondition = new Shop();
			shopCondition.setOwner(user);
			ShopExecution se = service.listShopByCondition(shopCondition, 0, 10);
			result.put("success", true);
			result.put("shoplist", se.getShopList());
			result.put("user", user);
			return result;
		} catch (Exception e) {
			return exceptionResult(result, e.getMessage());
		}
	}
	
	/**
	 * 获取某一一级类别下的全部店铺
	 */
	@RequestMapping(value = "/listshopspageinfo", method = RequestMethod.GET)
	private Map<String, Object> listShopsPageInfo(HttpServletRequest request){
		Map<String, Object> result = new HashMap<>();
		Long parentId = HttpServletRequestUtils.getLong(request, "parent");
		//如果parentId存在,就取出该以及类别下的全部二级类别,如果不存在就取出全部的一级类别
		List<ShopCategory> shopCategoryList = null;
		try {
			if (parentId > 0) {
				ShopCategory shopCategoryCondition = new ShopCategory();
				shopCategoryCondition.setParent(new ShopCategory(parentId));
				shopCategoryList = shopCategoryService.listShopCategory(shopCategoryCondition);	
			} else {
				shopCategoryList = shopCategoryService.listShopCategory(null);
			}
		} catch (Exception e) {
			exceptionResult(result, e.getMessage());
		}
		result.put("success", true);
		result.put("shopCategoryList", shopCategoryList);
		try {
			List<Area> areaList = areaService.getAreaList();
			result.put("areaList", areaList);
		} catch (Exception e) {
			exceptionResult(result, e.getMessage());
		}
		return result;
	}
	
	/**
	 * 点击进入店铺展示详情页面
	 */
	@RequestMapping(value = "/getshopmanagementinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getShopManagementInfo(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		long shopId = HttpServletRequestUtils.getLong(request, "shopId");
		if (shopId <= 0) {
			Object currentShopObj = request.getSession().getAttribute("currentShop");
			if (currentShopObj == null) {
				result.put("redirect", true);
				result.put("url", "/o2o/shopAdmin/toShopList");
			} else {
				Shop currentShop = (Shop)currentShopObj;
				result.put("redirect", false);
				result.put("shopId", currentShop.getShopId());
			}
		} else {
			Shop currentShop = new Shop();
			currentShop.setShopId(shopId);
			request.getSession().setAttribute("currentShop", currentShop);
			result.put("redirect", false);
			result.put("shopId", currentShop.getShopId());
		}
		return result;
	}
		
	/**
	 *	获取店铺类别列表
	 */
	@RequestMapping(value = "/getshopCategorylist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getShopCategoryList(HttpServletRequest request) {
		Map<String, Object> result =new HashMap<>();
		List<ShopCategory> shopCategoryList;
		try {
			long id = HttpServletRequestUtils.getLong(request, "parentId");
			if(id < 0) {
				shopCategoryList = shopCategoryService.listShopCategory(new ShopCategory());
			}else {
				ShopCategory shopCategoryCondition = new ShopCategory();
				ShopCategory parent = new ShopCategory();
				parent.setShopCategoryId(id);
				shopCategoryCondition.setParent(parent);
				shopCategoryList = shopCategoryService.listShopCategory(shopCategoryCondition);
			}
			result.put("success", true);
			result.put("rows", shopCategoryList);
			result.put("total", shopCategoryList.size());
			return result;
		} catch(Exception e) {
			return exceptionResult(result, e.toString());
		}
	}
	
	/**
	 * 注册店铺
	 */
	@RequestMapping(value = "/registershop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> registerShop(HttpServletRequest request) {
		Map<String,Object> result = new HashMap<>();
		if (! checkCode()) {
			return exceptionResult(result, "验证码错误");
		}
		Shop shop = null;
		try {
			shop = (Shop)getObject("shopstr", Shop.class);
		} catch (Exception e) {
			return exceptionResult(result, "参数转换异常");
		}
		
		//图片上传读取转换
		ImageHolder shopImg = null;
		try {
			shopImg = ResolverImg("shopImg");
		} catch (Exception e) {
			return exceptionResult(result, "上传图片不可为空");
		}
		
		if(shop == null || shopImg == null) {
			return exceptionResult(result, "请输入店铺信息");
		}
		//注册店铺
		//TODO 注册店铺时需要店主的信息,此时可以通过session获取。
		//UserInfo owner = (UserInfo)request.getSession().getAttribute("user");
		UserInfo owner = new UserInfo();
		owner.setUserId(1L);
		shop.setOwner(owner);
		try {
			ShopExecution se = service.addShop(shop, shopImg);
			if (se.getState() == ShopStateEnum.CHECK.getState()) {
				result.put("success", true);
				@SuppressWarnings("unchecked")
				List<Shop> shopList = (List<Shop>) request.getSession().getAttribute("shopList");
				if (shopList == null) {
					shopList = new ArrayList<>();
				}
				shopList.add(se.getShop());
				request.getSession().setAttribute("shopList", shopList);
				return result;
			} else {
				return exceptionResult(result, se.getStateInfo());
			}
		} catch (ShopOperationException e ) {
			logger.error("店铺插入失败");
			return exceptionResult(result,e.toString());
		}	
	}
	
	/**
	 *	根据id获取店铺详情
	 */
	@RequestMapping(value = "/getshopbyid", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getShopById(HttpServletRequest request){
		Map<String, Object> result = new HashMap<>();
		Long shopId = HttpServletRequestUtils.getLong(request, "shopId");
		if (shopId > -1) {
			try {
				Shop shop = service.getShopById(shopId);
				result.put("shop", shop);
				result.put("success", true);
			} catch (Exception e) {
				result.put("success", false);
				result.put("errMsg", e.toString());
			}
		} else {
			result.put("success", false);
			result.put("errMsg", "empty shopId");
		}
		return result;
	}
	
	/**
	 *	更新店铺
	 */
	@RequestMapping(value = "/updateshop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> updateShop(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//检验验证码
		if (! checkCode()) {
			return exceptionResult(result, "验证码错误");
		}
		
		//参数转换为实体
		Shop shop = null;
		try {
			shop = (Shop)getObject("shopstr", Shop.class);
		} catch (Exception e) {
			return exceptionResult(result, "参数转换异常");
		}
		
		//图片上传读取转换
		ImageHolder shopImg = null;
		try {
			shopImg = ResolverImgForUpdate("shopImg");
		} catch (Exception e) {
			return exceptionResult(result, "图片处理失败");
		}
		
		if(shop == null || shop.getShopId() == null) {
			return exceptionResult(result, "请输入店铺id");
		}
		
		//更新店铺
		UserInfo owner = (UserInfo)request.getSession().getAttribute("user");
		shop.setOwner(owner);
		try {
			ShopExecution se = service.updateShop(shop, shopImg);
			if (se.getState() == ShopStateEnum.SUCCESS.getState()) {
				result.put("success", true);
				return result;
			} else {
				return exceptionResult(result, se.getStateInfo());
			}
		} catch (ShopOperationException e ) {
			return exceptionResult(result, e.toString());
		}	
	}
	
}