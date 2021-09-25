# 安装
- https://gper.club/answers/7e7e7f7ff5g5cgc2g6c
    ```yaml
    # Docker部署单机示例
    # 后台运行rabbitmq镜像
    docker run -it -d --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
    # 进入容器
    docker exec -it [container id] bin/bash
    # 添加root用户，默认guest用户只能本地访问
    rabbitmqctl add_user root root
    # 赋予root用户所有权限
    rabbitmqctl set_permissions -p / root ".*" ".*" ".*"
    # 赋予root用户administrator角色
    rabbitmqctl set_user_tags root administrator
    # 查看所有用户
    rabbitmqctl list_users
    ```
