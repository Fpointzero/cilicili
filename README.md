# cilicili

## 项目简介

本项目是一个仿bilibili的视频播放网站，有视频上传，收藏，历史记录，搜索，个人信息管理，邮件验证码登录等。

温馨提示：本项目仅用于学习，切勿用于实际项目。

## 部署

### 数据库设置

`resources/mybatis-config.xml`中修改设置

#### 文件服务器设置

在Setting.java中

设置`UPLOAD_ROOT`为视频等文件所在的位置，例如默认是`D:/cilicili_files`在这里开启一个nginx服务器作为访问到文件服务器即可

然后把`FILE_SERVER`设置成nginx服务器地址。然后编译部署到TOMCAT上面即可。

#### 邮件设置

Setting.java中

```java
public static String senderEmail = "******"; // 例如:1@qq.com
public static String senderPassword = "*******"; // 这里填写授权码，qq密码是不可以的
public static String smtpHost = "smtp.qq.com";
public static int smtpPort = 587;
```



## 界面

界面如下：

首页：

![image-20240119153328562](https://gitee.com/fpointzero/imgforit/raw/master/img/image-20240119153328562.png)



用户页面：

![image-20240119153355839](https://gitee.com/fpointzero/imgforit/raw/master/img/image-20240119153355839.png)



创作中心：

![image-20240119153417702](https://gitee.com/fpointzero/imgforit/raw/master/img/image-20240119153417702.png)



创作列表：

![image-20240119153455465](https://gitee.com/fpointzero/imgforit/raw/master/img/image-20240119153455465.png)



个人中心：

![image-20240119153519464](https://gitee.com/fpointzero/imgforit/raw/master/img/image-20240119153519464.png)

