package com.carvendy.service;

import com.carvendy.dto.Student;

public class StudentServiceImpl implements IStudentService {

	@Override
	public Student get(int id) {
		return null;
	}

	@Override
	public Student one() {
		Student stu = new Student();
		stu.setAge(12);
		String name = ((char)(1))+"haha";
		stu.setName(name);
		return stu;
	}

}
