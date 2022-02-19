package com.taskTracker.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Task tracker", version = "v1"))
@SecurityScheme(type = SecuritySchemeType.HTTP, name = "jwt", paramName = "Authorization", in = SecuritySchemeIn.HEADER, scheme = "bearer" )
public class SwaggerConfig {
}
