val employeeId: Int = 6143
val firstName: String = "Joe"
val surname: String = "Soap"
val department: String = "Computer Services"
val jobTitle: String = "Technician"

val hourlyRate: Double = 26.87
val hoursWorked: Int = 39
val overtimeHoursWorked: Int = 4

val bonusPercentage: Double = 4.5
val taxRatePercentage: Double = 23.5
val pensionContributionPercentage: Double = 6.7

fun main(){

    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> println("Hourly Rate: $hourlyRate")
            2 -> println("Hours Worked: $hoursWorked")
            3 -> println("Overtime Hours: $overtimeHoursWorked, Amount Earned: ${calculateOvertimePay()}")
            4 -> println("Bonus Amount: ${money(calculateBonus())}")
            5 -> println("Tax Paid: ${money(calculateTax())} at rate $taxRatePercentage")
            6 -> println("Pension Paid: ${money(calculatePension())} at rate $pensionContributionPercentage")
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
        |Employee ID       : $employeeId
        |Employee          : ${getFullName()} ($employeeId)
        |Job / Dept        : $jobTitle ($department)
        |--------------------------------------------------
        |Hourly Rate       : €$hourlyRate
        |Hours Worked      : $hoursWorked
        |Overtime Hours    : $overtimeHoursWorked
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

fun getFullName() = "${firstName.uppercase()} ${surname.uppercase()}"
fun calculateNormalPay() = hourlyRate * hoursWorked
fun calculateOvertimePay() = overtimeHoursWorked * (hourlyRate * 1.5)
fun calculateGrossPay() = calculateNormalPay() + calculateOvertimePay()
fun calculateBonus() = calculateGrossPay() * (bonusPercentage / 100)
fun calculateTax() = calculateGrossPay() * (taxRatePercentage / 100)
fun calculatePension() = calculateGrossPay() * (pensionContributionPercentage / 100)
fun calculateNetPay() = calculateGrossPay() + calculateBonus() - calculateTax() - calculatePension()

// Utility function to format monetary values to two decimal places
fun money(value: Double) = "€%.2f".format(value)