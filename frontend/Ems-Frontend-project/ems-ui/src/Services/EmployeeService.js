import axios from 'axios';

const BASE_URL = "http://localhost:8081/Employees";

export const listEmployees = () => axios.get(`${BASE_URL}/getAll`);

export const createEmployees = (employee) => axios.post(BASE_URL, employee);


export const getEmployee = (employeeId) => axios.get(`${BASE_URL}/${employeeId}`);

export const updateEmployee = (employeeId, employee) => axios.put(`${BASE_URL}/${employeeId}`, employee);

export const deleteEmployee = (employeeId) => axios.delete(`${BASE_URL}/${employeeId}`);