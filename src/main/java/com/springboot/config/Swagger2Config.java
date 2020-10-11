package com.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// more information : ﻿https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations

@Configuration
@EnableSwagger2
public class Swagger2Config {

    private String version;
    private String title;

    // try-it 버튼 deleted
    @Bean
    public UiConfiguration tryItOutConfig() {
        final String[] methodsWithTryItOutButton = { "" };
        return UiConfigurationBuilder.builder().supportedSubmitMethods(methodsWithTryItOutButton).build();
    }

    @Bean
    public Docket api() {

        version = "V1";
        title = "get API " + version;

        // global status 설정할경우
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder()
                .code(200)
                .message("OK ~~")
                .build());
        responseMessages.add(new ResponseMessageBuilder()
                .code(404)
                .message("Not Found ~~")
                .build());
        responseMessages.add(new ResponseMessageBuilder()
                .code(500)
                .message("Internal Server Error ~~")
                .build());

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false) // 200 외, 각 status값 view 삭제 (개별등록 가능)
                .select()
                // TODO :
                .apis(RequestHandlerSelectors.basePackage("com.springboot")) // 현재 com.springboot 패키지로 할당된 모든 URL 리스트를 추출
//                .apis(RequestHandlerSelectors.any())  // 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
                // TODO :
                //  .paths(PathSelectors.any())
                //  .paths(PathSelectors.ant("api/v1/**"))     // /api/v1 경로인 URL들만 필터링
                .paths(PathSelectors.ant("/**")) // /api 경로인 URL들만 필터링
                .build()
                .groupName(title)
                .apiInfo(apiInfo(title, version));
                // .globalResponseMessage(RequestMethod.GET, responseMessages); // global status 설정할경우

    }

    @Bean
    public Docket apiV2() {

        version = "V2";
        title = "post API " + version;

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false) // 200 외, 각 status값 view 삭제 (개별등록 가능)
                .select()
                // TODO :
                .apis(RequestHandlerSelectors.basePackage("com.springboot")) // 현재 com.springboot 패키지로 할당된 모든 URL 리스트를 추출
                //  .apis(RequestHandlerSelectors.any())  // 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
                // TODO :
                //  .paths(PathSelectors.any())
                //  .paths(PathSelectors.ant("api/v1/**"))     // /api/v1 경로인 URL들만 필터링
                .paths(PathSelectors.ant("/api/**")) // /api 경로인 URL들만 필터링
                .build()
                .groupName(title)
                .apiInfo(apiInfo(title, version));

    }

//    private ApiInfo apiInfo(String title, String version) {
//        return new ApiInfo(title,
//                "Some custom description of API.",
//                version, "Terms of service",
//                new Contact("jogilsang", "https://blog.naver.com/jogilsang", "jogilsang@naver.com"),
//                "License of API",
//                "API license URL",
//                Collections.emptyList());
//    }

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
                title,
                "Swagger로 생성한 API Docs",
                version,
                "www.example.com",
                new Contact("Contact Me", "www.example.com", "foo@example.com"),
                "Licenses",
                "www.example.com",
                new ArrayList<>());
    }


}
