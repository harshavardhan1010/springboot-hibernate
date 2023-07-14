package com.harsha.restCRUD.dao;
import com.harsha.restCRUD.entity.Employee;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
