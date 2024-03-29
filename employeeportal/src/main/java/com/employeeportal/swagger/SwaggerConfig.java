package com.employeeportal.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.employeeportal.domain.EmployeeEntity;
import com.google.common.base.Predicate;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)          
			      .select()                                       
			      .apis(RequestHandlerSelectors.basePackage("com.employeeportal.controller"))
			      .paths(PathSelectors.ant("/api/*"))                     
			      .build();
	}

	private Predicate<String> postPaths() {
		return or(regex("api/employee.*"), regex("api/employee.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("JavaInUse API")
				.description("JavaInUse API reference for developers")
				.termsOfServiceUrl("http://localhost:2019")
				.contact("aksathua21@gmail.com").license("JavaInUse License")
				.licenseUrl("aksathua21@gmail.com").version("1.0").build();
	}

}
