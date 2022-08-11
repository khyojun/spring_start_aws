package com.khyojun.admin.springboot.dto;

import com.khyojun.admin.springboot.web.dto.HelloResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Optional;

public class HelloResponseDtoTest {



    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        Optional<Integer> amount=Optional.of(1000);

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then

        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
