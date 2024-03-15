// Function to add a new employee
function addEmployee() {
    const fullName = document.getElementById('fullName').value;
    const dateOfJoining = document.getElementById('dateOfJoining').value;
    const isManager = document.getElementById('isManager').checked;

    // Split full name into first name and last name
    const firstName = fullName.split(' ')[0];
    const lastName = fullName.substring(firstName.length).trim();

    const employeeData = {
        fullName: fullName,
        dateOfJoining: dateOfJoining,
        isManager: isManager
    };

    // Send POST request to backend to save employee details
    fetch('http://localhost:8080/employee', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(employeeData)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Employee added successfully:', data);
            // Refresh employee table after adding new employee
            getEmployees();
        })
        .catch(error => console.error('Error adding employee:', error));
}

// Function to fetch all employees and populate the employee table
function getEmployees() {
    fetch('http://localhost:8080/employee')
        .then(response => response.json())
        .then(employees => {
            const table = document.getElementById('employeeTable');
            table.innerHTML = ''; // Clear previous table content

            employees.forEach(employee => {
                const row = table.insertRow();
                row.innerHTML = `
                <td>${employee.employeeId}</td>
                <td>${employee.fullName}</td>
                <td>${employee.dateOfJoining}</td>
                <td>${employee.isManager ? 'Yes' : 'No'}</td>
                <td>
                    <button onclick="editEmployee(${employee.employeeId})">Edit</button>
                    <button onclick="deleteEmployee(${employee.employeeId})">Delete</button>
                </td>
            `;
            });
        })
        .catch(error => console.error('Error fetching employees:', error));
}

// Function to edit employee details
function editEmployee(employeeId) {
    // Implement edit functionality here
    alert('Edit employee with ID: ' + employeeId);
}

// Function to delete employee
function deleteEmployee(employeeId) {
    // Implement delete functionality here
    if (confirm('Are you sure you want to delete employee with ID ' + employeeId + '?')) {
        fetch(`http://localhost:8080/employee/${employeeId}`, {
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    console.log('Employee deleted successfully');
                    getEmployees(); // Refresh employee table after deletion
                } else {
                    console.error('Failed to delete employee:', response.statusText);
                }
            })
            .catch(error => console.error('Error deleting employee:', error));
    }
}

// Initial load: Fetch employees and populate the table
getEmployees();
