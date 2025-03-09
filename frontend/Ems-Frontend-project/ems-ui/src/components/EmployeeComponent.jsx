import React, { useEffect, useState } from 'react';
import { createEmployees, getEmployee, updateEmployee } from '../Services/EmployeeService';
import { useNavigate ,useParams} from 'react-router-dom';


const EmployeeComponent = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [desig, setDesig] = useState('');

    const{id} = useParams();
    const [errors, setErrors] = useState({
        firstName: '',
        lastName: '',
        email: '',
        desig: ''
    })
    const navigator = useNavigate();

    useEffect(() => {
        if(id){
            getEmployee(id).then((response) => {
                setFirstName(response.data.firstName);
                setLastName(response.data.lastName);
                setEmail(response.data.email);
                setDesig(response.data.desig);
            }).catch(error =>{
                console.error(error);
            })
        }
    }, [id])



    function saveOrUpdateEmployee(e) {
        e.preventDefault();

        if (validateForm()) {

            const employee = { firstName, lastName, email, desig };
            console.log(employee);


            if (id){
                updateEmployee(id, employee).then((response) =>{
                    console.log(response.data);
                    navigator('/employees')
                }).catch(error => {
                    console.log(error);
                })
            } else{

                createEmployees(employee).then((response) => {
                    console.log(response.data);
                    navigator('/employees')
                }).catch(error => {
                    console.log(error);
                })
    

            }

          
          
        }


    }

    function validateForm() {
        let valid = true;
        const errorsCopy = { ...errors };

        if (firstName.trim()) {
            errorsCopy.firstName = '';
        } else {
            errorsCopy.firstName = 'First name is required';
            valid = false;
        }

        if (lastName.trim()) {
            errorsCopy.lastName = '';
        } else {
            errorsCopy.lastName = 'Last name is required';
            valid = false;
        }

        if (email.trim()) {
            errorsCopy.email = '';
        } else {
            errorsCopy.email = 'Email is required';
            valid = false;
        }

        if (desig.trim()) {
            errorsCopy.desig = '';
        } else {
            errorsCopy.desig = 'Designation is required';
            valid = false;
        }

        setErrors(errorsCopy);
        return valid;
    }

    function pageTitle(){
        if(id){
          return  <h2 className="text-center">Update Employee</h2>
        }else {
          return <h2 className="text-center">Add Employee</h2>
        }
    
      }
    


    return (
        <div className='container'>
            <div className='row justify-content-center'>
                <div className='card col-md-6 mt-4'>
                    {
                        pageTitle()
                    }
                    
                    <div className='card-body'>
                        <form>
                            <div className='form-group mb-2'>
                                <label className='form-label'>First Name</label>
                                <input
                                    type='text'
                                    placeholder='Enter Employee First Name'
                                    name='firstName'
                                    value={firstName}
                                    className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}

                                    onChange={(e) => setFirstName(e.target.value)}
                                />

                                {errors.firstName && <div className="invalid-feedback">{errors.firstName}</div>}

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Last Name:</label>
                                <input
                                    type="text"
                                    placeholder="Enter employee Last Name"
                                    name="lastName"
                                    value={lastName}
                                    className={`form-control ${errors.lastName ? 'is-invalid' : ''}`}

                                    onChange={(e) => setLastName(e.target.value)}
                                />
                                {errors.lastName && <div className="invalid-feedback">{errors.lastName}</div>}

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Email:</label>
                                <input
                                    type="email"
                                    placeholder="Enter employee Email"
                                    name="email"
                                    value={email}
                                    className={`form-control ${errors.email ? 'is-invalid' : ''}`}

                                    onChange={(e) => setEmail(e.target.value)}
                                />

                                {errors.email && <div className="invalid-feedback">{errors.email}</div>}

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Designation:</label>
                                <input
                                    type="text"
                                    placeholder="Enter employee Designation"
                                    name="designation"
                                    value={desig}
                                    className={`form-control ${errors.desig ? 'is-invalid' : ''}`}

                                    onChange={(e) => setDesig(e.target.value)}
                                />

                                {errors.desig && <div className="invalid-feedback">{errors.desig}</div>}

                            </div>

                            <button className="btn btn-success" onClick={saveOrUpdateEmployee}>
                                Submit
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default EmployeeComponent;
