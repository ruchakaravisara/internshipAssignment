package lk.texonic.spring.service;

import lk.texonic.spring.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    void addEmployee(EmployeeDTO dto);
    void deleteEmployee(int employeeId);
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO findEmployee(int employeeId);
    void updateEmployee(EmployeeDTO c);
}
