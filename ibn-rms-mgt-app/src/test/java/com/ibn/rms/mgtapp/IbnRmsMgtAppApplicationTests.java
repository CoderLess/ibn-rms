package com.ibn.rms.mgtapp;

import com.ibn.rms.domain.UserBaseDTO;
import com.ibn.rms.exception.IbnException;
import com.ibn.rms.service.UserBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IbnRmsMgtAppApplicationTests {
    @Autowired
    private UserBaseService userBaseService;
    @Test
    void contextLoads() throws IbnException {
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        userBaseDTO.setUserId (0L);
        userBaseDTO.setUsername ("4Username");
        userBaseDTO.setPassword ("1Password");
        userBaseDTO.setRegType (1);
        userBaseDTO.setRegTime (0L);
        userBaseDTO.setLastLoginTime (0L);
        userBaseService.save(userBaseDTO);
    }

}
