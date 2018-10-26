package com.pre.zlm.o2o.service;

import java.util.List;

import com.pre.zlm.o2o.dto.GoodsExecution;
import com.pre.zlm.o2o.dto.ImageHolder;
import com.pre.zlm.o2o.entity.Goods;
import com.pre.zlm.o2o.exception.GoodsOperationException;

public interface GoodsService {
	
	/**
	 * 添加商品
	 */
	GoodsExecution addGoods(Goods goods, ImageHolder thumbnail, List<ImageHolder> goodsImgList) 
			throws GoodsOperationException;
	
	/**
	 * 根据id查询商品
	 */
	Goods getGoodsById(Long goodsId);
	
	/**
	 * 修改商品信息
	 * @param goods 需要修改的商品对象
	 * @param thumbnail	商品的缩略图
	 * @param goodsImgList	商品的详情图片
	 */
	GoodsExecution modifyGoods(Goods goods, ImageHolder thumbnail, List<ImageHolder> goodsImgList)
		throws GoodsOperationException;
}

