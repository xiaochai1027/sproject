package com.cfc.task;

import com.cfc.dao.mapper.CheckUuidMapper;
import com.cfc.dao.model.CheckUuid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @auther fangchen.chai ON 2017/11/22
 * 测试UUID是否会出现重复
 */
@Component
public class Task {

    private Logger logger = LoggerFactory.getLogger(Task.class);

    @Autowired
    private CheckUuidMapper checkUuidMapper;

    @Scheduled(cron = "0/1 * * * * ?")
    public void checkUuid(){
        CheckUuid checkUuid = new CheckUuid();
        checkUuid.setId(UUID.randomUUID().toString().replaceAll("-",""));
        checkUuidMapper.insertOrUpdateCheckUuid(checkUuid);
        logger.info("task --- checkUuid = {}",checkUuid.getId());
    }
}
