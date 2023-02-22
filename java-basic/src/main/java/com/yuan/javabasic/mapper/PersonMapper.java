package com.yuan.javabasic.mapper;

import com.yuan.javabasic.jdk8.Person;
import com.yuan.javabasic.vo.PersonVo1;
import com.yuan.javabasic.vo.PersonVo2;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Ykj
 * @date 2022/11/20/10:32
 * @apiNote
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {
    
    PersonMapper INSTANCE= Mappers.getMapper(PersonMapper.class);
    
    PersonVo1 toConvertVo1(Person person);
    Person fromConvertEntity1(PersonVo1 personVo1);
    
    PersonVo2 toConvertVO2(Person source);
    
    
    
}
