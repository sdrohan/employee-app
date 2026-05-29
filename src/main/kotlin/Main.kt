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
    printPayslip()
}

fun printPayslip() {
    // Calculations
    val normalPay = hourlyRate * hoursWorked
    val overtimePay = overtimeHoursWorked * (hourlyRate * 1.5)
    val grossPay = normalPay + overtimePay
    val bonus = grossPay * (bonusPercentage / 100)
    val tax = grossPay * (taxRatePercentage / 100)
    val pension = grossPay * (pensionContributionPercentage / 100)
    val netPay = grossPay + bonus - tax - pension

    println("==================================================")
    println("               PAYSLIP                 ")
    println("==================================================")

    println("Employee ID       : $employeeId")
    println("Employee          : ${getFullName()} ($employeeId)")
    println("Job / Dept        : $jobTitle ($department)")
    println("--------------------------------------------------")
    println("Hourly Rate       : €$hourlyRate")
    println("Hours Worked      : $hoursWorked")
    println("Overtime Hours    : $overtimeHoursWorked")
    println("--------------------------------------------------")
    println("Normal Pay        : €%.2f".format(normalPay))
    println("Overtime Pay      : €%.2f".format(overtimePay))
    println("Gross Pay         : €%.2f".format(grossPay))
    println("Bonus             : €%.2f".format(bonus))
    println("Tax Deduction     : €%.2f".format(tax))
    println("Pension Deduction : €%.2f".format(pension))
    println("--------------------------------------------------")
    println("Net Pay           : €$netPay")
    println("==================================================")
}

fun getFullName() = "${firstName.uppercase()} ${surname.uppercase()}"