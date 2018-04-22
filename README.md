# stc-practice
上手STC开发

> 现在的任务不用按照sinosteel框架，用spring-boot开发一个简单的登录和用户管理系统

# 主要包括的内容

> 这里的参考代码均为sinosteel框架里的代码

## 1.用户类设计

想一下用户类应包含哪些属性和方法
书写规则参考代码 
sinosteel\server\framework\src\main\java\com\sinosteel\framework\system\auth\domain\Role.java

注意这里的代码继承自基类BaseEntity

BaseEntity在下列代码中定义
sinosteel\server\framework\src\main\java\com\sinosteel\framework\core\base\domain\BaseEntity.java

## 2.数据访问层
学习spring data jpa技术，实现数据访问层控制用户类的访问

[参考教程](http://blog.didispace.com/springbootdata2/)

参考代码 

sinosteel\server\framework\src\main\java\com\sinosteel\framework\core\base\repository\BaseRepository.java文件

## 3.业务逻辑层
参考代码 

sinosteel\server\framework\src\main\java\com\sinosteel\framework\core\base\service\BaseSee.java文件

## 4.控制交互层
参考代码 

sinosteel\server\framework\src\main\java\com\sinosteel\framework\core\base\web\BaseController.java文件

## 5.数据库

配置一个数据库

添加两个表项一个为工作人员，一个为超级管理员，表项设计应跟1.用户类设计保持一致。


# 关于教程

我在群里上传了官方文档(英文原版和中文翻译版都有),可以作为参考

# 需要完成的任务

1.超级管理员认证登录

2.工作人员账户注册

3.工作人员账户管理

4.工作人员登录认证

希望大家合作完成
