package gq.zhuzhibin.open.dockerspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Resource
    private MyConfig myConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("media/**")
                .addResourceLocations("file:" + myConfig.getMediaLocation());
    }
}
