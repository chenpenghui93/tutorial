# Apollo 分布式配置管理中心  

## 特性
- 统一管理不同环境、不同集群的配置
- 配置修改实时生效(热部署)
- 版本发布管理
- 灰度发布
- 权限管理、发布审核、操作审计

## 概念
- 项目 
- 应用  
  - 集群(cluster)
    - 一个应用下不同实例的分组，适用于按 技术/部署 的层面做划分进行配置共享
  - 命名空间(namespace)  
    - 一个应用下不同配置的分组，适用于按 项目/小组/部门/公司等 的层面做划分进行配置共享
  - 环境

## 使用
1、客户端添加maven依赖
```xml
<!-- https://mvnrepository.com/artifact/com.ctrip.framework.apollo/apollo-client -->
<dependency>
  <groupId>com.ctrip.framework.apollo</groupId>
  <artifactId>apollo-client</artifactId>
  <version>1.5.0</version>
</dependency>
```
2、启动类、配置类增加注解`@EnableApolloConfig`
3、Apollo portal环境中新建项目、配置
4、yml文件中指定appId
```yaml
# Apollo应用id
app:
  id: xx-yy-zz
apollo:
  bootstrap:
    enabled: true
    # 命名空间(多个则以逗号隔开)
    namespaces: application
```
5、Dockerfile中指定环境参数
```shell
"-Dapp.id=xx-yy-zz","-Dapollo.configService=https://apollo-config-server-dev.xxx.com" ,"-Denv=DEV"
#指定使用pre集群
"-Dapp.id=xx-yy-zz","-Dapollo.configService=http://service-apollo-config-server-xxx.infra:8080","-Denv=ONLINE","-Dapollo.cluster=pre"
```

## 参考
- [Apollo官网文档](https://www.apolloconfig.com/#/zh/)
  - [集群配置及加载顺序](https://www.apolloconfig.com/#/zh/usage/java-sdk-user-guide?id=_1242-cluster%ef%bc%88%e9%9b%86%e7%be%a4%ef%bc%89)
- [Github源码](https://github.com/apolloconfig/apollo)

