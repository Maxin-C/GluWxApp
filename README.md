# GluWxApp

使用方法：

在Spring Boot官网找到Spring Boot Initializer生成Spring Boot文件包，打开文件包，在有`src`文件夹那一页将库内文件覆盖原文件即可。

## 软件层级介绍

### java文件夹

`controller`：控制层，设置API路径帮助前端请求执行对应服务

`domain`：Bean层，根据数据库表单选项创建的JavaBean

`mapper`：接口层，设置接口调用MyBatis定义的数据库操作

`service`：处理前端传入的字符串，并转化为Bean对象传入接口

### resource文件夹

`mapper`：mybatis的具体操作定义文件

## API操作介绍

API文档可以参考：https://documenter.getpostman.com/view/13449221/UVJeFbSb

注意事项：

1. 传入参数时需要注意数据格式，注意区分`"1"`和`1`的区别，传入的时间格式默认为`yyyy-MM-dd`格式，如果需要`yyyy-MM-dd hh:mm:ss`格式的数据存储，请联系开发人员对代码进行更改。

2. 请求时注意请求方法，区分`POST`和`GET`方法，一般而言，`add`、`update`和`delete`都是`POST`请求，`find`操作为`GET`请求。

   PS：这个代码里面写错了其实也没关系

3. 由于数据库设计原因，创建新列的时候需要所有数据，因此`add`操作和`update`操作`new`对象的部分都需要填写所有信息。其余请求可以视情况而填，不填就意味着请求所有。

   PS：即使是不填任何内容，请求的`data`里面也需要是`{}`，不能什么都没有。

