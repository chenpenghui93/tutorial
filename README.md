# tutorial
- Java Web工具集

## Java Web
- wsimport方式生成webservice客户端代码<br>
`wsimport -s d:\download\wsdl\ -keep -p com.stock -verbose -Xnocompile http://www.webxml.com.cn/WebServices/StockInfoWS.asmx?wsdl`
  - `-d` 生成客户端执行类的class文件的存放目录
  - `-s` 生成客户端执行类的源文件的存放目录
  - `-keep` 表示导出webservice的class文件时是否也导出源代码java文件
  - `-p` 定义生成类的包名
  - `-verbose` 显示生成过程
  - `-Xnocompile` 取消生成class文件  
  
- Maven上传jar包至Nexus仓库所需配置
    ```xml
    <!-- 1、项目pom文件中增加配置，参考如下 -->
    <distributionManagement>
        <snapshotRepository>
            <id>xxx-nexus</id>
            <url>http://nexus.xxx.com/repository/maven-xxx-snapshot</url>
        </snapshotRepository>
        <repository>
            <id>xxx-nexus</id>
            <url>http://nexus.xxx.com/repository/maven-xxx-snapshot</url>
        </repository>
    </distributionManagement>
    
    <!-- 2、本地.m2目录下settings.xml配置server信息，参考如下 -->
    <server>
        <id>xxx-nexus</id>
        <username>contributor</username>
        <password>密码</password>
    </server>
    
    <!-- 3、本地.m2目录下新建settings-security.xml，参考如下 -->
    <settingsSecurity>
        <master>密码</master>
    </settingsSecurity>
    ```

## Git
- git clone从A库同步至B库(新项目)  
  - New project → import project → Repo by URL  
- git fork同步其它仓库最新代码(已有项目)  
  1. 添加远程资源 `git remote add upstream http://xxx/xxx.git`  
  2. 拉取分支信息 `git fetch upstream`  
  3. 更新分支信息 `git merge upstream/dev develop`  
  4. 推送代码 `git push origin develop`  

## 配置文件加密  

- https://segmentfault.com/a/1190000022462721

1. 添加依赖

   ```xml
   <dependency>
   	<groupId>com.github.ulisesbocchio</groupId>
   	<artifactId>jasypt-spring-boot-starter</artifactId>
   	<version>3.0.3</version>
   </dependency>
   ```

2. application.yml文件中配置密钥

   ```yaml
   jasypt:
     encryptor:
       #待替换密钥
       password: 4G4tN0z2v<u*Wm0
   ```

3. 运行测试类获取加密后的配置信息

   ```java
   @Autowired
   StringEncryptor encryptor;
   
   /**
    * 配置文件信息加密
    */
   @Test
   public void jasyptEncryptTest(){
   	String url = encryptor.encrypt("jdbc:mysql://localhost:3306/test?useSSH=false&serverTimezone=GMT%2B8");
   	String username = encryptor.encrypt("root");
   	String password = encryptor.encrypt("root");
   	System.out.println(url);
   	System.out.println(username);
   	System.out.println(password);
   }
   ```

4. 更改配置文件，`ENC()`为固定格式

   ```yaml
   spring:
     datasource:
       driver-class-name: com.mysql.cj.jdbc.Driver
       url: ENC(bGG7tm8+7kLojm38xlTdpWxJQEkmJQ7J81Dxvqxst9W+xipt1m4JRCHrBAFEfzllfqgOov3GhmGkLfi4HDUh4gifYjJdXbGY70HY7zNpEKprWK/YUOcMqQFYuILsYBYFB8NruftZ8kiX6crMDnJ0RA==)
       username: ENC(IUvBHgnU0DyPPSWfuObpmf0i/9FtTzc60leI2H2p0URZmKSEvMtavO3+E2pUeAXu)
       password: ENC(S1yH8TM+TcsHr/8bk+YQpVcRRBZX6aipuJU0hA9g8F1kqqSsFbNpCLt7HEX2bQ/8)
   ```

5. 运行测试类可查看解密后的配置信息

   ```java
   @Test
   public void jasyptDecryptTest(){
   	String url = "bGG7tm8+7kLojm38xlTdpWxJQEkmJQ7J81Dxvqxst9W+xipt1m4JRCHrBAFEfzllfqgOov3GhmGkLfi4HDUh4gifYjJdXbGY70HY7zNpEKprWK/YUOcMqQFYuILsYBYFB8NruftZ8kiX6crMDnJ0RA==";
   	String username = "IUvBHgnU0DyPPSWfuObpmf0i/9FtTzc60leI2H2p0URZmKSEvMtavO3+E2pUeAXu";
   	String password = "S1yH8TM+TcsHr/8bk+YQpVcRRBZX6aipuJU0hA9g8F1kqqSsFbNpCLt7HEX2bQ/8";
   	System.out.println(encryptor.decrypt(url));
   	System.out.println(encryptor.decrypt(username));
   	System.out.println(encryptor.decrypt(password));
   
   	Environment environment = context.getBean(Environment.class);
   	String originUrl = environment.getProperty("spring.datasource.url");
   	String originUsername = environment.getProperty("spring.datasource.username");
   	String originPassword = environment.getProperty("spring.datasource.password");
   	System.out.println(originUrl);
   	System.out.println(originUsername);
   	System.out.println(originPassword);
   }
   ```

   