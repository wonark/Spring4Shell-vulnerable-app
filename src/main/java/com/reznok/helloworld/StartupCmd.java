package com.reznok.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Component;

@Component
public class StartupCmd implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartupCmd.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Spring Version: {} (Not Vulnerable if Spring versions >= 5.3.18 OR >= 5.2.20)", SpringVersion.getVersion());
    }
}
