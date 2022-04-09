import fetch from 'unfetch';

const checkStatus = response => {
    if(response.ok) {
        return response;
    } else {
        let error = new Error(response.statusText);
        error.response = response;
        response.json().then(e => {
            error.error = e;
        });
        return Promise.reject(error);
    }
}

// Get the json from api/students using GET
export const getAllStudents = () => 
    fetch('api/students').then(checkStatus);

//Same thing but with POST
export const addNewStudent = student => 
fetch('api/students', {
    headers: {
        'Content-Type': 'application/json'
    },
    method: 'POST', 
    body: JSON.stringify(student) 
})
.then(checkStatus);
