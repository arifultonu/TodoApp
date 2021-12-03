package com.smefinance.todoapp.operation.task_info.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/todo")
@Slf4j
public class TaskInfoController {

    @GetMapping("/hello")
    public Collection<String> getHelloRestApi(){
        log.info("Hello Called!");
        return IntStream.range(0, 10)
                .mapToObj(i -> "Hello number " + i)
                .collect(Collectors.toList());
    }
}
