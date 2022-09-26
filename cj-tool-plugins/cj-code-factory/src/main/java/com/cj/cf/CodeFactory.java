package com.cj.cf;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 生成controller，dao，entity，service，imp，mapper.xml
 */
public class CodeFactory {

    private  String[] TABLES = {};

    /**
     * 表名
     * @param tables
     */
    public CodeFactory(String[] tables)
    {
        this.TABLES=tables;
    }

    /**
     * 作者
     */
    private  String author = "lang.chaojin";

    /**
     * 开发人员
     * @param name
     */
    public void setAuthor(String name){
        this.author=name;
    }

    /**
     * 文件路径
     */
    private  String FilePath = "";

    /**
     * Ser文件生成的路径/Users/cjlang/Documents/IDEA/cj-master/cj-code-factory
     * @param path
     */
    public void setFilePath(String path){
        this.FilePath=path;
    }

    // 数据库
    private  String username = "root";
    private  String password = "root";
    private  String url = "jdbc:p6spy:mysql://222.85.178.202:3366/gc_cloud_starter?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai";
    private DbType DB_TYPE = DbType.MYSQL;
    private  String driverClassName = "com.mysql.cj.jdbc.Driver";

    /**
     * 数据库信息
     * @param url 连接串jdbc:mysql://localhost:3306/pms?useUnicode=true&useSSL=false&characterEncoding=utf8
     * @param driverClassName 驱动名称com.mysql.cj.jdbc.Driver
     * @param username 用户名
     * @param password 密码
     */
    public void setDbInfo(String url,String driverClassName,String username,String password)
    {
        this.url=url;
        this.driverClassName=driverClassName;
        this.username=username;
        this.password=password;
    }

    /**
     * 包路径
     */
    private  String packagePath = "/com/cj/lcj";

    /**
     * 设置包的路径：例如：/com/cj/auto
     * @param path
     */
    public void setPackagePath(String path){
        this.packagePath=path;
    }
    // 各层包名
    private  String CONTROLLER_PATH = "/controller/";
    private  String ENTITY_PATH = "/entity/";
    private  String VO_PATH = "/vo/";
    private  String DTO_PATH = "/dto/";
    private  String MAPPER_PATH = "/mapper/";
    private  String BLL_SERVICE_PATH = "/bllservice/";
    private  String XML_PATH = "/resources/mapper_/";
    private  String SERVICE_PATH = "/service/";
    private  String SERVICE_IMPL_PATH = "/service/impl/";



    /** controller输出模板 */
    private  String CONTROLLER_TEMPLATE = "ftl/controller.java.ftl";
    private  String CONTROLLER_OUTPUT_PATH;
    /** entity输出模板 */
    private  String MAPPER_TEMPLATE = "ftl/mapper.java.ftl";
    private  String MAPPER_OUTPUT_PATH;
    /** entity输出模板 */
    private  String ENTITY_TEMPLATE = "ftl/entity.java.ftl";
    private  String ENTITY_OUTPUT_PATH;
    /** vo输出模板 */
    private  String VO_TEMPLATE = "ftl/vo.java.ftl";
    private  String VO_OUTPUT_PATH;
    /** dto输出模板 */
    private  String DTO_TEMPLATE = "ftl/dto.java.ftl";
    private  String DTO_OUTPUT_PATH;
    /** mapper.xml输出模板 */
    private  String XML_TEMPLATE = "ftl/mapper.xml.ftl";
    private  String XML_OUTPUT_PATH;
    /** dao.java输出模板 */
    private  String BLL_SERVICE_TEMPLATE = "ftl/bllservice.java.ftl";
    private  String BLL_SERVICE_OUTPUT_PATH;
    /** service输出模板 */
    private  String SERVICE_TEMPLATE = "ftl/service.java.ftl";
    private  String SERVICE_OUTPUT_PATH;
    /** serviceImpl输出模板 */
    private  String SERVICE_IMPL_TEMPLATE = "ftl/serviceImpl.java.ftl";
    private  String SERVICE_IMPL_OUTPUT_PATH;

