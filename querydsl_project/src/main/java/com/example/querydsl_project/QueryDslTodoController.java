package com.example.querydsl_project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QueryDslTodoController {

    private final QueryDslTodoService queryDslTodoService;

    @GetMapping("todoList")
    public String select (Model model) {
        model.addAttribute("todoList", queryDslTodoService.findAll());
        return "todoList";
    }

    @PostMapping("todoList")
    public @ResponseBody
    String insert (@RequestBody List<String> stringList) {
        queryDslTodoService.insert(stringList);
        return "ok";
    }

    @PutMapping("todoList")
    public @ResponseBody String update (@RequestBody List<Integer> idxList) {
        queryDslTodoService.changeDone(idxList);
        return "ok";
    }

    @DeleteMapping("todoList")
    public @ResponseBody String delete (@RequestBody List<Integer> idxList) {
        queryDslTodoService.delete(idxList);
        return "ok";
    }

}
