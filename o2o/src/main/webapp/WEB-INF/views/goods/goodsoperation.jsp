<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>SUI Mobile Demo</title>
<meta name="description" content="MSUI: Build mobile apps with simple HTML, CSS, and JS components.">
<meta name="author" content="阿里巴巴国际UED前端">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="/favicon.ico">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<!-- Google Web Fonts -->
<link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
<link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
<link rel="stylesheet" href="../resources/css/goods/goodsoperation.css">
<link rel="apple-touch-icon-precomposed" href="/assets/img/apple-touch-icon-114x114.png">
<script>
	var _hmt = _hmt || [];
	(function() {
	    var hm = document.createElement("script");
	    hm.src = "//hm.baidu.com/hm.js?ba76f8230db5f616edc89ce066670710";
	    var s = document.getElementsByTagName("script")[0];
	    s.parentNode.insertBefore(hm, s);
	})();
</script>
</head>
<body>
  	<header class="bar bar-nav">
   		 	<h1 class="title">添加商品</h1>
  	</header>
  	<div class="content">
    <div class="list-block">
      <ul>
       <!-- 商品名称 -->
        <li>
          <div class="item-content">
          	<div class="item-media">
          		<i class="icon icon-form-name"></i>
          	</div>
            <div class="item-inner">
              <div class="item-title label">商品名称</div>
              <div class="item-input">
                <input type="text" placeholder="商品名称" id="goods-name" >
              </div>
            </div>
          </div>
        </li>
        <!-- 目录 -->
         <li>
          <div class="item-content">
          	<div class="item-media">
          		<i class="icon icon-form-email"></i>
          	</div>
            <div class="item-inner">
              <div class="item-title label">商品类别</div>
              <div class="item-input">
                <select id = "category"></select>
              </div>
            </div>
          </div>
        </li>
       <!-- 优先级 -->
        <li>
          <div class="item-content">
          	<div class="item-media">
          		<i class="icon icon-form-email"></i>
          	</div>
            <div class="item-inner">
              <div class="item-title label">优先级</div>
              <div class="item-input">
                <input type="number" placeholder="优先级(1~5)" id="priority" min ="1" max="5" >
              </div>
            </div>
          </div>
        </li>
       <!-- 原价 -->
       <li>
          <div class="item-content">
          	<div class="item-media">
          		<i class="icon icon-form-email"></i>
          	</div>
            <div class="item-inner">
              <div class="item-title label">原价</div>
              <div class="item-input">
                <input type="number" placeholder="原价" id="normal-price" >
              </div>
            </div>
          </div>
        </li>
        <!-- 现价 -->
        <li>
          <div class="item-content">
          	<div class="item-media">
          		<i class="icon icon-form-email"></i>
          	</div>
            <div class="item-inner">
              <div class="item-title label">现价</div>
              <div class="item-input">
                <input type="number" placeholder="现价" id="promotion-price" >
              </div>
            </div>
          </div>
        </li>
       <!-- 缩略图 -->
         <li>
          <div class="item-content">
          	<div class="item-media">
          		<i class="icon icon-form-email"></i>
          	</div>
            <div class="item-inner">
              <div class="item-title label">缩略图</div>
              <div class="item-input">
                <input type="file" id = "small-img">
              </div>
            </div>
          </div>
        </li>
        <!-- 批量详情图片 -->
       <li>
          <div class="item-content">
          	<div class="item-media">
          		<i class="icon icon-form-email"></i>
          	</div>
            <div class="item-inner detail-img-div">
              <div class="item-title label">详情图</div>
          	  <div class="item-input" id = "detail-img">
          	  	<input type="file" class="detail-img">
          	  </div>
            </div>
          </div>
        </li>
       <!-- 商品详情-->
       <li>
          <div class="item-content">
          	<div class="item-media">
          		<i class="icon icon-form-email"></i>
          	</div>
            <div class="item-inner">
              <div class="item-title label">商品描述</div>
          	  <div class="item-input">
          	  	<textarea id="goods-desc" placeholder="商品描述"></textarea>
          	  </div>
            </div>
          </div>
        </li>
        <!-- 验证码 -->
        <li>
          <div class="item-content">
          <div class="item-media">
          		<i class="icon icon-form-email"></i>
          	</div>
            <div class="item-inner">
              <div class="item-title label">验证码</div>
              <input type="text" id = "j_captcha" placeholder="验证码">
              <div class="item-input">
                <img id = "captcha_img" alt="点击更换" title="点击更换" onclick="changeVerifyCode(this)"  src = "../kaptcha"> 
              </div>
            </div>
          </div>
        </li> 
      </ul>
    </div>
    <div class="content-block">
      <div class="row">
        <div class="col-50"><a href="/o2o/shopAdmin/togoodsmanagment" class="button button-big button-fill button-danger">返回商品管理</a></div>
        <div class="col-50">
        	<a href="javascript:void(0)" class="button button-big button-fill button-success" id="submit">提交</a>
        </div>
      </div>
    </div>
  </div>
    <script type='text/javascript' src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
    <script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
    <script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
    <script type="text/javascript" src="../resources/js/goods/goodsoperation.js"></script>
    <script type="text/javascript" src="../resources/js/commom/commom.js"></script>
  </body>
</html>
