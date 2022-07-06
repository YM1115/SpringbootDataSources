package com.bzy.edu.second;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:SecondDao
 * date：2022/7/5 14:40
 *
 * @author：YM start
 * @since:JDK 1.8
 * Description:
 */
@Mapper
public interface SecondDao {

    List selectData2();
}
