package lk.texonic.spring.service;

import lk.texonic.spring.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    void addEmployee(EmployeeDTO dto);
    void deleteEmployee(String employeeId);
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO findEmployee(String employeeId);
    void updateEmployee(EmployeeDTO c);
}
