package com.amituofo.mybatis.demo.config.dao;

import java.io.IOException;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


@Configuration
public class SessionFactoryConfiguration {
  @Value("${mybatis.config.file}")
  private String mybatisConfigFilePath;

  @Value("${mybatis.mapper.path}")
  private String mapperPath;

  @Value("${entity.package}")
  private String entityPackage;

  @Autowired
  private DataSource dataSource;

  @Bean("sqlSessionFactory")
  public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
    sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
    return sqlSessionFactoryBean;
  }
}
