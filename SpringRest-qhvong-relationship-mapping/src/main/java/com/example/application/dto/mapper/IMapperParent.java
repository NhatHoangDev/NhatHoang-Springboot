package com.example.application.dto.mapper;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IMapperParent<T1, T2> {
    T1 toT1(T2 t2);

    T2 toT2(T1 t1);

    List<T1> toT1s(List<T2> t2s);
}
