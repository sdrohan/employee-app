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

fun main() {
    println("Pay Slip Printer")
    println(getPayslip())
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