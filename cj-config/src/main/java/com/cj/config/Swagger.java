package com.cj.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableSwaggerBootstrapUI
@Configuration
public class Swagger {

    /**
     * 构建 swagger
     *
     * @return
     */
    private Docket getDefault() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("CJ-Core")
                .apiInfo(getApiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build().groupName("basic");
    }

    /**
     * 构建 api文档的详细信息函数
     *
     * @return
     */
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("利用swagger2构建的API文档")
                .description("用restful风格写接口")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

}