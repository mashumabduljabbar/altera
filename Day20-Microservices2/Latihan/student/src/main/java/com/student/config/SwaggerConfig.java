package com.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiEndpointInfo());

	}

	private ApiInfo apiEndpointInfo() {
		return new ApiInfoBuilder().title("REST API Documentation for Fraud Detection System Service Project")
				.description("This is api documentation for fraud detection system service project")
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("3.0.0")
				.contact(new Contact("Fajar Satriatna", "medium.com/@fajarstrtn", "fajarsatriatna24@gmail.com"))
				.build();
	}
}