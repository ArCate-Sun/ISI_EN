# 前台

1. /list/categories
	
	DESCRIPTION: 获取板块信息
	
	METHOD: GET
	
	PARAM: NONE
	
	RESPONSE: 
	
		{
			"categories": [
				{
					"title":	[str],
					"url":	  [str]
				}, ...
			]
		}
		
	RESP_DEMO:
	
		{
			"categories": [
				{
					"title": "Home",
					"url": "./index.html"
				}, {
					"title": "Introduction",
					"url": "./list.html?id=1"
				}, {
					"title": "Education",
					"url": "./list.html?id=2"
				}, {
					"title": "News",
					"url": "./list.html?id=3",
				}, {
					"title": "Notification",
					"url": "./list.html?id=4"
				}
			]
		}

2. /list/categories
	
	DESCRIPTION: 获取子版块信息
	
	METHOD: GET
	
	PARAM:
	
		id	  [int]	   // 父板块或子版块的id
	
	RESPONSE: 
	
		{
			"id":				[int]		// 当前所属父板块的id
			"title":			[str]		// 当前所属父板块的名称
			"children": [
				{
					"id":		[int]		// 子板块的id
					"title":	[str]		// 子版块的名称
				}, ...
			]
		}
		
	RESP_DEMO:
	
		{
			"id": 1,
			"title": "Introduction",
			"children": [
				{
					"id": 10,
					"title": "College of Electronic Information and Optical Engineering"
				}, {
					"id": 11,
					"title": "College of Electronic Information and Optical 2"
				}, {
					"id": 13,
					"title": "College of Electronic Information and Optical 13"
				}
			]
		}
		
3. /list/categories
	
	DESCRIPTION: 获取子版块信息
	
	METHOD: GET
	
	PARAM:
	
		news_id	  [int]	   // 新闻的id
	
	RESPONSE: 
	
		{
			"id":				[int]		// 所属父板块的id
			"title":			[str]		// 所属父板块的名称
			"children": [
				{
					"id":		[int]		// 子板块的id
					"title":	[str]		// 子版块的名称
					"from_here":	[bool]  // 当前新闻是否被包含于这个子版块中. 若值为false, 则该属性可省略.
				}, ...
			]
		}
		
	RESP_DEMO:
	
		{
			"id": 1,
			"title": "Introduction",
			"children": [
				{
					"id": 10,
					"title": "College of Electronic Information and Optical Engineering",
					"from_here": true
				}, {
					"id": 11,
					"title": "College of Electronic Information and Optical 2"
				}, {
					"id": 13,
					"title": "College of Electronic Information and Optical 13"
				}
			]
		}
		
4. /list/news

	DESCRIPTION: 获取新闻列表
	
	METHOD: GET
	
	PARAM:
	
		category_id	  [int]	   // 父板块或子版块的id
	
	RESPONSE: 
	
		{
			"news": [
				{
					"id":			[int]		// 新闻id,
					"title":        [str]		// 新闻标题,
					"time":			[int]		// 新闻最后修改的时间戳
				}, ...
			]
		}
		
	RESP_DEMO:
	
		{
			"news": [
				{
					"id": 101,
					"title": "Department of Electrical Science and Engineering",
					"time": 1569411840964
				},
				{
					"id": 102,
					"title": "Teaching Center for Experimental Electronic Information",
					"time": 1569411840964
				},
			]
		}

5. /get/news

	DESCRIPTION: 获取新闻
	
	METHOD: GET
	
	PARAM:
	
		id	  [int]	   // 新闻 id
	
	RESPONSE: 
	
		{
			"id":			[int]		// 新闻id
			"category_id":	[int]		// 所属板块id
			"title":		[str]		// 新闻标题
			"time":			[int]		// 新闻最后更改时间戳
			"content":		[str]		// 新闻文本
		}
		
	RESP_DEMO:
	
		{
			"id": 101,
			"category_id": 12,
			"title": "Department of Electrical Science and Engineering",
			"time": 1569411840964,
			"content": "ABCDEFG..."
		}

