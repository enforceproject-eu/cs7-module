package org.n52.project.enforce.cs7.api;

import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * WebConfig class.
 * </p>
 *
 * @author Benjamin Pross (b.pross@52north.org)
 * @since 1.0.0
 */
@Configuration
public class Cs7WebConfig implements WebMvcConfigurer {
    
    /** {@inheritDoc} */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
        messageConverters.add(new Cs7MessageConverter());
    }
    
    @Bean
    GroupedOpenApi cs7Apis() {
      return GroupedOpenApi.builder().group("cs7").pathsToMatch("/cs7_measurement_data/**").build();
    }
    
}
