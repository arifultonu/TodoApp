package com.smefinance.todoapp.common.controller;


import com.smefinance.todoapp.common.model.DBData;
import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.common.service.AllSelectListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@CrossOrigin(origins = DBData.CROSS_ORIGIN)
@RequestMapping("/e-swift")
@Slf4j
public class CommonController {

    @Autowired
    private AllSelectListService messageTypeListService;

    @GetMapping("/getMessageTypeList")
    public Map<String, Object> findAllSmMtNameEntity() {
        Map<String, Object> map = new HashMap<>();
        map.put("messageTypeDataList", messageTypeListService.getMessageTypeList());
        return map;
    }

    @GetMapping("/getMessageTypeListForMessageCreation")
    public Map<String, Object> messageTypeListForMessageCreation() {
        Map<String, Object> map = new HashMap<>();
        map.put("messageTypeDataList", messageTypeListService.getMessageTypeListForMessageCreation());
        return map;
    }

    @PostMapping("/getHubDataList")
    public Map<String, Object> hubDataList(@RequestBody Parameters parameters) {
        Map<String, Object> map = new HashMap<>();
        map.put("hubDataList", messageTypeListService.getHubDataListRepo(parameters));
        return map;
    }

    @PostMapping("/getBranchDataList")
    public Map<String, Object> branchDataList(@RequestBody Parameters parameters) {
        Map<String, Object> map = new HashMap<>();
        map.put("branchDataList", messageTypeListService.getBranchDataListRepo(parameters));
        return map;
    }

    @GetMapping("/getReceiverDataList")
    public Map<String, Object> receiverDataList() {
        Map<String, Object> map = new HashMap<>();
        map.put("receiverDataList", messageTypeListService.getReceiverDataListRepo());
        return map;
    }

    @GetMapping("/getCurDataList")
    public Map<String, Object> curDataList() {
        Map<String, Object> map = new HashMap<>();
        map.put("curDataList", messageTypeListService.getCurCodeDataListRepo());
        return map;
    }

    @GetMapping("/getCodCodeDataList")
    public Map<String, Object> codCodeDataList() {
        Map<String, Object> map = new HashMap<>();
        map.put("codCodeDataList", messageTypeListService.getCodCodeDataListRepo());
        return map;
    }

    @PostMapping("/getUserDataList")
    public Map<String, Object> userDataList() {
        Map<String, Object> map = new HashMap<>();
        map.put("userDataList", messageTypeListService.getUserDataListRepo());
        return map;
    }

    @GetMapping("/hello")
    public Collection<String> sayHello() {
        return IntStream.range(0, 10)
                .mapToObj(i -> "Hello number " + i)
                .collect(Collectors.toList());
    }


}
