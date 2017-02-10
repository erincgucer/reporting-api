package com.clearsettle;

import com.clearsettle.service.authentication.LoginTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportingApiApplicationTests {

	@Autowired
	private LoginTest loginTest;


	@Test
	public void contextLoads() {

		loginTest.login();

	}

}
