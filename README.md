#说明

## 修改配置文件
### 启动SpringBoot修改
* application-dev.properties中的数据库配置修改为自己的

### Generator配置修改
#### 不需要实体类字段添加中文注解
* 将pom中的plugin注释掉的内容打开
* 将mybatis-generator-config.xml中的commentGenerator标签中的type删除
* 根据修改配置文件`mybatis-generator-config.xml` `generatorConfig.properties`（内部有修改的注释，根据注释修改）；maven运行generator插件

#### 需要实体类字段添加中文注解
* 根据修改配置文件`mybatis-generator-config.xml` `generatorConfig.properties`（内部有修改的注释，根据注释修改）
* 运行`CommentStart`实体类中的main方法