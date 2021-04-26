package com.atroot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.22 15:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

}
