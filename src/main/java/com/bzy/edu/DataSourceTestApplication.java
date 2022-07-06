package com.bzy.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

/**
 * ClassName:DataSourceTestApplication
 * date：2022/7/4 10:41
 *
 * @author：YM start
 * @since:JDK 1.8
 * Description:
 */
@SpringBootApplication(exclude={
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
})
public class DataSourceTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataSourceTestApplication.class,args);
    }
}
