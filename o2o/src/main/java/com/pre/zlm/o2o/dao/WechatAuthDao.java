package com.pre.zlm.o2o.dao;

import com.pre.zlm.o2o.entity.WechatAuth;

public interface WechatAuthDao {
	/**
	 * 	通过openId查询对应平台的微信账号
	 */
	WechatAuth getWechatAuthById(String openId);
	
	/**
	 * 	添加对应本平台的微信账号
	 */
	int insertWechatAuth(WechatAuth wechatAuth);
	
}
