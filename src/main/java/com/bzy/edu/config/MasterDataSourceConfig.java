package com.bzy.edu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.zaxxer.hikari.HikariDataSource;
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
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * ClassName:MasterDataSourceConfig
 * date：2022/7/4 10:39
 *
 * @author：YM start
 * @since:JDK 1.8
 * Description:
 */
@Configuration
@MapperScan(basePackages = "com.bzy.edu.master",sqlSessionTemplateRef = "sqlSessionTemplate")
public class MasterDataSourceConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapper_location;

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.test1")
    public DataSource firstDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl();
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 开启数据源的小驼峰映射
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/master/*.xml"));
        return bean.getObject();
    }
    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("firstDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }




//    private static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";
//
//    @Value("${spring.datasource.druid.test1.username}")
//    private String username;
//
//    @Value("&{spring.datasource.druid.test1.jdbc-url}")
//    private String url;
//
//
//    @Value("${spring.datasource.druid.test1.password}")
//    private String password;
//
//    @Value("${spring.datasource.druid.test1.driver-class-name}")
//    private String driverClassName;
//
//
//    @Bean("masterDataSource")
//    @Primary
//    public DataSource getMasterDataSource(){
//        //创建一个数据源对象，springboot默认为Hikari数据源，我们也用该数据源
//        //HikariDataSource dataSource = new HikariDataSource();
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        return dataSource;
//    }
//
//    @Bean("masterTransactionManager")
//    @Primary
//    public TransactionManager getMasterTransactionManager(){
//        return new DataSourceTransactionManager
//                ( getMasterDataSource());
//    }
//
//
//    @Bean("masterSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(masterDataSource);
//        sqlSessionFactory.setMapperLocations(
//                new PathMatchingResourcePatternResolver()
//                        .getResources(MAPPER_LOCATION)
//
//        );
//        return sqlSessionFactory.getObject();
//
//
//    }



}
