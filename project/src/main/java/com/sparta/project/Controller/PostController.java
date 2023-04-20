package com.sparta.project.Controller;

import com.sparta.project.Dto.PostRequestDto;
import com.sparta.project.Dto.PostResponseDto;
import com.sparta.project.Service.PostService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    //게시글 작성
    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto, HttpServletResponse httpServletResponse) {
        return postService.createPost(requestDto, httpServletResponse);
    }

    //전체 게시글 조회
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    //선택한 게시글 조회
    @GetMapping("/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    //게시글 수정
    @PutMapping("/posts/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto, HttpServletResponse httpServletResponse) {
        return postService.updatePost(id, requestDto, httpServletResponse);
    }

    //게시글 삭제
    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id, HttpServletResponse httpServletResponse) {
        return postService.deletePost(id, httpServletResponse);
    }


}
