package com.shawn.springblog.controller;


import com.shawn.springblog.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor
public class ArchiveShowController {


    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model) {
        System.out.println(blogService.archiveBlog().keySet().toString());

        model.addAttribute("archiveMap", blogService.archiveBlog());
        model.addAttribute("blogCount", blogService.countBlog());
        return "archives";
    }
}
