var employee =  Employee(
    1,
    "Joe",
    "Soap",
    "Computer Services",
    "Technician",
    32.45,
    38,
    5,
    5.0,
    23.0,
    7.5)

fun main(){

    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> println("Hourly Rate: ${employee.hourlyRate}")
            2 -> println("Hours Worked: ${employee.hoursWorked}")
            3 -> println("Overtime Hours: ${employee.overtimeHoursWorked}, Amount Earned: ${calculateOvertimePay()}")
            4 -> println("Bonus Amount: ${money(calculateBonus())}")
            5 -> println("Tax Paid: ${money(calculateTax())} at rate ${employee.taxRatePercentage}")
            6 -> println("Pension Paid: ${money(calculatePension())} at rate ${employee.pensionContributionPercentage}")
            7 -> println("Gross Pay: ${money(calculateGrossPay())}")
            8 -> println("Net pay: ${money(calculateNetPay())}")
            9 -> println(getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}


fun menu() : Int {
    print("""
         Employee Menu for ${getFullName()}
           1. Hourly Rate
           2. Hours Worked
           3. Overtime Hours
           4. Bonus
           5. Tax Rate
           6. Pension
           7. Gross Pay
           8. Net Pay
           9. Full Payslip
          -1. Exit
         Enter Option : """)
    return readln().toInt()
}

fun getPayslip(): String {

    return """
        |==================================================
        |               PAYSLIP                 
        |==================================================
        |
        |Employee ID       : ${employee.employeeId}
        |Employee          : ${getFullName()} (${employee.employeeId})
        |Job / Dept        : ${employee.jobTitle} (${employee.department})
        |--------------------------------------------------
        |Hourly Rate       : €${employee.hourlyRate}
        |Hours Worked      : ${employee.hoursWorked}
        |Overtime Hours    : ${employee.overtimeHoursWorked}
        |--------------------------------------------------
        |Normal Pay        : ${money(calculateNormalPay())}
        |Overtime Pay      : ${money(calculateOvertimePay())}
        |Gross Pay         : ${money(calculateGrossPay())}
        |Bonus             : ${money(calculateBonus())}
        |Tax Deduction     : ${money(calculateTax())}
        |Pension Deduction : ${money(calculatePension())}
        |--------------------------------------------------
        |Net Pay           : ${money(calculateNetPay())}
        |==================================================
    """.trimMargin()
}

fun getFullName() = "${employee.firstName.uppercase()} ${employee.surname.uppercase()}"
fun calculateNormalPay() = employee.hourlyRate * employee.hoursWorked
fun calculateOvertimePay() = employee.overtimeHoursWorked * (employee.hourlyRate * 1.5)
fun calculateGrossPay() = calculateNormalPay() + calculateOvertimePay()
fun calculateBonus() = calculateGrossPay() * (employee.bonusPercentage / 100)
fun calculateTax() = calculateGrossPay() * (employee.taxRatePercentage / 100)
fun calculatePension() = calculateGrossPay() * (employee.pensionContributionPercentage / 100)
fun calculateNetPay() = calculateGrossPay() + calculateBonus() - calculateTax() - calculatePension()

// Utility function to format monetary values to two decimal places
fun money(value: Double) = "€%.2f".format(value)