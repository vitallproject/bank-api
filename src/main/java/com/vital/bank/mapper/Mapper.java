package com.vital.bank.mapper;

public interface Mapper<F, T> {

    T map(F object);
}
