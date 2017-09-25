# e3Shop-SSM

商城系统,基于SOA, 使用Maven架构

### 项目架构

```
- shop-parent		// 父工程,用于版本控制

	- shop-common		// 基本工具类

	- shop-manager		// 服务端

		- shop-manager-dao		// dao层(数据持久层)

		- shop-manager-interface		// 接口层

		- shop-manager-pojo		// pojo类

		- shop-manager-service		// service

	- shop-manager-web		// 客户端
	
``` 