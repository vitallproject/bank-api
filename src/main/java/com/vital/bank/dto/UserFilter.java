package com.vital.bank.dto;

public record UserFilter(
        String firstName,
        String lastName,
        String email
) {}
