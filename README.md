# 开发文档

SSO 主要提供一个单点登录，那么这个单点登录校验只有在访问受限资源的时候才会被调用

主要技术包括
* MySQL 5.7
* Redis 5.0.4


## 用例图

![image-20190407020750775](img/image-20190407020750775.png)



## 活动图

### 鉴权活动图

![image-20190407022735313](img/image-20190407022735313.png)

* 使用 Redis 查看 token 缓存，避免对 JWT 解密时间消耗

### 授权活动图

![image-20190407163104375](img/image-20190407163104375.png)

## 时序图

### 鉴权时序图

![image-20190407025627184](img/image-20190407025627184.png)



### 授权时序图

![image-20190407164534087](img/image-20190407164534087.png)

