import model.Employee
import mu.KotlinLogging
import repository.EmployeeRepository
import service.PayrollService

val payrollService = PayrollService()
val employeeRepository = EmployeeRepository()
val logger = KotlinLogging.logger {}

fun main(){
    logger.info { "Launching Employee App" }

    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> add()
            2 -> list()
            3 -> println(getEmployeeById())
            4 -> displayPaySlip()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun menu() : Int {
    print(""" 
         |Employee Menu
         |   1. Add Employee
         |   2. List All Employees
         |   3. Search Employees 
         |   4. Print Payslip for Employee
         |  -1. Exit
         |       
         |Enter Option : """.trimMargin())
    return readln().toInt()
}

fun list() = employeeRepository.getAll().forEach { println(it) }

fun getEmployeeById(): Employee? {
    logger.info { "Searching Employees Activated" }
    print("Enter the employee id to search by: ")
    val employeeID = readln().toInt()
    return employeeRepository.findById(employeeID)
}

fun displayPaySlip(){
    val employee = getEmployeeById()
    if (employee != null){
        val payslip = payrollService.getPayslip(employee)
        println(payslip)
    }
}

fun dummyData() {
    employeeRepository.add(
        Employee(
            0, "Joe", "Soap", "Marketing", "Marketing Intern",
            15.99, 25, 5, 0.0, 23.5, 0.0
        )
    )
    employeeRepository.add(
        Employee(
            0, "Mark", "Flynn", "Sales", "Sales Manager",
            65.99, 39, 9, 6.0, 43.5, 6.0
        )
    )
    employeeRepository.add(
        Employee(
            0, "Minnie", "Mouse", "Accounts", "Payroll Manager",
            55.99, 35, 3, 4.0, 43.5, 5.0
        )
    )
    logger.info { "Dummy Data Added" }
}

fun add() {
    print("Enter first name: ")
    val firstName = readlnOrNull().toString()

    print("Enter surname: ")
    val surname = readlnOrNull().toString()

    print("Enter department: ")
    val department = readlnOrNull().toString()

    print("Enter job title: ")
    val jobTitle = readlnOrNull().toString()

    print("Enter hourly rate: ")
    val hourlyRate = readln().toDouble()

    print("Enter hours worked: ")
    val hoursWorked = readln().toInt()

    print("Enter overtime hours worked: ")
    val overtimeHoursWorked = readln().toInt()

    print("Enter bonus percentage: ")
    val bonusPercentage = readln().toDouble()

    print("Enter tax rate percentage: ")
    val taxRatePercentage = readln().toDouble()

    print("Enter pension contribution percentage: ")
    val pensionContributionPercentage = readln().toDouble()

    employeeRepository.add(
    Employee(
        0,
        firstName,
        surname,
        department,
        jobTitle,
        hourlyRate,
        hoursWorked,
        overtimeHoursWorked,
        bonusPercentage,
        taxRatePercentage,
        pensionContributionPercentage)
    )

    logger.info { "Employee Added" }
}

// Utility function to format monetary values to two decimal places
fun money(value: Double) = "€%.2f".format(value)