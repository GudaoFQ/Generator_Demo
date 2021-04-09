package com.gudao.generator.generatorconfig.comment;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;
import java.util.Properties;

/**
 * @Auther: Gudao
 * @Date: 2021/3/26 14:57
 * @Description: Lombok集成入实体
 */
public class LombokPlugin extends PluginAdapter {
    // [方法二可以将此处注释]属性，即配置在 commentGenerator 标签之内的 Property 标签
    private final Properties properties = super.getProperties();

    public boolean validate(List<String> list) {
        return true;
    }

    /**
     * 模型上添加注解
     *
     * @param topLevelClass     顶级类
     * @param introspectedTable 进行自检表
     * @return boolean
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // 导入需要的jar包方法一（需要再配置文件中指定所需的jar包地址）
        String lombokDataAnnotationPackage;
        String lombokToStringAnnotationPackage;
        if(null != (lombokDataAnnotationPackage = properties.getProperty("lombokDataAnnotationPackage"))){
            topLevelClass.addImportedType(lombokDataAnnotationPackage);
            topLevelClass.addAnnotation("@Data");
        }
        if(null != (lombokToStringAnnotationPackage = properties.getProperty("lombokToStringAnnotationPackage"))){
            topLevelClass.addImportedType(lombokToStringAnnotationPackage);
            topLevelClass.addAnnotation("@ToString");
        }

        /*// 导入需要的jar包方法二（不需要再配置文件中指定）
        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addImportedType("lombok.ToString");

        topLevelClass.addAnnotation("@Data");
        topLevelClass.addAnnotation("@ToString");*/

        return true;
    }

    /**
     * 模型setter方法生成
     *
     * @param method             方法
     * @param topLevelClass      顶级类
     * @param introspectedColumn 进行自检列
     * @param introspectedTable  进行自检表
     * @param modelClassType     模型类类型
     * @return boolean false不生成，true生成
     */
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /**
     * 模型生成getter方法
     *
     * @param method             方法
     * @param topLevelClass      顶级类
     * @param introspectedColumn 进行自检列
     * @param introspectedTable  进行自检表
     * @param modelClassType     模型类类型
     * @return boolean false不生成，true生成
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }
}