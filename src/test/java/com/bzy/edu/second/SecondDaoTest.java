package com.bzy.edu.second;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;



/**
 * ClassName:SecondDaoTest
 * date：2022/7/5 14:51
 *
 * @author：YM start
 * @since:JDK 1.8
 * Description:
 */
@SpringBootTest
public class SecondDaoTest {

    @Autowired
    private SecondDao secondDao;

    @Test
    public void SecondDaoTest(){
        List list = secondDao.selectData2();
        System.out.println(list);
    }
}