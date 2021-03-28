package br.com.andre.visionnaire.seguradoraveiculos.swagger;

import br.com.andre.visionnaire.seguradoraveiculos.dto.ApoliceDto;
import br.com.andre.visionnaire.seguradoraveiculos.dto.ClienteDto;
import br.com.andre.visionnaire.seguradoraveiculos.dto.ConsultarApoliceDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.andre.visionnaire.seguradoraveiculos.controller"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(ApoliceDto.class, ClienteDto.class, ConsultarApoliceDto.class);
    }
}
