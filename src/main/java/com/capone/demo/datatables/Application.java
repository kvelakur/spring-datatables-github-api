package com.capone.demo.datatables;

import com.capone.demo.datatables.datatables.DataTablesRequestParamsArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(Application.class, args);
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(dataTablesRequestParamsArgumentResolver());
  }

  @Bean
  public DataTablesRequestParamsArgumentResolver dataTablesRequestParamsArgumentResolver() {
    return new DataTablesRequestParamsArgumentResolver();
  }

}
