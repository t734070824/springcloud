2019-06-13

## Eureka

### 服务注册中心
1. 失效剔除
    - 定时任务
    - 间隔 60s
    - 超过 90s 剔除
2. 自我保护
    - 维护心跳连接
    - 心跳失败比例在 15min 低于 85% 
    - 保护当前实例, 让实例不过期
    - 会出现客户端调用失败的
    - 需要 客户端 请求重试, 断路器
    
### 源码分析 client
1. 注册
    - 独立一个 thread, 单词
    - instanceInfoReplicator
        - 注册 instanceInfo
2. 服务获取
    - eureka.client.fetch-registry=true
        - 是否从server 拉取服务
    - CacheRefreshThread
        - **根据是否是第一次 发起不同的请求**
3. 服务续约 / 心跳
    - 一起的

### 源码分析 server
1. ConcurrentHashMap<Appname, <Appid, instanceInfo>>

### 常用配置
1. 服务注册相关
    - 注册中心地址
    - 服务获取的间隔时间
    - 可用区域
2. 服务实例
    - 名称
    - IP
    - 端口
    - 健康检查路径