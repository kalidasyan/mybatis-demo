package com.amituofo.mybatis.demo.config.dao;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.amituofo.mybatis.demo.dao")
public class DataSourceConfiguration {
  @Value("${jdbc.driver}")
  private String jdbcDriver;
  @Value("${jdbc.url}")
  private String jdbcUrl;
  @Value("${jdbc.username}")
  private String jdbcUsername;
  @Value("${jdbc.password}")
  private String jdbcPassword;

  @Bean(name = "dataSource")
  public HikariDataSource createDataSource() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setDriverClassName(jdbcDriver);
    dataSource.setJdbcUrl(jdbcUrl);
    dataSource.setUsername(jdbcUsername);
    dataSource.setPassword(jdbcPassword);
//    关闭连接后不自动commit
    dataSource.setAutoCommit(false);
    return dataSource;
  }
}
