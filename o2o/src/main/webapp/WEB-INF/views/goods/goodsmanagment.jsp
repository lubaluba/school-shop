<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>商品管理</title>
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <link rel="shortcut icon" href="/favicon.ico">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
        <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
        <link rel="stylesheet" href="../resources/css/goods/goodsmanagment.css">
    </head>
<body>
    <header class="bar bar-nav">
        <h1 class="title">商品管理</h1>
    </header>
    <div class="content">
        <div class="content-block">
            <div class="row row-goods">
                <div class="col-40" >商品名称</div>
                <div class="col-20" >优先级</div>
                <div class="col-40" >操作</div>
            </div>
            <div class="goods-wrap">
                <!-- <div class="row row-goods">
                    <div class="col-40">商品名称</div>
                    <div class="col-60">
                        <a href="#">编辑</a>
                        <a href="#">删除</a>
                        <a href="#">预览</a>
                    </div>
                </div> -->
            </div>
        </div>
        <div class="content-block">
			<div class="row">
				<div class="col-50">
					<a href="/o2o/shopAdmin/toShopManagement"
						class="button button-big button-fill button-danger">返回</a>
				</div>
                <div class="col-50">
                    <a href="#" class="button button-big button-fill button-success" id="new">新增</a>
                </div>
			</div>
		</div>
    </div>
    


    <script type='text/javascript' src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
    <script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
    <script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
    <script type='text/javascript' src='../resources/js/goods/goodsmanagment.js' charset='utf-8'></script>
</body>
</html>
