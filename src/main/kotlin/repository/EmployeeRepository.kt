package repository

import model.Employee

var lastId = 0

internal fun getId(): Int {
    return lastId++
}

class EmployeeRepository {

    private val employees = arrayListOf<Employee>()

    fun add(employee: Employee) {
        employee.employeeId = getId()
        employees.add(employee)
    }

    fun getAll(): List<Employee> = employees

    fun findById(id: Int): Employee? =
        employees.find { it.employeeId == id }
}