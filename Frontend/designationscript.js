
document.addEventListener("DOMContentLoaded", function() {
    getAllDesignations();
});

function addDesignation() {
    const name = document.getElementById("name").value;
    const remark = document.getElementById("remark").value;

    const designation = {
        name: name,
        remark: remark
    };

    fetch('http://localhost:8080/app/designations', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(designation)
    })
        .then(response => response.json())
        .then(data => {
            alert(data.message);
            getAllDesignations();
        })
        .catch(error => console.error('Error:', error));
}

function getAllDesignations() {
    fetch('http://localhost:8080/app/designations')
        .then(response => response.json())
        .then(data => {
            const designationsTable = document.getElementById('designations');
            designationsTable.innerHTML = '';

            data.forEach(designation => {
                const tr = document.createElement('tr');
                tr.innerHTML = `
            <td>${designation.designationId}</td>
            <td>${designation.name}</td>
            <td>${designation.remark}</td>
            `;
                designationsTable.appendChild(tr);
            });
        })
        .catch(error => console.error('Error:', error));
}
