package com.khyojun.admin.springboot.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final Optional<Integer> amount;
}
