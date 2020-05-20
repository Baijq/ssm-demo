### 3.2 ssm项目构建步骤

#### 3.2.1 构建maven项目结构
```
src
  -main
    -java
      -com.demo.config
      -com.demo.controller
      -com.demo.service
      -com.demo.mapper
      -com.demo.entity
    -resources
      -mapper/XxxMapper.xml
      -spring
        -applicationContext.xml
        -spring-mvc.xml
        -springs-ervice.xml
        -spring-dao.xml
      -jdbc.properties
      -mybatis-config.xml
    -webapp
      -WEB-INF
        -views
        -web.xml
      index.jsp
  -test
    -java
    -resources
pom.xml
README.md
```
#### 3.2.2 完善配置文件
1. [web.xml](./doc/other/web.xml) 入口文件，项目启动自动加载
2. [applicationContext.xml](./doc/other/applicationContext.xml) web.xml里配置init-param会加载applicationContext.xml文件，本配置中引入spring-*.xml，所以接下来配置spring-*.xml（3.4.5）文件。
3. [spring-mvc.xml](./doc/other/spring-mvc.xml) 对应controller层，主要配置包扫描/开启注解/视图解析器...
4. [spring-service.xml](./doc/other/spring-service.xml) 对应service层，配置service的对象管理（采用注解的时候可不写）
5. [spring-mapper.xml](./doc/other/spring-mapper.xml) 对应数据持久层，整合mybatis框架都在这里配置。这个依赖于以下3个配置：（6）jdbc.properties、（7）持久层接口UserMapper、（8）映射文件XxxMapper.xml、和（9）mybatis-config.xml这几个文件
6. [jdbc.properties](./doc/other/jdbc.properties) 数据库连接相关信息 **这个里面注意下mysql的url和驱动，mysql8.0版本之后变了，有坑**
7. [com.demo.mapper.UserMapper](./doc/other/UserMapper.java) 对应下面的接口映射文件
8. [XxxMapper.xml](./doc/other/UserMapper.xml) 这个是mybatis持久层接口的映射文件。这里用UserMapper举例
9. [mybatis-config.xml](./doc/other/mybatis-config.xml) mybatis的配置文件，其实大部分内容已经抽离到spring-dao里去了，是可以省略的。为了项目完整性，这里保留
10. [com.demo.mapper.entity.User](./doc/other/User.java) 实体类，对应数据库中的表
11. [com.demo.mapper.service.UserService](./doc/other/UserService.java) 这一步来写service接口
12. [com.demo.mapper.service.impl.UserServiceImpl](./doc/other/UserServiceImpl.java) service实现类
13. [com.demo.mapper.controller.UserController](./doc/other/UserController.java) controller层测试类，会返回index.jsp的视图
14. [index.jsp](./doc/other/index.jsp) controler会返回一个视图，对应新建一个index.jsp放到views下面