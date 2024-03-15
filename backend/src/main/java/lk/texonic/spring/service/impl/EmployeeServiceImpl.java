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
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addEmployee(EmployeeDTO dto) {
        if (employeeRepo.existsById(dto.getEmployeeId())) {
            throw new RuntimeException(dto.getEmployeeId() + " is already in use.");
        }
        Employee map = mapper.map(dto, Employee.class);
        employeeRepo.save(map);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        if (!employeeRepo.existsById(employeeId)) {
            throw new RuntimeException(employeeId + " Employee does not exist.");
        }
        employeeRepo.deleteById(employeeId);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        // Implement logic to fetch all employees from the database
        // and map them to EmployeeDTO objects
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream()
                .map(employee -> mapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findEmployee(int employeeId) {
        // Implement logic to find an employee by ID in the database
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
        return mapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public void updateEmployee(EmployeeDTO dto) {
        // Implement logic to update an existing employee
        Employee existingEmployee = employeeRepo.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + dto.getEmployeeId()));

        // Update fields of the existing employee entity with values from the DTO
        existingEmployee.setFullName(dto.getFullName());
        existingEmployee.setDateOfJoining(dto.getDateOfJoining());
        existingEmployee.setManager(dto.isManager());

        // Save the updated employee entity
        employeeRepo.save(existingEmployee);
    }
}
