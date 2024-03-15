package lk.texonic.spring.service.impl;

import lk.texonic.spring.dto.EmployeeDTO;
import lk.texonic.spring.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void addEmployee(EmployeeDTO dto) {

    }

    @Override
    public void deleteEmployee(String employeeId) {

    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return null;
    }

    @Override
    public EmployeeDTO findEmployee(String employeeId) {
        return null;
    }

    @Override
    public void updateEmployee(EmployeeDTO c) {

    }
}
