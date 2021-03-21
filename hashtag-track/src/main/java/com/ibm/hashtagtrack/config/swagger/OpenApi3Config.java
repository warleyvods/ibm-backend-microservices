package com.ibm.hashtagtrack.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * Custom config for the Open API 3.0
 * @author Warley Vinicius
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Twitter Hashtag Track API Server", version = "v1",
        description = "This API aims to facilitate the geolocation of Hashtags that are being " +
                "published with a specific search key. \n\nMade with \u2764 by Warley Vinicius",
        contact = @Contact(name = "Warley Vinicius", email = "warleyvods@gmail.com", url = "https://github.com/warleyvods")))
public class OpenApi3Config {

}
