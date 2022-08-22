package com.khyojun.admin.springboot.web;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void 게시판_등록(){
    //when
        String body=this.restTemplate.getForObject("/", String.class);

        //then
        Assertions.assertThat(body).contains("스프링부트로 시작하는 웹 서비스");
    }
}
