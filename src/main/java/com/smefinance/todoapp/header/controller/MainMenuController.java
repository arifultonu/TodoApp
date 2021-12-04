package com.smefinance.todoapp.header.controller;

import com.smefinance.todoapp.common.model.DBData;
import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.header.service.MainMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = DBData.CROSS_ORIGIN)
@RequestMapping("e-swift")
@Slf4j
public class MainMenuController {

    @Autowired
    private MainMenuService mainMenuService;

    @PostMapping("/menuList")
    public Map<String, Object> getAllprojectList(@RequestBody Parameters request) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(request.getUserId());
        System.out.println(request.getSessionId());
        map.put("mainMenu", mainMenuService.getMainMenu(request));
        return map;
    }

    @PostMapping("/getBranchNameList")
    public Map<String, Object> getBranchName(@RequestBody Parameters parameters){
        Map<String, Object> map = new HashMap<>();
        mainMenuService.getBranchList(parameters);
//        map.put("branchNameList", mainMenuService.getBranchList(parameters));
        map.put("branchName", parameters.getBranchName());

        log.info("branchName: "+map.get("branchName"));
        return map;
    }
}
