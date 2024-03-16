// Function to add a new employee
function addEmployee() {
    const fullName = document.getElementById("fullName").value;
    const designation = document.getElementById("designation").value;
    const dateOfJoining = document.getElementById("dateOfJoining").value;
    const isManager = document.getElementById("isManager").checked;

    const employee = {
        fullName: fullName,
        designation: designation,
        dateOfJoining: dateOfJoining,
        isManager: isManager
    };

    // AJAX POST request to add employee
    fetch('http://localhost:8080/app/employee', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(employee)
    })
        .then(response => response.json())
        .then(data => {
            alert(data.message);
            getAllEmployees();
        })
        .catch(error => console.error('Error:', error));
}

// Function to delete an employee by ID
function deleteEmployee(employeeId) {
    // AJAX DELETE request to delete employee
    fetch(`http://localhost:8080/app/employee/${employeeId}`, {
        method: 'DELETE'
    })
        .then(response => response.json())
        .then(data => {
            alert(data.message);
            getAllEmployees();
        })
        .catch(error => console.error('Error:', error));
}

// Function to populate the form fields with employee data for editing
function populateForm(employee) {
    document.getElementById("updateEmployeeId").value = employee.employeeId;
    document.getElementById("updateFullName").value = employee.fullName;
    document.getElementById("updateDesignation").value = employee.designation;
    document.getElementById("updateDateOfJoining").value = employee.dateOfJoining;
    document.getElementById("updateIsManager").checked = employee.isManager;
    document.getElementById("updateEmployeeForm").style.display = "block";
}

// Function to submit the updated employee details
function submitUpdate() {
    const employeeId = document.getElementById("updateEmployeeId").value;
    const fullName = document.getElementById("updateFullName").value;
    const designation = document.getElementById("updateDesignation").value;
    const dateOfJoining = document.getElementById("updateDateOfJoining").value;
    const isManager = document.getElementById("updateIsManager").checked;

    const updatedEmployee = {
        fullName: fullName,
        designation: designation,
        dateOfJoining: dateOfJoining,
        isManager: isManager
    };

    // AJAX PUT request to update employee details
    fetch(`http://localhost:8080/app/employee/${employeeId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedEmployee)
    })
        .then(response => response.json())
        .then(data => {
            alert(data.message); // Show success message
            document.getElementById("updateEmployeeForm").style.display = "none";
            getAllEmployees(); // Refresh employee list
        })
        .catch(error => console.error('Error:', error));
}

// Function to cancel the update process
function cancelUpdate() {
    document.getElementById("updateEmployeeForm").style.display = "none";
}

// Function to fetch all employees
function getAllEmployees() {
    fetch('http://localhost:8080/app/employee')
        .then(response => response.json())
        .then(data => {
            const employeesTable = document.getElementById('employees');
            employeesTable.innerHTML = '';

            // Loop through retrieved employees and add them to the table
            data.forEach(employee => {
                const tr = document.createElement('tr');
                tr.innerHTML = `
                <td>${employee.employeeId}</td>
                <td>${employee.designation}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.dateOfJoining}</td>
                <td>
                    <button onclick="populateForm(${JSON.stringify(employee)})">Update</button>
                    <button onclick="deleteEmployee(${employee.employeeId})">Delete</button>
                </td>
            `;
                employeesTable.appendChild(tr);
            });
        })
        .catch(error => console.error('Error:', error));
}

// Call getAllEmployees function when the page loads
window.onload = getAllEmployees;
