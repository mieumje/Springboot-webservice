package com.mieumje.springboot.web;

import com.mieumje.springboot.service.PostsService;
import com.mieumje.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("posts",postsService.findAllDesc());
        return "index";
    }
    // 글 저장
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    // 글 수정
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }
}
