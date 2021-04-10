package com.gudao.generator.generatorconfig.comment;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;
import java.util.Properties;

/**
 * @Auther: Gudao
 * @Date: 2021/3/26 14:57
 * @Description: Lombok集成入实体
 * 特殊说明: 该类可以不写，可以集成进MySQLCommentGenerator进行配置，也可以集成进LombokPlugin，两种方法都可以（就是将<property>标签信息移动的问题，我这样配置只是为了让其看起来更清晰）
 */
public class SwaggerPlugin extends PluginAdapter {
    // 属性，即配置在 plugin 标签之内的 Property 标签
    private final Properties properties = super.getProperties();

    public boolean validate(List<String> list) {
        return true;
    }

    /**
     * 模型上添加注解【添加@ApiModel(value="表名")】
     *
     * @param topLevelClass     顶级类
     * @param introspectedTable 进行自检表
     * @return boolean
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // 导入需要的jar包方法一（需要再配置文件中指定所需的jar包地址）
        String apiModelAnnotationPackage;
        String apiModelPropertyAnnotationPackage;
        // 表说明
        String tableRemarks = introspectedTable.getRemarks();
        if(null != (apiModelPropertyAnnotationPackage = properties.getProperty("apiModelPropertyAnnotationPackage"))){
            topLevelClass.addImportedType(apiModelPropertyAnnotationPackage);
        }
        if(null != (apiModelAnnotationPackage = properties.getProperty("apiModelAnnotationPackage"))){
            // 添加import信息
            topLevelClass.addImportedType(apiModelAnnotationPackage);
            // 添加swagger注解
            String annotatedInfo = "@ApiModel(value=\"" + (tableRemarks==null || "".equals(tableRemarks)  ? topLevelClass.getType().getShortName() : tableRemarks) + "\")";
            topLevelClass.addAnnotation(annotatedInfo);
        }

        return true;
    }

    /**
     * 模型字段上加注解【@ApiModelProperty(value="字段名称", name="id",dataType="Integer")】
     *
     * @param field              场
     * @param topLevelClass      顶级类
     * @param introspectedColumn 进行自检列
     * @param introspectedTable  进行自检表
     * @param modelClassType     模型类类型
     * @return boolean
     */
    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        String fieldRemarks = introspectedColumn.getRemarks();
        String apiModelPropertyAnnotationPackage;
        if(null != (apiModelPropertyAnnotationPackage = properties.getProperty("apiModelPropertyAnnotationPackage"))){
            topLevelClass.addImportedType(apiModelPropertyAnnotationPackage);
            if(null != fieldRemarks){
                field.addAnnotation("@ApiModelProperty(value=\"" + fieldRemarks + "\", name=\""+introspectedColumn.getJavaProperty() + "\",dataType=\""+introspectedColumn.getFullyQualifiedJavaType().getShortName() + "\")");
            }
        }

        return true;
    }
}