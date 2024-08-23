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

本项目主要借助2018版IDEA书写，因为其最新版本已经将Web Service相关操作隐藏，对Web Service支持不好。为了发布客户端代码，使用IDEA带有的`Generate wsdl from Java code`来生成WSDL文件，然后运行Tomcat来发布。

运行后，`http://localhost:8080/services/Student?wsdl`这个链接就是发布后的WSDL端口。然后客户端需要在src文件夹执行`$ wsimport -s . -p com.webservice.teacher http://localhost:8080/services/Student?wsdl`根据发布的服务生成本地的客户端代码，方便进行函数调用。

### 数据库参数

```
'HOST': 'rm-2zeu3f7e1n5yt10v0co.mysql.rds.aliyuncs.com',
'NAME': 'xml',
'USER': 'root',
'PASSWORD': '*',
'PORT': '3306'
```

### 困难

在开发过程中，遇到了很多难事，网上资料繁杂，也走了许多坑路。

- 最新版本的IDEA和Tomcat对Web Service服务支持很差，不论怎么调试都运行不起来，最终妥协选择了旧版本的IDEA和Tomcat才能正常运行。
- 在Web Service无法传入和传出多个参数（我目前是这样），因此我将多参数传递改为数组传递和字符串传递，不具有规律的参数，我通过字符串数组传递，具有规律的参数，我将其通过逗号连接成一个字符串传递，在另一端再分割取值。
- 服务端对SQL的支持需要导入`mysql-connector-java-8.0.27.jar`包，并且需要放置在根目录的lib文件夹中，才能在客户端调用。

### 运行截图

发布服务：