    public  void Destory() {
        for (int i = 0; i < TABLES.length; i++) {
            String entityName=lineToHump(TABLES[i]);
            this.CONTROLLER_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + CONTROLLER_PATH  + entityName + "Controller_"+ StringPool.DOT_JAVA;
            this.MAPPER_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + MAPPER_PATH + entityName + "Mapper_"+ StringPool.DOT_JAVA;
            this.ENTITY_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + ENTITY_PATH + entityName + "Entity"+ StringPool.DOT_JAVA;
            this.VO_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + VO_PATH + entityName + "Vo"+ StringPool.DOT_JAVA;
            this.DTO_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + DTO_PATH + entityName + "DTO"+ StringPool.DOT_JAVA;
            this.XML_OUTPUT_PATH = FilePath + "/src/main"  + XML_PATH + entityName + "Mapper_"+ StringPool.DOT_XML;
            this.BLL_SERVICE_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + BLL_SERVICE_PATH  + entityName + "BllService_"+ StringPool.DOT_JAVA;
            this.SERVICE_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath + SERVICE_PATH  +"I" +entityName + "Service_"+ StringPool.DOT_JAVA;
            this.SERVICE_IMPL_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + SERVICE_IMPL_PATH  + entityName + "ServiceImpl_"+ StringPool.DOT_JAVA;

            DeleteFile(this.ENTITY_OUTPUT_PATH);
            DeleteFile(this.VO_OUTPUT_PATH);
            DeleteFile(this.DTO_OUTPUT_PATH);
            DeleteFile(this.MAPPER_OUTPUT_PATH);
            DeleteFile(this.XML_OUTPUT_PATH);
            DeleteFile(this.BLL_SERVICE_OUTPUT_PATH);
            DeleteFile(this.SERVICE_OUTPUT_PATH);
            DeleteFile(this.SERVICE_IMPL_OUTPUT_PATH);
            DeleteFile(this.CONTROLLER_OUTPUT_PATH);

        }
    }

    public void deleteFolder(String filePath) throws IOException {
        File file = new File(filePath);
        FileUtils.deleteDirectory(file);
    }
    private void DeleteFile(String path)
    {
        File file = new File(path);
        if(file.exists()) {
            file.delete();
            System.out.println(path+"删除成功");
            return;
        }
    }
    private static String lineToHump(String str) {
        Pattern linePattern = Pattern.compile("_(\\w)");
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        String res=sb.toString();
        res=res.substring(0,1).toUpperCase()+res.substring(1);
        return res;
    }

    public  void Create() {

        this.CONTROLLER_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + CONTROLLER_PATH;
        this.MAPPER_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + MAPPER_PATH;
        this.ENTITY_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + ENTITY_PATH;
        this.VO_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + VO_PATH;
        this.DTO_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + DTO_PATH;
        this.XML_OUTPUT_PATH = FilePath + "/src/main"  + XML_PATH;
        this.BLL_SERVICE_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + BLL_SERVICE_PATH;
        this.SERVICE_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath + SERVICE_PATH;
        this.SERVICE_IMPL_OUTPUT_PATH = FilePath + "/src/main/java" + packagePath  + SERVICE_IMPL_PATH;

        if(!isExists( FilePath + "/src/main/java" + packagePath ))
        {
            File file = new File( FilePath + "/src/main/java" + packagePath );
            file.mkdirs();
        }

        if(!isExists(XML_OUTPUT_PATH))
        {
            File file = new File(XML_OUTPUT_PATH);
            file.mkdirs();
        }
        // 全局配置
        GlobalConfig globalConfig = globalConfig();
        // 数据源配置
        DataSourceConfig dataSourceConfig = dataSourceConfig();
        // 策略配置
        StrategyConfig strategyConfig = strategyConfig();
        // 包配置
        PackageConfig packageConfig = packageConfig();
        // 模板配置
        TemplateConfig templateConfig = templateConfig();
        // 自定义配置
        InjectionConfig injectionConfig = injectionConfig();

        // 执行
        new AutoGenerator().setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                // 因为使用了自定义模板,所以需要把各项置空否则会多生成一次
                .setTemplate(templateConfig)
                // 使用的模板引擎，如果不是默认模板引擎则需要添加模板依赖到pom
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setCfg(injectionConfig)
                .execute();
    }

