<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>我的生活</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="/favicon.ico">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet"
	href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
<link rel="stylesheet"
	href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
<link rel="stylesheet" href="../resources/css/frontend/index.css">
</head>
<body>
	<div class="page-group">
		<div class="page">
			<header class="bar bar-nav">
				<!-- <a class="button button-link button-nav pull-left" href="/demos/card" data-transition='slide-out'>
                      <span class="icon icon-left"></span>
                      返回
                  </a> -->
				<h1 class="title">校园商铺</h1>
			</header>
			<nav class="bar bar-tab">
				<a class="tab-item active" href="#"> <span
					class="icon icon-home"></span> <span class="tab-label">首页</span>
				</a> <a class="tab-item" href="#" id='me'> <span class="icon icon-me"></span>
					<span class="tab-label">我</span>
				</a>
			</nav>
			<div class="content">
				<!-- 这里是页面内容区 -->
				<div class="swiper-container index-banner" data-space-between='10'>
					<div class="swiper-wrapper">
						<!-- <div class="swiper-slide img-wrap">
                                <img class="banner-img" src="//gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i1/TB1n3rZHFXXXXX9XFXXXXXXXXXX_!!0-item_pic.jpg_320x320q60.jpg" alt="">
                            </div>
                            <div class="swiper-slide img-wrap">
                                <img class="banner-img" src="//gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i4/TB10rkPGVXXXXXGapXXXXXXXXXX_!!0-item_pic.jpg_320x320q60.jpg" alt="">
                            </div>
                            <div class="swiper-slide img-wrap">
                                <img class="banner-img" src="//gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i1/TB1kQI3HpXXXXbSXFXXXXXXXXXX_!!0-item_pic.jpg_320x320q60.jpg" alt="">
                            </div> -->
					</div>
					<div class="swiper-pagination"></div>
				</div>
				<div class='total-shop-button'>
					<a href="allShops" >全部商店</a>
				</div>
				<div class="row">
					<!-- <div class="col-50 shop-classify">
                            <div class='word'>
                                <p class='shop-title'>本期推荐</p>
                                <p class='shop-desc'>近期相关活动、新款上市、旅游资讯</p>
                            </div>
                            <div class='shop-classify-img-warp'>
                                <img class='shop-img' src="static/index/display13.png">
                            </div>
                        </div> -->
				</div>
			</div>
		</div>
		<!--侧边栏  -->
		<div class="panel-overlay"></div>
		<div class="panel panel-right panel-reveal" id="panel-left-demo">
			<div class="content-block">
				<p>
					<a href="/myo2o/frontend/myrecord" class="close-panel">消费记录</a>
				</p>
				<p>
					<a href="/myo2o/frontend/mypoint" class="close-panel">我的积分</a>
				</p>
				<p>
					<a href="/myo2o/frontend/pointrecord" class="close-panel">积分兑换记录</a>
				</p>
				<!-- Click on link with "close-panel" class will close panel -->
			</div>
		</div>
	</div>



	<script type='text/javascript'
		src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
	<script type='text/javascript'
		src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
	<script type='text/javascript'
		src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
	<script type='text/javascript' src='../resources/js/frontend/index.js'
		charset='utf-8'></script>
</body>
</html>
