package com.gcdd.sample;

import com.gcdd.sample.form.UserForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateValidatorSampleApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void sizeInList() {
		UserForm form = new UserForm();
		List<String> list = Arrays.asList("111");
		form.setList(list);
	}

}

