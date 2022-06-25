package nhathoang.dev.service;

import java.util.List;

import nhathoang.dev.model.Employee;

public interface EmployeeService {
	Iterable<Employee> findAll();
    List<Employee> search(String q);

	Employee findOne(long id); 
    void save(Employee emp);
    void delete(Employee emp);
}
