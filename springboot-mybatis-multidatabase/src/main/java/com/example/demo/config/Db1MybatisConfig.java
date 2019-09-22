package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by jinglun on 2019-09-22
 */
@Configuration
@MapperScan(basePackages = "com.example.demo.mapper.db1", sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class Db1MybatisConfig {

    @Bean(name = "db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db1") // 读取yml数据源配置，自动注入到DataSource
    @Primary // 注意若配置了多数据源，需要使用@Parimary显式指定一个主数据源，其余数据源不需再配置
    public DataSource db1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db1Config")
    @ConfigurationProperties(prefix = "mybatis.configuration.db1") // 读取yml Mybatis配置，自动注入到Configuration
    @Primary
    public org.apache.ibatis.session.Configuration db1MybatisConfig() {
        return new org.apache.ibatis.session.Configuration();
    }

    @Bean(name = "db1SqlSessionFactory")
    @Primary
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource,
                                                  @Qualifier("db1Config") org.apache.ibatis.session.Configuration config)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfiguration(config); // 多数据源需要在各自的SessionFactory中设置配置Mybatis属性
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/db1/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "db1TransactionManager")
    @Primary
    public DataSourceTransactionManager db1TransactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
