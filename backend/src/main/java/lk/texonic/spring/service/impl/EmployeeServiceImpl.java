package lk.texonic.spring.service.impl;

import lk.texonic.spring.dto.EmployeeDTO;
import lk.texonic.spring.entity.Employee;
import lk.texonic.spring.repo.EmployeeRepo;
import lk.texonic.spring.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addEmployee(EmployeeDTO dto) {
        if (employeeRepo.existsById(dto.getEmployeeId())){
        throw  new RuntimeException(dto.getEmployeeId()+"is available");
        }
        Employee map = mapper.map(dto,Employee.class);
        employeeRepo.save(map);

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
