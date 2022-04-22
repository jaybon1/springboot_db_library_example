package com.example.mybatis_project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class MyBatisTodoController {

    private final MyBatisTodoService myBatisTodoService;

    @GetMapping("todoList")
    public String select (Model model) {
        model.addAttribute("todoList", myBatisTodoService.findAll());
        return "todoList";
    }

    @PostMapping("todoList")
    public @ResponseBody String insert (@RequestBody List<String> stringList) {
        myBatisTodoService.insert(stringList);
        return "ok";
    }

    @PutMapping("todoList")
    public @ResponseBody String update (@RequestBody List<Integer> idxList) {
        myBatisTodoService.changeDone(idxList);
        return "ok";
    }

    @DeleteMapping("todoList")
    public @ResponseBody String delete (@RequestBody List<Integer> idxList) {
        myBatisTodoService.delete(idxList);
        return "ok";
    }


}
