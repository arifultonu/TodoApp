package com.smefinance.todoapp.setup.service;

import com.smefinance.todoapp.common.model.MessageResponse;
import com.smefinance.todoapp.setup.entity.SetupUserEntity;
import com.smefinance.todoapp.setup.repository.SetupUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SetupUserServiceImpl implements SetupUserService {

    @Autowired
    SetupUserRepo setupUserRepo;

    @Override
    public MessageResponse addUser(SetupUserEntity setupUserEntity) {
        MessageResponse messageResponse = new MessageResponse();
        setupUserRepo.save(setupUserEntity);
        messageResponse.setResponseCode("1");
        messageResponse.setResponseMessage("Add New User Successfully!");
        return messageResponse;
    }

    @Override
    public MessageResponse updateUser(SetupUserEntity setupUserEntity) {
        MessageResponse messageResponse = new MessageResponse();
        SetupUserEntity existingUser = setupUserRepo.findById(setupUserEntity.getId()).orElse(null);
        existingUser.setName(setupUserEntity.getName());
        setupUserRepo.save(existingUser);
        messageResponse.setResponseCode("1");
        messageResponse.setResponseMessage("Update User Successfully!");
        return messageResponse;
    }

    @Override
    public List<SetupUserEntity> updateAllUser(List<SetupUserEntity> setupUserEntity) {
        return setupUserRepo.saveAll(setupUserEntity);
    }

    @Override
    public List<SetupUserEntity> getAllUserList() {
        return setupUserRepo.findAll();
    }

    @Override
    public MessageResponse deleteUser(Long id) {
        MessageResponse messageResponse = new MessageResponse();
        setupUserRepo.deleteById(id);
        messageResponse.setResponseCode("1");
        messageResponse.setResponseMessage("Delete User Successfully!");
        return messageResponse;
    }

    @Override
    public SetupUserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SetupUserEntity> inMemoryUserList = new ArrayList<>();

        log.info("username: " + username);
        Optional<SetupUserEntity> findFirst = inMemoryUserList.stream()
                .filter(user -> user.getUsername().equals(username)).findFirst();
        if (!findFirst.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }
        return findFirst.get();
    }


}
