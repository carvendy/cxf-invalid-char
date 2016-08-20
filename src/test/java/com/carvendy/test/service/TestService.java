package com.carvendy.test.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.carvendy.dto.Student;
import com.carvendy.service.IStudentService;
import com.carvendy.service.StudentServiceImpl;
import com.carvendy.test.BaseTest;

public class TestService extends BaseTest{

	@Autowired
	private IStudentService service;
	
	@Test
	public void haha() throws Exception {
		Student one = service.one();
		System.out.println(one);
	}
}
