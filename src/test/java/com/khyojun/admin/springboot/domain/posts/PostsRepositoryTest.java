package com.khyojun.admin.springboot.domain.posts;


import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After
    public void cleanup(){
        postRepository.deleteAll();

    }

    @Test
    public void 게시글저장_불러오기(){
        //given 테스트준비과정

        String title="테스트 게시글";
        String content="테스트 본문";

        postRepository.save(Posts.builder().title(title).content(content).author("jojoldu@gmail.com").
                build());

        //when 구체화하고자 하는 행동

        List<Posts> postsList = postRepository.findAll();


        //then 행동에 대한 기댓값이 성립하는지?
        Posts posts= postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);


    }

}
