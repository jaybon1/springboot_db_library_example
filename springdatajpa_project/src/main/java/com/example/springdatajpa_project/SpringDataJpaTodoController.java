package com.example.springdatajpa_project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SpringDataJpaTodoController {

    private final SpringDataJpaTodoService springDataJpaTodoService;

    @GetMapping("todoList")
    public String select (Model model) {
        model.addAttribute("todoList", springDataJpaTodoService.findAll());
        return "todoList";
    }

    @PostMapping("todoList")
    public @ResponseBody
    String insert (@RequestBody List<String> stringList) {
        springDataJpaTodoService.insert(stringList);
        return "ok";
    }

    @PutMapping("todoList")
    public @ResponseBody String update (@RequestBody List<Integer> idxList) {
        springDataJpaTodoService.changeDone(idxList);
        return "ok";
    }

    @DeleteMapping("todoList")
    public @ResponseBody String delete (@RequestBody List<Integer> idxList) {
        springDataJpaTodoService.delete(idxList);
        return "ok";
    }
}
