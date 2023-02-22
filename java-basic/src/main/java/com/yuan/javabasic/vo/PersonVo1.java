package com.yuan.javabasic.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ykj
 * @date 2022/11/20/10:35
 * @apiNote
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonVo1 {
    private  String id;
    private String name;
}
