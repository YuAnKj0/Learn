package com.yuan.javabasic.controller;

import com.yuan.javabasic.jdk8.Person;
import com.yuan.javabasic.mapper.PersonMapper;
import com.yuan.javabasic.vo.PersonVo1;
import com.yuan.javabasic.vo.PersonVo2;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ykj
 * @date 2022/11/20/10:42
 * @apiNote
 */
@RestController
public class TestContrpller {
    
    @GetMapping("convert")
    public Object convertEntity(){
        Person person= Person.builder()
                .id("1")
                .name("张三妹").build();
        List<Object> list=new ArrayList<>();
        list.add(person);
        // 使用mapstruct
        PersonVo1 personVo1 = PersonMapper.INSTANCE.toConvertVo1(person);
        list.add("personVo1:"+personVo1);
        list.add("userVO1转换回实体类user:"+PersonMapper.INSTANCE.fromConvertEntity1(personVo1));
        //输出转换结果
        list.add("userVO2:"+"  |  "+PersonMapper.INSTANCE.toConvertVO2(person));
        
        //使用BeanUitls
        PersonVo2 personVo22=new PersonVo2();
        BeanUtils.copyProperties(person,personVo22);
        list.add("personVo22:" + " | " + personVo22);
    return list;
    
    }
    
    
}
