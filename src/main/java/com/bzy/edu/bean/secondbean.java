package com.bzy.edu.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.awt.print.PrinterAbortException;

/**
 * ClassName:secondbean
 * date：2022/7/5 14:46
 *
 * @author：YM start
 * @since:JDK 1.8
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class secondbean {

    private String name;
    private double salary;
    private int state;
    private String date;
    private int counts;
}
