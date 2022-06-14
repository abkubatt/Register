package com.example.register.mappers;

import com.example.register.models.dtos.FormDto;
import com.example.register.models.entities.Form;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FormMapper extends BaseMapper<Form, FormDto> {
    FormMapper INSTANCE = Mappers.getMapper(FormMapper.class);
}
