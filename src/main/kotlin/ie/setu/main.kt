package ie.setu

val firstName = "Joe"
val surname = "Soap"
val gender = 'm'
val employeeID = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonus = 1450.50
val cycleToWorkMonthlyDeduction = 54.33

fun main(args: Array<String>){
    println("Payslip Printer")
    printPayslip()
    println("\n")
    printPayslipWithRounding()
}

fun printPayslip(){

    val monthlySalary = (grossSalary/12)
    val monthlyPrsi = monthlySalary * (prsiPercentage / 100)
    val monthlyPaye = monthlySalary * (payePercentage / 100)
    val grossPay = (monthlySalary + (annualBonus/12))
    val totalDeductions = (monthlyPrsi + monthlyPrsi + cycleToWorkMonthlyDeduction)

    println ("_________________________________________________________________________")
    println ("|                          Monthly Payslip                              |")
    println ("|_______________________________________________________________________|")
    println ("|                                                                       |")
    println ("|   Employee Name:  " + firstName.uppercase() + " " + surname.uppercase() + "(" + gender.uppercase() + ")                    Employee ID: " + employeeID + "    |")
    println ("|                                                                       |")
    println ("|_______________________________________________________________________|")
    println ("|                                                                       |")
    println ("|    PAYMENT DETAILS \t\t\t\t DEDUCTION DETAILS  \t\t\t\t|")
    println ("|_______________________________________________________________________|")
    println ("|    Salary: " + monthlySalary + "\t\t PAYE: " + monthlyPaye + "\t\t\t|")
    println ("|    Bonus:  " + (annualBonus / 12) + "\t\t\t\t PRSI: " + monthlyPrsi  + "\t\t\t|")
    println ("|    \t\t\t\t\t\t\t\t Cycle To Work: " + cycleToWorkMonthlyDeduction  + "\t\t\t\t|")
    println ("|_______________________________________________________________________|")
    println ("|    Gross:  " + grossPay + " \t\tTotal Deductions: " + totalDeductions + " |")
    println ("|_______________________________________________________________________|")
    println ("|   \t\t\t\t NET PAY:" + (grossPay - totalDeductions) + " \t\t\t\t\t\t\t|")
    println ("|_______________________________________________________________________|")
}

fun printPayslipWithRounding(){

    val monthlySalary = (grossSalary/12)
    val monthlyPrsi = monthlySalary * (prsiPercentage / 100)
    val monthlyPaye = monthlySalary * (payePercentage / 100)
    val grossPay = (monthlySalary + (annualBonus/12))
    val totalDeductions = (monthlyPrsi + monthlyPrsi + cycleToWorkMonthlyDeduction)

    println ("_________________________________________________________________________")
    println ("|                          Monthly Payslip                              |")
    println ("|_______________________________________________________________________|")
    println ("|                                                                       |")
    println ("|   Employee Name:  " + firstName.uppercase() + " " + surname.uppercase() + "(" + gender.uppercase() + ")                    Employee ID: " + employeeID + "    |")
    println ("|                                                                       |")
    println ("|_______________________________________________________________________|")
    println ("|                                                                       |")
    println ("|    PAYMENT DETAILS \t\t\t\t DEDUCTION DETAILS  \t\t\t\t|")
    println ("|_______________________________________________________________________|")
    println ("|    Salary: " + "%.2f".format(monthlySalary) + "\t\t\t\t PAYE: " + "%.2f".format(monthlyPaye) + "\t\t\t\t\t\t|")
    println ("|    Bonus:  " + "%.2f".format((annualBonus / 12)) + "\t\t\t\t\t PRSI: " + "%.2f".format(monthlyPrsi)  + "\t\t\t\t\t\t|")
    println ("|    \t\t\t\t\t\t\t\t Cycle To Work: " + cycleToWorkMonthlyDeduction  + "\t\t\t\t|")
    println ("|_______________________________________________________________________|")
    println ("|    Gross:  " + "%.2f".format(grossPay) + " \t\t\t\tTotal Deductions: " + "%.2f".format(totalDeductions) + " \t\t\t|")
    println ("|_______________________________________________________________________|")
    println ("|   \t\t\t\t\t\t NET PAY:" + "%.2f".format((grossPay - totalDeductions)) + " \t\t\t\t\t\t\t|")
    println ("|_______________________________________________________________________|")
}

