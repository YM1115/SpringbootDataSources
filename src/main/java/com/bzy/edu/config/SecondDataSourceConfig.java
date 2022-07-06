package com.bzy.edu.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * ClassName:SecondDataSourceConfig
 * date：2022/7/5 14:34
 *
 * @author：YM start
 * @since:JDK 1.8
 * Description:
 */
@Configuration
@MapperScan(basePackages = "com.bzy.edu.second",sqlSessionTemplateRef = "sqlSessionTemplate2")
public class SecondDataSourceConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapper_location;


    @Bean
    @ConfigurationProperties("spring.datasource.druid.test2")
    public DataSource SecondDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl();
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory2(@Qualifier("SecondDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 开启数据源的小驼峰映射
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/second/*.xml"));
        return bean.getObject();
    }
    @Bean
    public DataSourceTransactionManager transactionManager2(@Qualifier("SecondDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate2(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
