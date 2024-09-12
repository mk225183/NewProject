package com.mk;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 http://localhost:7011/api/adduser

{
    "id":"1",
     "name":"munish", 
     "email":"mk@gmail.com"
}

post  http://localhost:7011/api/user/

GET http://localhost:7011/api/user/1

update or put:http://localhost:7011/api/user/1

Delete:



 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;



@SpringBootApplication
@EnableScheduling
@EnableCaching

public class CrudMysqlApplication {
	
    private static final Logger logger = LoggerFactory.getLogger(CrudMysqlApplication.class);


	public static void main(String[] args) {
		logger.info("Info level log");
        logger.debug("Debug level log");
        logger.error("Error level log");
		SpringApplication.run(CrudMysqlApplication.class, args);
		
	}
	
	/*
	 * @Scheduled(fixedRate=5000) void test1() {
	 * 
	 * System.out.println("Current time is "+new Date()); }
	 */

}
