package com.bzy.edu.master;

import com.bzy.edu.bean.masterbean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:MasterMapper
 * date：2022/7/4 10:36
 *
 * @author：YM start
 * @since:JDK 1.8
 * Description:
 */

@Mapper
public interface MasterDao {

     List<masterbean> selectData();
}
