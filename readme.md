## XML&Web Service作业说明文档

### 简介

本作业是一个Java开发的基于Web Service的小程序，在命令行端实现简单的选课系统，数据存放在阿里云的数据库中，包括学生选课、退课、查询课程和更改密码，教师开课、关课、查询自己开设课程和查询自己课程的学生及更改密码。服务端存放各种数据库指令，客户端存放交互指令，客户端通过Web Service服务与服务端交互。

### 依赖

- `Tomcat9` & `Apache Axis`
- `Intellij IDEA 2018.3.6`
- `JDK8`
- `MySQL`

### 运行方式

先配置IDEA的Tomcat环境，通过Tomcat运行服务端，再运行客户端的Client文件即可。

### 代码结构

分为两个项目，一个是服务端`WebService`，一个是客户端`Client`。

服务端主要编写了三个文件，分别为`Studenet.Java`、`Teacher.Java`、`MySQL.Java`，其中`MySQL.Java`存放操作数据库的指令（这里需要在项目的lib文件夹内存放Mysql依赖`mysql-connector-java-8.0.27.jar`）。Student、Teacher文件分别存放学生和老师相关指令的接口，内部调用数据库的指令。其代码结构如下：

```shell
WebService
    └─src
       └─server
       		├─MySQL.Java
            ├─Student.Java
            ├─Student.wsdl
            ├─Teacher.wsdl
            └─Teacher.Java
```

客户端主要编写了三个文件`Client.Java`、`MyStudent.Java`和`MyTeacher.Java`。这三个文件都是主要进行命令行交互，并调用服务端的接口，来实现学生退选课、教师开关课、改密码等操作。

本项目主要借助2018版IDEA书写，因为其最新版本已经将WebSevice相关操作隐藏，对WEBService支持不好。为了发布客户端代码，使用IDEA带有的`Generate wsdl from Java code`来生成WSDL文件，然后运行Tomcat来发布。

运行后，`http://localhost:8080/services/Student?wsdl`这个链接就是发布后的WSDL端口。然后客户端需要在src文件夹执行`$ wsimport -s . -p com.webservice.teacher http://localhost:8080/services/Student?wsdl`根据发布的服务生成本地的客户端代码，方便进行函数调用。

### 数据库参数

```
'HOST': 'rm-2zeu3f7e1n5yt10v0co.mysql.rds.aliyuncs.com',
'NAME': 'xml',
'USER': 'root',
'PASSWORD': 'myja&*$4X579cKr',
'PORT': '3306'
```

### 困难

在开发过程中，遇到了很多难事，网上资料繁杂，也走了许多坑路。

- 最新版本的IDEA和Tomcat对Web Service服务支持很差，不论怎么调试都运行不起来，最终妥协选择了旧版本的IDEA和Tomcat才能正常运行。
- 在Web Service无法传入和传出多个参数（我目前是这样），因此我将多参数传递改为数组传递和字符串传递，不具有规律的参数，我通过字符串数组传递，具有规律的参数，我将其通过逗号连接成一个字符串传递，在另一端再分割取值。
- 服务端对SQL的支持需要导入`mysql-connector-java-8.0.27.jar`包，并且需要放置在根目录的lib文件夹中，才能在客户端调用。

### 运行截图









