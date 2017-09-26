# e3Shop-SSM

商城系统,基于SOA, 使用Maven架构 , dubbo , nginx 

### 项目架构

```
- shop-parent		// 父工程,用于版本控制

	- shop-common		// 基本工具类

		- qiniu.properties		// 七牛云上传配置

	- shop-manager		// 服务端

		- shop-manager-dao		// dao层(数据持久层)

		- shop-manager-interface		// 接口层

		- shop-manager-pojo		// pojo类

		- shop-manager-service		// service

			- db.properties		// 数据库配置文件
			
			- mybatis		// mabatis配置文件夹

			- spring		// spring 配置文件夹

			- log4j.properties		// 日志配置文件

	- shop-manager-web		// 客户端

		- resource.properties		// 七牛云外链配置

		- spring		// springMVC配置文件

		- log4j.properties		// 日志文件
```
 
###

- 图片服务器 : 七牛云
