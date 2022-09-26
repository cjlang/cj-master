package com.cj.document;
import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import lombok.Data;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
class documentGeneration {

    String outPutDir="/Users/cjlang/Desktop";
    EngineFileType docType=EngineFileType.WORD;
    String driverClassName="com.mysql.cj.jdbc.Driver";
    String dbUrl="jdbc:mysql://localhost:3306/pms?useUnicode=true&useSSL=false&characterEncoding=utf8";
    String username="root";
    String password="root";
    String version="V1.0.0";
    String description="数据库设计文档";
    //根据名称指定表生成
    List<String> designatedTableName=new ArrayList<>();
    List<String> designatedTablePrefix=new ArrayList<>();
    List<String> designatedTableSuffix=new ArrayList<>();
    //忽略的
    List<String> ignoreTableName = Arrays.asList("aa", "test_group");
    // 忽略表前缀，如忽略a开头的数据库表
    List<String> ignorePrefix = Arrays.asList("a", "t");
    // 忽略表后缀
    List<String> ignoreSuffix = Arrays.asList("_test", "czb_");


    public void createDocument() {
        new DocumentationExecute(getConfiguration()).execute();
    }

    public Configuration getConfiguration(){
        return Configuration.builder()
                .version(this.version) // 版本
                .description(this.description) // 描述
                .dataSource(getDataSource()) // 数据源
                .engineConfig(getEngineConfig()) // 模板引擎配置
                .produceConfig(getProcessConfig()) // 加载配置：想要生成的表、想要忽略的表
                .build();
    }

    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(this.driverClassName);
        dataSourceBuilder.url(this.dbUrl);
        dataSourceBuilder.username(this.username);
        dataSourceBuilder.password(this.password);
        return dataSourceBuilder.build();
    }

    public EngineConfig getEngineConfig(){
        return EngineConfig.builder()
                // 生成文件路径。与官方的例子不同，我是win10系统，就先放E盘根目录吧。
                .fileOutputDir(this.outPutDir)
                // 打开目录
                .openOutputDir(false)
                // 文件类型
                .fileType(this.docType)
                // 生成模板实现
                .produceType(EngineTemplateType.freemarker).build();
    }

    public  ProcessConfig getProcessConfig() {
        return ProcessConfig.builder()
                //根据名称指定表生成
                .designatedTableName(designatedTableName)
                //根据表前缀生成
                .designatedTablePrefix(designatedTablePrefix)
                //根据表后缀生成
                .designatedTableSuffix(designatedTableSuffix)
                //忽略表名
                .ignoreTableName(this.ignoreTableName)
                //忽略表前缀
                .ignoreTablePrefix(this.ignorePrefix)
                //忽略表后缀
                .ignoreTableSuffix(this.ignoreSuffix).build();
    }
}


