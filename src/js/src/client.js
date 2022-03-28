import fetch from 'unfetch';

<<<<<<< HEAD
export const getAllStudents = () => fetch('api/students');

export const addNewStudent = student => fetch('api/students', {
    headers: {
        'Content-Type': 'application/json'
    },
    method: 'POST', 
    body: JSON.stringify(student) 
});
=======
export const getAllStudents = () => fetch('api/students');
>>>>>>> 11ea5b37f781ea12f2d3dac72fbe9a888d40513f
