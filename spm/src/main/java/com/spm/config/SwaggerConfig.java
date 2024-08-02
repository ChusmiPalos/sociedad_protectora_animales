package com.spm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	Docket createApiDoc() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.spm.api"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Documentacion de la Sociedad Protectora de Animales (SPM)")
				.description("Información sobre la API REST para consumo de clientes de SPM")
				.termsOfServiceUrl("url del constructor a razon en: https://www.linkedin.com/in/chusmipalos/")
				.contact(new Contact("Jesus M. Palos", "linkedin/in/chusmipalos", "chusmi.palos@gmail.com"))
				.version("1.0")
				.build();
	}
}
