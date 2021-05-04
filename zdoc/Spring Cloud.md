### 微服务技术选型
- 服务注册与发现 spring-cloud-starter-alibaba-nacos-config
- 服务网关 spring-cloud-starter-gateway
- 服务调用 spring-cloud-starter-openfeign
- 服务熔断、降级，服务限流 spring-cloud-starter-alibaba-sentinel
- 负载均衡 spring-cloud-starter-netflix-ribbon

### 微服务架构--幂等问题
- 什么是幂等 https://juejin.cn/post/6906290538761158670
  - 用户对同一个操作发起多次请求以后，对数据的影响结果是不变的，一次请求和n次请求的结果都是一样的
- 常见场景：
  - 网络波动
  - 分布式消息消费
  - 用户重复操作
  - 未关闭的重试机制
- 常见问题
  - 电商超卖现象
    - 直接对读操作加显示锁
    - 有条件有选择的在读操作上加锁
  - 重复转账、扣款或付款
  - 重复增加积分、优惠券
- 解决方案
  - 全局唯一ID：根据业务的操作和内容生成一个分布式全局id，在执行操作前先根据全局唯一id是否存在，来判断当前操作是否已经执行
              如果不存在，则执行操作并存储全局唯一id；如果存在则表示该方法已经执行；考虑使用snowflake算法、数据库号段模式、Redis存储防重token令牌
  - 数据库的唯一性约束：对某一个关键数据设置一个唯一索引，重复请求过来之后无法正常入库，抛出一个重复异常，服务端可以捕获这个异常
  - 乐观锁多版本控制：增加版本号字段进行标识，只适用于更新操作；`where id=1 and version=5`第一次更新成功后version+1变为6，重复请求过来后无法更新成功
  - 状态机幂等控制：状态机流转

