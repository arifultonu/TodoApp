package com.smefinance.todoapp.header.service;

import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.header.entity.MainMenuEntity;

import java.util.List;

public interface MainMenuService {
    List<MainMenuEntity> getMainMenu(Parameters parameters);
    List<MainMenuEntity> getBranchList(Parameters parameters);
}
