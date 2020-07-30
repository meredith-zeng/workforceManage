# workforceManage【人力资源管理系统】
## 从JSP+Servlet+JDBC出发
### jdbc操作mysql数据库版本的人力资源管理系统
#### 作业要求
使用servlet,jsp,jstl,EL表达式+Mysql完成人力资源管理系统
#### 功能要求
1. 添加员工
2. 根据员工编号查询员工
3. 显示所有员工
4. 修改员工信息
5. 员工离职
#### 实现要求
1. 使用MVC+Mysql
2. 代码命名规范,注释清楚
3. 异常处理完善
4. jsp页面里使用jstl+el表达式,不允许出现java代码

## 数据库使用Mybatis操作
### 配置mybatis-config

### 对应的实体类建立Mapper的接口和xml
1. 在java目录下的控制层包中的mapper包里创建mapper接口

2. 在resources目录下的mapper包里创建mapper的xml文件，namespace指向接口的全称包路径

3. 在mybatis-config，xml文件中配置mapper的映射路径，只需要配置mapper的xml路径即可
> 不能在有命名空间的情况下再次配置接口路径，会报已经注册过的错误
### junit对接口类进行测试
#### 使用方式
1. 使用maven引入junit依赖
```xml
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
    </dependency>

```
2. ctrl+shift+T快速使用junit生成单元测试的模板

### 写DAO层接口
```java
public class MyBatisConnection {
           private static InputStream inputStream;
           private static SqlSessionFactory sqlSessionFactory;
       
//使用sqlSessionThreadLocal，不能直接把session写成公有
           private static ThreadLocal<SqlSession> sqlSessionThreadLocal = new ThreadLocal<>();
           
static {
               try {
                   inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                   sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
       
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       
       
           public MyBatisConnection() {
           }
       
           private static SqlSession getSqlSession(boolean commit){
               SqlSession session = sqlSessionThreadLocal.get();
       //true为事务，会自动提交事务
               if( null == session ){
                   if (commit){
                       session = sqlSessionFactory.openSession(true);
                   }else{
                       session = sqlSessionFactory.openSession(false);
                   }
       
                   sqlSessionThreadLocal.set(session);
               }
       
               return session;
           }
       
           public static EmployeeMapper getEmployeeMapper(boolean commit)  {
               SqlSession session = getSqlSession(commit);
       
               EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
       
               return employeeMapper;
           }
       
       //一定要在session关闭后，把sqlSessionThread也给remove了
           public static void closeSqlSession() {
               SqlSession session = sqlSessionThreadLocal.get();
               if( null != session ) {
                   session.close();
               }
               sqlSessionThreadLocal.remove();
           }
       
       }

```
### Servlet中调用DAO接口踩的坑
创建dao实例的时候要注意要放在方法里面，不能放在外面，否则会只在servelt的session生命周期开启第一次时执行，后面再执行doPost的时候sqlSession就已经被关闭无法使用了

# Sping mvc编程
1. 导入spring-context和spring-test
```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.28.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>4.3.28.RELEASE</version>
      <scope>test</scope>
    </dependency>
</dependencies>
```
2. 在resources目录下创建spring-config.xml

## 开发顺序
### Model
### DataBase
### service
### controller
### view