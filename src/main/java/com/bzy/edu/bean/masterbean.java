package com.bzy.edu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ClassName:masterbean
 * date：2022/7/4 16:42
 *
 * @author：YM start
 * @since:JDK 1.8
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class masterbean {
    private int userId;
    private String userName;
    private String userPassword;
    private String salt;
}
