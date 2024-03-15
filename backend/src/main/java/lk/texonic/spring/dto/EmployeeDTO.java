package lk.texonic.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EmployeeDTO {
    private int employeeId;
    private String fullName;
    private Date dateOfJoining;
    private boolean isManager;
}
