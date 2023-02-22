package com.yuan.javabasic.jdk8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ykj
 * @date 2022/10/26/13:03
 * @apiNote
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
   private  String id;
   private String name;
   

}
