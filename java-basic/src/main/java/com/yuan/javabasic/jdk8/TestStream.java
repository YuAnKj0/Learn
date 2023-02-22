package com.yuan.javabasic.jdk8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ykj
 * @date 2022/10/26/13:01
 * @apiNote
 */
public class TestStream {
    public static void main(String[] args) {
    
        List<Person> aList = new ArrayList<>(Arrays.asList(
                new Person("1", "张三"),
                new Person("2", "李四"),
                new Person("3", "王五")
        ));
    
        List<Person> bList = new ArrayList<>(Arrays.asList(
                new Person("2", "李四"),
                new Person("3", "王五"),
                new Person("4", "赵六")
        ));
        // aList 与 bList 的交集 (在两个集合中都存在的元素)
        List<Person> intersections = aList
                .stream() //获取第一个集合的Stream1
                .filter(  //取出Stream1中符合条件的元素组成新的Stream2，lambda表达式1返回值为true时为符合条件
                        a ->  //lambda表达式1，a为lambda表达式1的参数，是Stream1中的每个元素
                                bList.stream() //获取第二个集合的Stream3
                                        .map(Person::getId) //将第二个集合每个元素的id属性取出来，映射成新的一个Stream4
                                        .anyMatch( //返回值（boolean）：Stream4中是否至少有一个元素使lambda表达式2返回值为true
                                                id -> //lambda表达式2，id为lambda表达式2的参数，是Stream4中的每个元素
                                                        Objects.equals(a.getId(), id) //判断id的值是否相等
                                        )
                )
                .collect(Collectors.toList()); //将Stream2转换为List
        System.out.println("----------aList 与 bList 的交集为：");
        System.out.println(intersections);
        //求两个对象List的差集
        List<Person> differences=bList.stream()
                .filter(b->aList.stream()
                        .map(Person::getId)
                        .noneMatch(id->Objects.equals(b.getId(),id)))
                .collect(Collectors.toList());
        System.out.println("----------bList 与 aList 的差集为：");
        System.out.println(differences);
        
    }
    
    
    
}
