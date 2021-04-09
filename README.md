# 说明

## 修改配置文件

### 启动SpringBoot修改

* application-dev.properties中的数据库配置修改为自己的

### Generator配置修改

#### 不需要实体类字段添加中文注解

* 将pom中的plugin注释掉的内容打开
* 将mybatis-generator-config.xml中的commentGenerator标签中的type删除
  ```xml
    <!-- todo 修改：抑制生成注释，由于生成的注释都是英文的，可以不让它生成，将type修改为自己定义的注释配置实体位置；不需要按照自己的配置信息生成实体字段注解就将type="com.wedding.project.configuration.generator.comment.MySQLCommentGenerator"删除 -->
    <commentGenerator>
        <!-- suppressAllComments:阻止生成注释，默认为false -->
        <property name="suppressAllComments" value="false"/>
        <!-- suppressDate:阻止生成的注释包含时间戳，默认为false -->
        <property name="suppressDate" value="true"/>
        <!-- 生成创建人 -->
        <property name="Author" value="Programmer"/>
        <!-- 生成创建日期 -->
        <property name="DateFormat" value="yyyy/MM/dd"/>
    </commentGenerator>
  ```
* 将mybatis-generator-config.xml中的自定义plugin标签删除
  ```xml
    <!-- 将自定义的SwaggerPlugin和LombokPlugin直接删除 -->
    <plugin type="com.gudao.generator.generatorconfig.comment.SwaggerPlugin">
        <!-- 添加swagger中的jar包，留作在配置注释方法中使用 -->
        <property name="apiModelAnnotationPackage" value="io.swagger.annotations.ApiModel" />
        <property name="apiModelPropertyAnnotationPackage" value="io.swagger.annotations.ApiModelProperty" />
    </plugin>
    <plugin type="com.gudao.generator.generatorconfig.comment.LombokPlugin">
        <!-- 添加lombok中的jar包，留作在配置注释方法中使用 -->
        <property name="lombokDataAnnotationPackage" value="lombok.Data" />
        <property name="lombokToStringAnnotationPackage" value="lombok.ToString" />
    </plugin>
  ```
* 根据修改配置文件`mybatis-generator-config.xml` `generatorConfig.properties`（内部有修改的注释，根据注释修改）；maven运行generator插件

#### 需要实体类字段添加中文注解

* 根据修改配置文件`mybatis-generator-config.xml` `generatorConfig.properties`（内部有修改的注释，根据注释修改）
* 运行`CommentStart`实体类中的main方法