![image-20211121190240824](https://gitlab.com/imingx/picgo/raw/master/2021/20211121190240.png)

运行截图：

![image-20211121184815295](https://gitlab.com/imingx/picgo/raw/master/2021/20211121184822.png)

#### 以下是教师的操作过程：

账号注册：（输入的数字就是指令）

```
选择登陆老师还是学生账号，或者结束：（1）老师，（2）学生，（3）退出
1
选择登录、注册账号或退出：（1）登录账号，（2）查询所有教师账户信息，（3）注册账号，（4）退出，
2
职工号:123，教师姓名：王老师
职工号:t190617，教师姓名：郭老师
职工号:t19373135，教师姓名：田老师
职工号:tea0，教师姓名：李老师
职工号:teacher01，教师姓名：欧阳老师
选择登录、注册账号或退出：（1）登录账号，（2）查询所有教师账户信息，（3）注册账号，（4）退出，
3
请输入职工号，密码和姓名：
t10001 123456 张老师
注册成功！
选择登录、注册账号或退出：（1）登录账号，（2）查询所有教师账户信息，（3）注册账号，（4）退出，
2
职工号:123，教师姓名：王老师
职工号:t10001，教师姓名：张老师
职工号:t190617，教师姓名：郭老师
职工号:t19373135，教师姓名：田老师
职工号:tea0，教师姓名：李老师
职工号:teacher01，教师姓名：欧阳老师
选择登录、注册账号或退出：（1）登录账号，（2）查询所有教师账户信息，（3）注册账号，（4）退出，
4
您已成功退出老师界面！
选择登陆老师还是学生账号，或者结束：（1）老师，（2）学生，（3）退出
3
成功结束程序！
```

查询和开始、删除课程、查询自己课程的学生：

```shell
选择登录、注册账号或退出：（1）登录账号，（2）查询所有教师账户信息，（3）注册账号，（4）退出，
1
请输入职工号，密码：
t190617 123456
恭喜 t190617 郭老师 登录成功!
t190617 郭老师 已登录，请选择：（1）退出，（2）查询自己所开课程，（3）查询所有课程，（4）开设课程，（5）删除自己所开课程，（6）查询自己课程的学生，（7）修改密码
2
课程id:71，课程名：xml和webservice
课程id:72，课程名：计算机导论
课程id:73，课程名：物联网
课程id:74，课程名：假设学
t190617 郭老师 已登录，请选择：（1）退出，（2）查询自己所开课程，（3）查询所有课程，（4）开设课程，（5）删除自己所开课程，（6）查询自己课程的学生，（7）修改密码
3
课程id:1，课程名：数据结构，开课老师：欧阳老师
课程id:4，课程名：数学建模，开课老师：田老师
课程id:5，课程名：经济管理，开课老师：田老师
课程id:6，课程名：线性代数2，开课老师：田老师
课程id:26，课程名：体育（5），开课老师：欧阳老师
课程id:42，课程名：线性代数，开课老师：欧阳老师
课程id:45，课程名：测试课程，开课老师：欧阳老师
课程id:59，课程名：算法，开课老师：欧阳老师
课程id:68，课程名：算法设计2，开课老师：田老师
课程id:71，课程名：xml和webservice，开课老师：郭老师
课程id:72，课程名：计算机导论，开课老师：郭老师
课程id:73，课程名：物联网，开课老师：郭老师
课程id:74，课程名：假设学，开课老师：郭老师
t190617 郭老师 已登录，请选择：（1）退出，（2）查询自己所开课程，（3）查询所有课程，（4）开设课程，（5）删除自己所开课程，（6）查询自己课程的学生，（7）修改密码
4
请输出开设的课程名：
大数据
开设成功！
t190617 郭老师 已登录，请选择：（1）退出，（2）查询自己所开课程，（3）查询所有课程，（4）开设课程，（5）删除自己所开课程，（6）查询自己课程的学生，（7）修改密码
2
课程id:71，课程名：xml和webservice
课程id:72，课程名：计算机导论
课程id:73，课程名：物联网
课程id:74，课程名：假设学
课程id:75，课程名：大数据
t190617 郭老师 已登录，请选择：（1）退出，（2）查询自己所开课程，（3）查询所有课程，（4）开设课程，（5）删除自己所开课程，（6）查询自己课程的学生，（7）修改密码
5
请输入删除的课程编号:
75
删除成功！
t190617 郭老师 已登录，请选择：（1）退出，（2）查询自己所开课程，（3）查询所有课程，（4）开设课程，（5）删除自己所开课程，（6）查询自己课程的学生，（7）修改密码
2
课程id:71，课程名：xml和webservice
课程id:72，课程名：计算机导论
课程id:73，课程名：物联网
课程id:74，课程名：假设学
t190617 郭老师 已登录，请选择：（1）退出，（2）查询自己所开课程，（3）查询所有课程，（4）开设课程，（5）删除自己所开课程，（6）查询自己课程的学生，（7）修改密码
6
请输入需要查询的课程号，需保证为自己所开课程：
72
-----------------------
学生id:19373136，姓名：郭明明
-----------------------
```



#### 以下是学生的操作过程：

```
选择登陆老师还是学生账号，或者结束：（1）老师，（2）学生，（3）退出
2
选择登录、注册账号或退出：（1）登录账号，（2）查询所有学生账户信息，（3）注册账号，（4）退出，
2
学生id:123，学生姓名：王五
学生id:19373135，学生姓名：田旗舰
学生id:19373136，学生姓名：郭明明
学生id:19373222，学生姓名：白梧桐
学生id:19373223，学生姓名：白梧桐
学生id:19373686，学生姓名：欧阳奎
学生id:19373888，学生姓名：郭德
学生id:19373999，学生姓名：欧阳娜
学生id:stu0，学生姓名：张三
学生id:stu1，学生姓名：李四
选择登录、注册账号或退出：（1）登录账号，（2）查询所有学生账户信息，（3）注册账号，（4）退出，
1
请输入账号，密码：
19373136 123456
恭喜 19373136 郭明明 登录成功!
19373136 郭明明 已登录，请选择：（1）退出，（2）查询已选课程，（3）查询所有课程，（4）选择课程，（5）退选课程，（6）修改密码
2
课程id:1，课程名：数据结构
课程id:5，课程名：经济管理
课程id:6，课程名：线性代数2
课程id:26，课程名：体育（5）
课程id:42，课程名：线性代数
课程id:68，课程名：算法设计2
课程id:72，课程名：计算机导论
课程id:73，课程名：物联网
19373136 郭明明 已登录，请选择：（1）退出，（2）查询已选课程，（3）查询所有课程，（4）选择课程，（5）退选课程，（6）修改密码
3
课程id:1，课程名：数据结构，开课老师：欧阳老师
课程id:4，课程名：数学建模，开课老师：田老师
课程id:5，课程名：经济管理，开课老师：田老师
课程id:6，课程名：线性代数2，开课老师：田老师
课程id:26，课程名：体育（5），开课老师：欧阳老师
课程id:42，课程名：线性代数，开课老师：欧阳老师
课程id:45，课程名：测试课程，开课老师：欧阳老师
课程id:59，课程名：算法，开课老师：欧阳老师
课程id:68，课程名：算法设计2，开课老师：田老师
课程id:71，课程名：xml和webservice，开课老师：郭老师
课程id:72，课程名：计算机导论，开课老师：郭老师
课程id:73，课程名：物联网，开课老师：郭老师
课程id:74，课程名：假设学，开课老师：郭老师
19373136 郭明明 已登录，请选择：（1）退出，（2）查询已选课程，（3）查询所有课程，（4）选择课程，（5）退选课程，（6）修改密码
4
请输入选择的课程编号：
74
选课成功！
19373136 郭明明 已登录，请选择：（1）退出，（2）查询已选课程，（3）查询所有课程，（4）选择课程，（5）退选课程，（6）修改密码
2
课程id:1，课程名：数据结构
课程id:5，课程名：经济管理
课程id:6，课程名：线性代数2
课程id:26，课程名：体育（5）
课程id:42，课程名：线性代数
课程id:68，课程名：算法设计2
课程id:72，课程名：计算机导论
课程id:73，课程名：物联网
课程id:74，课程名：假设学
19373136 郭明明 已登录，请选择：（1）退出，（2）查询已选课程，（3）查询所有课程，（4）选择课程，（5）退选课程，（6）修改密码
5
请输入需要退选课程的编号：
74
退课成功！
19373136 郭明明 已登录，请选择：（1）退出，（2）查询已选课程，（3）查询所有课程，（4）选择课程，（5）退选课程，（6）修改密码
2
课程id:1，课程名：数据结构
课程id:5，课程名：经济管理
课程id:6，课程名：线性代数2
课程id:26，课程名：体育（5）
课程id:42，课程名：线性代数
课程id:68，课程名：算法设计2
课程id:72，课程名：计算机导论
课程id:73，课程名：物联网
19373136 郭明明 已登录，请选择：（1）退出，（2）查询已选课程，（3）查询所有课程，（4）选择课程，（5）退选课程，（6）修改密码
6
请输入原密码和新密码：
123456 123
修改密码成功！
```
