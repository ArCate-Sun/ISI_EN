
原网站: http://39.105.31.182:8007/english/
后台: http://39.105.31.182:8007/english/siteserver/login.aspx
admin nk_123456

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

2. /categories/list/[category_id]
	
	DESCRIPTION: 获取子版块信息
	
	METHOD: GET
	
	PARAM:
	
		category_id	  [int]	   // 父板块或子版块的id
	
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
		
3. /categories/list/by_news/[news_id]
	
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
		
4. /news/list/[category_id]

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
					"highlight":	[bool]		// 是否高亮显示
				}, ...
			]
		}
		
	RESP_DEMO:
	
		{
			"news": [
				{
					"id": 101,
					"title": "Department of Electrical Science and Engineering",
					"time": 1569411840964,
					"highlight": true
				},
				{
					"id": 102,
					"title": "Teaching Center for Experimental Electronic Information",
					"time": 1569411840964,
					"highlight": false
				},
			]
		}

5. /news/[news_id]

	DESCRIPTION: 获取新闻
	
	METHOD: GET
	
	PARAM:
	
		news_id	  [int]	   // 新闻 id
	
	RESPONSE: 
	
		{
			"id":			[int]		// 新闻id
			"category_id":	[int]		// 所属板块id
			"title":		[str]		// 新闻标题
			"author":		[str]		// 作者名称
			"time":			[int]		// 新闻最后更改时间戳
			"content":		[str]		// 新闻文本
		}
		
	RESP_DEMO:
	
		{
			"id": 101,
			"category_id": 12,
			"title": "Department of Electrical Science and Engineering",
			"author": "ACat",
			"time": 1569411840964,
			"content": "ABCDEFG..."
		}

6. /admin/news/[news_id]/top

	DESCRIPTION: 置顶新闻
	
	METHOD: GET
	
	PARAM:
	
		news_id	  [int]	   // 新闻 id
	
	RESPONSE: 
	
		{
			"result": 		[bool]		// 操作结果
			"error_code":	[int]		// 错误码
			"message":		[str]		// 错误信息
		}

7. /admin/news/[news_id]/save

	DESCRIPTION: 新建或保存新闻
	
	METHOD: POST
	
	PARAM:
		
		news_id		[int]	// 新闻 id
		
		body: {
			"title":		[str]		// 新闻标题
			"category_id":	[int]		// 新闻所述子版块id
			"author":		[str]		// 作者名称
			"hightlight_time":	[int]	// 高亮时间 (单位: 时)
			"content":		[str]		// 新闻内容
		}
		
	RESPONSE: 
	
		{
			"result": 		[bool]		// 操作结果
			"error_code":	[int]		// 错误码
			"message":		[str]		// 错误信息
		}

8. /admin/news/[news_id]/publish

	DESCRIPTION: 发布新闻
	
	METHOD: GET
	
	PARAM:
	
		news_id	  [int]	   // 新闻 id
	
	RESPONSE: 
	
		{
			"result": 		[bool]		// 操作结果
			"error_code":	[int]		// 错误码
			"message":		[str]		// 错误信息
		}
	
9. /admin/news/[news_id]/delete

	DESCRIPTION: 删除新闻
    	
	METHOD: GET
	
	PARAM:
	
		news_id	  [int]	   // 新闻 id
	
	RESPONSE: 
	
		{
			"result": 		[bool]		// 操作结果
			"error_code":	[int]		// 错误码
			"message":		[str]		// 错误信息
		}
	
10. /admin/news/[news_id]/remove

	DESCRIPTION: 撤下新闻
    	
	METHOD: GET
	
	PARAM:
	
		news_id	  [int]	   // 新闻 id
	
	RESPONSE: 
	
		{
			"result": 		[bool]		// 操作结果
			"error_code":	[int]		// 错误码
			"message":		[str]		// 错误信息
		}

11. /admin/news/[news_id]

	DESCRIPTION: 获取新闻
    	
	METHOD: GET
	
	PARAM:
	
		news_id	  [int]	   // 新闻 id
	
	RESPONSE: 
	
		{
			"id":			[int]		// 新闻id
			"category_id":	[int]		// 所属板块id
			"title":		[str]		// 新闻标题
			"author":		[str]		// 作者名称
			"highlight_time":	[int]	// 高亮剩余时间 (单位: 时)
			"content":		[str]		// 新闻文本
		}
		
	RESP_DEMO:
	
		{
			"result": true,
			"id": 101,
			"category_id": 12,
			"title": "Department of Electrical Science and Engineering",
			"author": "ACat",
			"highlight_time": 10,
			"content": "ABCDEFG..."
		}

12. /admin/news/list/[category_id]
    	
	DESCRIPTION: 获取新闻列表
    	
	METHOD: GET
	
	PARAM:
	
		category_id	  [int]	   // 父板块或子版块的id
	
	RESPONSE: 
	
		{
			"result": 		[bool]		// 操作结果
			"error_code":	[int]		// 错误码
			"message":		[str]		// 错误信息
			"data": [
				{
					"id":			[int]		// 新闻id,
					"title":        [str]		// 新闻标题,
					"time":			[int]		// 新闻最后修改的时间戳
					"status":		[int]		// 新闻状态. 0 - 待发布, 1 - 已发布, 2 - 已撤回
				}, ...
			]
		}
		
	RESP_DEMO:
	
		{
			"result": true,
			"error_code": 0,
			"message":	null,
			"data": [
				{
					"id": 101,
					"title": "Department of Electrical Science and Engineering",
					"time": 1569411840964,
					"status": 1
				},
				{
					"id": 102,
					"title": "Teaching Center for Experimental Electronic Information",
					"time": 1569411840964,
					"status": 2
				},
			]
		}
		
13. /admin/login

	DESCRIPTION: 用户登录验证
        	
	METHOD: POST
	
	PARAM:
	
		username	[str]		// 用户名
		password	[str]		// 密码
	
	RESPONSE: 
	
		{
			"result": 		[bool]		// 操作结果
			"error_code":	[int]		// 错误码
			"message":		[str]		// 错误信息
		}

14. /admin/password/modify
	
	DESCRIPTION: 修改密码
        	
	METHOD: POST
	
	PARAM:

		password	[str]		// 密码
	
	RESPONSE: 
	
		{
			"result": 		[bool]		// 操作结果
			"error_code":	[int]		// 错误码
			"message":		[str]		// 错误信息
		}