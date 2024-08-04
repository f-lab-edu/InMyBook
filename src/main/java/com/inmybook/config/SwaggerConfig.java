package com.inmybook.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;

@OpenAPIDefinition(
	info = @Info(title = "InMyBook Post API 명세서",
		description = "InMyBook Post API 명세서"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {
	@Bean
	public GroupedOpenApi chatOpenApi() {
		String[] paths = {"/posts/**"};

		return GroupedOpenApi.builder()
			.group("InMyBook API")
			.pathsToMatch(paths)
			.build();
	}
}
