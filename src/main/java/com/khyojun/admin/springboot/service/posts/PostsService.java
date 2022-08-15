package com.khyojun.admin.springboot.service.posts;

import com.khyojun.admin.springboot.domain.posts.PostRepository;
import com.khyojun.admin.springboot.domain.posts.Posts;
import com.khyojun.admin.springboot.web.dto.PostsSaveRequestDto;
import com.khyojun.admin.springboot.web.dto.PostsResponseDto;
import com.khyojun.admin.springboot.web.dto.PostsSaveRequestDto;
import com.khyojun.admin.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostRepository postRepository;



    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto updateRequestDto){
        Posts posts= postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        posts.update(updateRequestDto.getTitle(), updateRequestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts posts= postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        return new PostsResponseDto(posts);
    }

}