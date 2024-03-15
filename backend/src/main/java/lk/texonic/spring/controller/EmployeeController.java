package lk.texonic.spring.controller;

import lk.texonic.spring.dto.EmployeeDTO;
import lk.texonic.spring.service.EmployeeService;
import lk.texonic.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:63342")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @PostMapping
    public ResponseUtil addEmployee(@RequestBody EmployeeDTO dto) {
        service.addEmployee(dto);
        return new ResponseUtil("Ok", "Employee successfully added", dto);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseUtil deleteEmployee(@PathVariable int employeeId) {
        service.deleteEmployee(employeeId);
        return new ResponseUtil("Ok", "Employee successfully deleted", null);
    }

    @GetMapping
    public ResponseUtil getAllEmployees() {
        return new ResponseUtil("Ok", "Employees retrieved successfully", service.getAllEmployee());
    }

    @GetMapping("/{employeeId}")
    public ResponseUtil getEmployee(@PathVariable int employeeId) {
        EmployeeDTO employee = service.findEmployee(employeeId);
        if (employee != null) {
            return new ResponseUtil("Ok", "Employee retrieved successfully", employee);
        } else {
            return new ResponseUtil("Error", "Employee not found", null);
        }
    }

    @PutMapping("/{employeeId}")
    public ResponseUtil updateEmployee(@PathVariable int employeeId, @RequestBody EmployeeDTO dto) {
        dto.setEmployeeId(employeeId);
        service.updateEmployee(dto);
        return new ResponseUtil("Ok", "Employee updated successfully", dto);
    }
}
