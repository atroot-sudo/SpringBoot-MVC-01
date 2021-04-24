package com.theoldzheng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Description:
 *
 * @author atroot@126.com  @ZYD
 * @create 2021.4.24 14:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pet {
    private String name;
    private Integer age;
}
