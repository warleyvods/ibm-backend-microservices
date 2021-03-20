package com.ibm.hashtagtrack.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * Custom config for the Open API 3.0
 * @author Warley Vinicius
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Twitter Hashtag Track API Server", version = "v1"))
public class OpenApi3Config {

}
