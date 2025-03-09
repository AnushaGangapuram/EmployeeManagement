import React, { useEffect, useState } from 'react'
import { deleteEmployee, listEmployees } from '../Services/EmployeeService'
import { useNavigate,useParams } from 'react-router-dom';


const ListEmployeeComponent = () => {

    const [employees,setEmployees] = useState([])

    const navigator = useNavigate();

    useEffect(() =>{
        getAllEmployyes();
        
        
    }, [])

    function getAllEmployyes(){
        listEmployees().then((response) =>{
            setEmployees(response.data); 
        }).catch(error => {
            console.error(error);
        })
        
    }

    function addNewEmployee(){
        navigator('/add-employee')

    }

    function updateEmployee(id){
        navigator(`/edit-employee/${id}`)
    }

    function removeEmployee (id){
        console.log(id);

        deleteEmployee(id).then((response) => {
            getAllEmployyes();
            

        }).catch(error => {
            console.error(error);
        })
    }

    return (
        <div className='container'>
            <h1 className='text-center' >List of Employees</h1>
            <button className='btn btn-primary mb-2' onClick={addNewEmployee}>Add Employee</button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>Employee First Name</th>
                        <th>Employee Last Name</th>
                        <th>Employee Email</th>
                        <th>Employee Designation</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        employees.map(employee =>
                            <tr key={employee.id}>
                                <td>{employee.id}</td> {/* Added Employee ID */}
                                <td>{employee.firstName}</td>
                                <td>{employee.lastName}</td>
                                <td>{employee.email}</td> {/* Fixed property name */}
                                <td>{employee.desig}</td>
                                <td>
                                    <button className='btn btn-info' onClick={() =>  updateEmployee(employee.id)}>Update</button>

                                    <button className='btn btn-danger' onClick={() => removeEmployee(employee.id)}>Delete</button>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListEmployeeComponent
