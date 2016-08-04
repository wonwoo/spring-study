package me.wonwoo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

//package me.wonwoo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
//import org.springframework.util.PathMatcher;
//import org.springframework.validation.Validator;
//import org.springframework.web.servlet.config.annotation.*;
//import org.springframework.web.util.UrlPathHelper;
//
//import java.text.SimpleDateFormat;
//import java.util.List;
//
///**
// * Created by wonwoo on 2016. 5. 26..
// */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(new UserHandlerMethodArgumentResolver());

  }
}
//
//  @Override
//  public void addFormatters(FormatterRegistry registry) {
//  }
//
//  @Override
//  public Validator getValidator() {
//    return null;
//  }
//
//  @Override
//  public void addInterceptors(InterceptorRegistry registry) {
////    registry.addInterceptor(new LocaleInterceptor());
////    registry.addInterceptor(new ThemeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
////    registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");
//  }
//
//  @Override
//  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//    configurer.mediaType("json", MediaType.APPLICATION_JSON);
//  }
//
//  @Override
//  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/").setViewName("home");
//  }
//
//  @Override
//  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/");
//  }
//
//  @Override
//  public void configurePathMatch(PathMatchConfigurer configurer) {
//    configurer
//      .setUseSuffixPatternMatch(true)
//      .setUseTrailingSlashMatch(false)
//      .setUseRegisteredSuffixPatternMatch(true)
//      .setPathMatcher(antPathMatcher())
//      .setUrlPathHelper(urlPathHelper());
//  }
//
//  @Bean
//  public UrlPathHelper urlPathHelper() {
//
//    return null;
//  }
//
//  @Bean
//  public PathMatcher antPathMatcher() {
//    return null;
//  }
//
//  @Override
//  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
//      .indentOutput(true)
//      .dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
////      .modulesToInstall(new ParameterNamesModule());
//    converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
//    converters.add(new MappingJackson2XmlHttpMessageConverter(builder.xml().build()));
//  }
//
//  @Override
//  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//    configurer.enable();
//  }
//
//
////@Override
////public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
////  configurer.enable("myCustomDefaultServlet");
////}
//
//
//}
