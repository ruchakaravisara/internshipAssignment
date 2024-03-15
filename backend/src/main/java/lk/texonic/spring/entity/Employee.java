package lk.texonic.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Employee {
    @Id
    private int employeeId;
    private String fullName;
    private Date dateOfJoining;
    private boolean isManager;
}
