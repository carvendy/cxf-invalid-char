package com.carvendy.service;

import javax.jws.WebService;

import com.carvendy.dto.Student;

@WebService
public interface IStudentService {

	public Student get(int id);
	
	public Student one();
}