    /**
     * 全局配置
     */
    private GlobalConfig globalConfig() {
        return new GlobalConfig()
                // 打开文件
                .setOpen(false)
                // 文件覆盖
                .setFileOverride(true)
                // 开启activeRecord模式
                .setActiveRecord(false)
                .setIdType(IdType.ASSIGN_UUID)//主键策略
                // XML ResultMap: mapper.xml生成查询映射结果
                .setBaseResultMap(true)
                // XML ColumnList: mapper.xml生成查询结果列
                .setBaseColumnList(true)
                // swagger注解; 须添加swagger依赖
                .setSwagger2(true)
                // 作者
                .setAuthor(author);
                // 设置实体类名称
                //.setEntityName("DDD");
    }

    /**
     * 数据源配置
     */
    private DataSourceConfig dataSourceConfig() {
        return new DataSourceConfig()
                // 数据库类型
                .setDbType(DB_TYPE)
                // 连接驱动
                .setDriverName(driverClassName)
                // 地址
                .setUrl(url)
                // 用户名
                .setUsername(username)
                // 密码
                .setPassword(password)
                // 自定义数据库表字段类型转换【可选】
                .setTypeConvert(new MySqlTypeConvert() {
                    @Override
                    public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        System.out.println("转换类型：" + fieldType);
                        //将数据库中datetime转换成date
                        if (fieldType.toLowerCase().contains("datetime")) {
                            return DbColumnType.DATE;
                        }
                        return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
                    }
                });
    }

    /**
     * 策略配置
     */
    private  StrategyConfig strategyConfig() {
        // 自定义需要填充的字段 数据库中的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("org_id", FieldFill.INSERT));
        tableFillList.add(new TableFill("create_by", FieldFill.INSERT));
        tableFillList.add(new TableFill("create_date", FieldFill.INSERT));
        tableFillList.add(new TableFill("update_by", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("update_date", FieldFill.INSERT_UPDATE));

        return new StrategyConfig()
                // 表名生成策略：下划线连转驼峰
                .setNaming(NamingStrategy.underline_to_camel)
                // 表字段生成策略：下划线连转驼峰
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // 需要生成的表
                .setInclude(TABLES)
                .setSuperControllerClass("SuperController")
                // 生成controller
                .setRestControllerStyle(true)
                // controller映射地址：驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                // 是否启用builder 模式
                .setEntityBuilderModel(true)
                // 是否为lombok模型; 需要lombok依赖
                .setEntityLombokModel(true)
                // 生成实体类字段注解
                .setEntityTableFieldAnnotationEnable(true)
                .setTableFillList(tableFillList);
                //.setLogicDeleteFieldName("delflag");
    }

    /**
     * 包配置
     * 设置包路径用于导包时使用，路径示例：com.path
     */
    private  PackageConfig packageConfig() {
        String controller = CONTROLLER_PATH;
        String mapper =  MAPPER_PATH;
        String entity =  ENTITY_PATH;
        String xml =  XML_PATH;
        String service = SERVICE_PATH;
        String serviceImpl = SERVICE_IMPL_PATH;

        return new PackageConfig()
                // 父包名
                .setParent(packagePath.replace('/', '.').substring(1))
                .setEntity(entity.replace('/', '.').substring(1, entity.length()-1))
                .setMapper(mapper.replace('/', '.').substring(1, mapper.length()-1))
                .setXml(xml.replace('/', '.').substring(1, xml.length()-1))
                .setService(service.replace('/', '.').substring(1, service.length()-1))
                .setServiceImpl(serviceImpl.replace('/', '.').substring(1, serviceImpl.length()-1))
                .setController(controller.replace('/', '.').substring(1, controller.length()-1));
    }

    /**
     * 模板配置
     */
    private TemplateConfig templateConfig() {
        return new TemplateConfig()
                // 置空后方便使用自定义输出位置
                .setEntity(null)
                .setXml(null)
                .setMapper(null)
                .setService(null)
                .setServiceImpl(null)
                .setController(null);
    }

    /**
     * 自定义配置
     */
    private  InjectionConfig injectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                // 注入配置
            }
        }
                // 判断是否创建文件
                .setFileCreate(new IFileCreate() {
                    @Override
                    public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                        // 检查文件目录，不存在自动递归创建
                        checkDir(filePath);
                        // 指定需要覆盖的文件
                        // 文件结尾名字参照 全局配置 中对各层文件的命名,未修改为默认值
                        if (isExists(filePath)) {
                            return false;
                        }
                        return true;
                    }
                })
                // 自定义输出文件
                .setFileOutConfigList(fileOutConfigList());
    }

    /**
     * 自定义输出文件配置
     */
    private  List<FileOutConfig> fileOutConfigList() {
        List<FileOutConfig> list = new ArrayList<>();

        // controller文件输出
        list.add(new FileOutConfig(CONTROLLER_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                System.out.println(">>CONTROLLER>>>>>>>>>>>>>>>>>>>>"+CONTROLLER_OUTPUT_PATH + tableInfo.getControllerName() + StringPool.DOT_JAVA);
                return CONTROLLER_OUTPUT_PATH + tableInfo.getControllerName()  + "_" + StringPool.DOT_JAVA;
            }
        });
        // mapper类文件输出
        list.add(new FileOutConfig(MAPPER_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                System.out.println(">>MAPPER>>>>>>>>>>>>>>>>>>>>"+ MAPPER_OUTPUT_PATH + tableInfo.getMapperName() + StringPool.DOT_JAVA);
                return MAPPER_OUTPUT_PATH + tableInfo.getMapperName()  + "_" + StringPool.DOT_JAVA;
            }
        });
        // 实体类文件输出
        list.add(new FileOutConfig(ENTITY_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                System.out.println(">>ENTITY>>>>>>>>>>>>>>>>>>>>"+ ENTITY_OUTPUT_PATH + tableInfo.getEntityName() + "Entity" + StringPool.DOT_JAVA);
                return ENTITY_OUTPUT_PATH + tableInfo.getEntityName() +"Entity"+ StringPool.DOT_JAVA;
            }
        });
        // VO类文件输出
        list.add(new FileOutConfig(VO_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                System.out.println(">>VO>>>>>>>>>>>>>>>>>>>>"+ ENTITY_OUTPUT_PATH + tableInfo.getEntityName() + "Vo" + StringPool.DOT_JAVA);
                return VO_OUTPUT_PATH + tableInfo.getEntityName() +"Vo"+ StringPool.DOT_JAVA;
            }
        });
        // DTO类文件输出
        list.add(new FileOutConfig(DTO_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                System.out.println(">>DTO>>>>>>>>>>>>>>>>>>>>"+ ENTITY_OUTPUT_PATH + tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA);
                return DTO_OUTPUT_PATH + tableInfo.getEntityName() +"DTO"+ StringPool.DOT_JAVA;
            }
        });
        // mapper xml文件输出
        list.add(new FileOutConfig(XML_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                System.out.println(">>XML>>>>>>>>>>>>>>>>>>>>"+ XML_OUTPUT_PATH + tableInfo.getMapperName() + StringPool.DOT_XML);
                return XML_OUTPUT_PATH + tableInfo.getMapperName()  + "_" + StringPool.DOT_XML;
            }
        });
        // bllService文件输出
        list.add(new FileOutConfig(BLL_SERVICE_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                System.out.println(">>DAO>>>>>>>>>>>>>>>>>>>>"+BLL_SERVICE_OUTPUT_PATH + tableInfo.getEntityName() +"BllService" + StringPool.DOT_JAVA);
                return BLL_SERVICE_OUTPUT_PATH + tableInfo.getEntityName() +"BllService"  + "_" + StringPool.DOT_JAVA;
            }
        });
        // service文件输出
        list.add(new FileOutConfig(SERVICE_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                System.out.println(">>SERVICE>>>>>>>>>>>>>>>>>>>>"+SERVICE_OUTPUT_PATH + tableInfo.getServiceName() + StringPool.DOT_JAVA);
                return SERVICE_OUTPUT_PATH + tableInfo.getServiceName() + "_" + StringPool.DOT_JAVA;
            }
        });
        // service impl文件输出
        list.add(new FileOutConfig(SERVICE_IMPL_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                System.out.println(">>SERVICE_IMPL>>>>>>>>>>>>>>>>>>>>"+ SERVICE_IMPL_OUTPUT_PATH + tableInfo.getServiceImplName() + StringPool.DOT_JAVA);
                return SERVICE_IMPL_OUTPUT_PATH + tableInfo.getServiceImplName() + "_" + StringPool.DOT_JAVA;
            }
        });

        return list;
    }

    /**
     * 判断文件是否存在
     * @param path 路径
     * @return
     */
    private  boolean isExists(String path) {
        File file = new File(path);
        return file.exists();
    }
}
