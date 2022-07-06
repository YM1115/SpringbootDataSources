package com.bzy.edu.master;

import com.bzy.edu.bean.masterbean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName:MasterDaoTest
 * date：2022/7/5 10:41
 *
 * @author：YM start
 * @since:JDK 1.8
 * Description:
 */

@SpringBootTest
public class MasterDaoTest {

    @Autowired
    private MasterDao masterDao;

    @Test
    public void MasterDaoTest(){
        List<masterbean> masterbeans = masterDao.selectData();
        System.out.println(masterbeans);
    }

}