package com.anto.ktool.service;

import com.anto.ktool.dao.AccountRepository;
import com.anto.ktool.model.dto.RegisterDTO;
import com.anto.ktool.model.entity.Account;
import com.anto.ktool.model.entity.User;
import com.anto.ktool.utils.AppConstant;
import com.anto.ktool.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public RegisterDTO registerAccount(RegisterDTO registerDTO) {
        User user = MapperUtils.mapObject(registerDTO, User.class);
        Account account = MapperUtils.mapObject(registerDTO, Account.class);


        user.setUserType(AppConstant.ADMIN);
        user.setEmail(account.getEmail());
        user.setActive(AppConstant.USER_ACTIVE);

        List<User> users = new ArrayList<>();
        users.add(user);
        account.setUsers(users);

        try {

            Account savedUser = accountRepository.save(account);

            if (savedUser.getAccountId() > 0) {
                Optional<Account> byId = accountRepository.findById(savedUser.getAccountId());
                byId.get().getUsers().forEach(da -> {
                    System.out.println(da.getEmail());
                });
                return accountRegistered(savedUser);
            }
        }catch (Exception z){
            System.out.println("Exception"+z.getLocalizedMessage());
        }

        return null;

    }

    private RegisterDTO accountRegistered(Account savedUser) {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName(savedUser.getUsers().get(0).getName());
        return registerDTO;
    }


}
