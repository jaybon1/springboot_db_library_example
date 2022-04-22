package com.example.jpastreamer_project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class JpaStreamerTodoController {

    private final JpaStreamerTodoService jpaStreamerTodoService;

    @GetMapping("todoList")
    public String select (Model model) {
        model.addAttribute("todoList", jpaStreamerTodoService.findAll());
        return "todoList";
    }

    @PostMapping("todoList")
    public @ResponseBody String insert (@RequestBody List<String> stringList) {
        jpaStreamerTodoService.insert(stringList);
        return "ok";
    }

    @PutMapping("todoList")
    public @ResponseBody String update (@RequestBody List<Integer> idxList) {
        jpaStreamerTodoService.changeDone(idxList);
        return "ok";
    }

    @DeleteMapping("todoList")
    public @ResponseBody String delete (@RequestBody List<Integer> idxList) {
        jpaStreamerTodoService.delete(idxList);
        return "ok";
    }
}
