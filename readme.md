## Maven+springmvc+spring+mybatis+mysql+dubbo+redis高仿饿了吗外卖点餐系统

[![Build Status](https://github.com/tingbao10/)](https://github.com/tingbao10/) [![springmvc](https://github.com/tingbao10)](https://github.com/tingbao10) [![license](https://github.com/tingbao10)](https://github.com/tingbao10)

`chileme`是一个基于其他搜索引擎构建的垂直小说搜索引擎，owllook目的是让阅读更简单、优雅，让每位读者都有舒适的阅读体验，如**搜书、阅读、收藏、追更、推荐等功能**：

- 演示网址：[暂无](https://github.com/tingbao10)
- 微信号：[**西瓜儿**](https://github.com/tingbao10/img/blob/master/wechatadd.jpg)，有兴趣的话可以添加下
- 详细安装介绍：[详细安装介绍](https://github.com/tingbao10/chileme)


衍生项目：

- 等： [等待更新](https://github.com/tingbao10/)
- 暂无：[等待更新](https://github.com/tingbao10/)
- 等待更新：[等待更新](https://github.com/tingbao10/)

**注意**：若将本项目部署并发行，请**声明来源**，本项目纯属**共享学习之用，不得用于商业！**

### Overview

`chileme`项目采用 springmvc+spring+mybatis+mysql+dubbo+redis 方式架构，mvc模式开发，dao工厂模式，spring管理组件，数据源以及控制事物，springmvc实现mvc，RESTFUL风格开发，使用 dubbo 与账务系统通信，前端采用http+ajax，  项目主要包括，菜单管理模块，用户管理模块，任务管理, 短信注册等


#### Installation

请先装好mongo以及redis，不会安装mongo看[这里](https://www.digitalocean.com/community/tutorials/how-to-install-mongodb-on-centos-7)


项目环境:

	jdk 1.7     
	Tomcat 7
	分布式 dubbo
	
项目启动流程:

		1:下载 zookeeper-3.3.6 

		2:下载 redis 

		3:修改 service resources下面的jdbc,properties 配置文件 (链接数据库的  username And password)

		4:启动 zookeeper (点击 -----  zookeeper-3.3.6\bin\zkServer.cmd) 启动

		5:启动:redis          (点击 -----  redis\redis-server.exe)启动

		6: 将sql备份文件通过: Navicat 还原备份即可

		全部完成之后

		最后一步:

		将 chilema 放到Tomcat 下面 启动 容器 

		浏览器输入:http://localhost:888/chilema/ 访问项目

		{由于 用户注册使用了短信验证来注册 项目没有上线. 用户登录的话 使用默认的用户登录的话  请到数据库里面找到user表  根据 loginUser字段为账号
		 密码默认: 123456789  进行登录


```shell
# 下载代码
git clone https://github.com/tingbao10/chileme

```




#### Features

- 功能模块
- 用户注册/登录
- 用户个人信息
- 用户下单
- 商家登录/注册商家
- 上传菜品
- 查看订单
- 登录
- 初步兼容手机（后续跟进）
- 注册（开放注册）
- 上次浏览记录
- 最新章节
- 菜单推荐（简单地基于相似度进行推荐）
- 菜单获取
- 翻页
- 搜索排行
- 可以优化前端，使用Vue.js等框架，对项目感兴趣的可以试试

#### TODO

- [ ] 评分
- [ ] 前端优化
- [ ] 推荐
- [ ] 附近地图等

### Screenshots

首页:

![](https://github.com/tingbao10/img/blob/master/chileme/logo.png)

登录：

![](https://github.com/tingbao10/img/blob/master/chileme/login.png)

注册：

![](https://github.com/tingbao10/img/blob/master/chileme/regCus.png)



### FAQ

**为什么导入项目有报错？**

maven仓库下载，其次依赖点击 properties  Deployment Assembly 点击Add 将 api添加到chilema


### Reference

**chileme使用了以下第三方包:**

- Maven 仓库管理

- springMVC：MVC分层思想

- ​mybatis：持久层框架

- spring：解决业务逻辑层和其他各层的松耦合问题

- dubbo：SOA服务化治理方案

- mysql： 数据库类型

- Redis: 缓存数据

**web框架：**

- [bootstrap](https://github.com/twbs/bootstrap)：Sleek, intuitive, and powerful front-end framework for faster and easier web development. 


### License

`chileme` is offered under the Apache 2 license.

### Donate

**捐赠：**

> 美酒加咖啡，我只要喝一杯～

<img src="https://github.com/tingbao10/img/blob/master/Alipay.png" width = "400" height = "400" alt="donate" align=center />

<img src="https://github.com/tingbao10/img/blob/master/wechat.png" width = "400" height = "400" alt="donate" align=center />

感谢以下捐赠者，具体见[捐赠名单](./DONATE.md) ^_^
