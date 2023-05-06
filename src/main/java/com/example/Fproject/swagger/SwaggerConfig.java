package com.example.Fproject.swagger;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("IOT microservices API")
                                .description("IOT microservices Restful API")
                                .version("v1.0.0")
                );
    }
    @Bean
    public GroupedOpenApi CIMSSApi() {
        return GroupedOpenApi.builder()
                .group("CIM-api")
                .pathsToMatch("/**")
                .addOperationCustomizer((operation, handlerMethod) -> {
                    if (handlerMethod.getBeanType().getSimpleName().equals("LineMessageHandlerSupport")) {
                        return null;
                    }
                    return operation;
                })
                .build();
    }
}
