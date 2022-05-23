package ie.setu

import kotlin.math.round

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
}

fun printPayslip(){

    val monthlySalary   = roundTwoDecimals(grossSalary/12)
    val monthlyPrsi     = roundTwoDecimals(monthlySalary * (prsiPercentage / 100))
    val monthlyPaye     = roundTwoDecimals(monthlySalary * (payePercentage / 100))
    val grossPay        = roundTwoDecimals(monthlySalary + (annualBonus/12))
    val totalDeductions = roundTwoDecimals((monthlyPrsi + monthlyPrsi + cycleToWorkMonthlyDeduction))

    println ("_________________________________________________________________________")
    println ("|                          Monthly Payslip                              |")
    println ("|_______________________________________________________________________|")
    println ("|                                                                       |")
    println ("|   Employee Name:  ${firstName.uppercase()} ${surname.uppercase()} (${gender.uppercase()})                   Employee ID: $employeeID    |")
    println ("|                                                                       |")
    println ("|_______________________________________________________________________|")
    println ("|                                                                       |")
    println ("|    PAYMENT DETAILS \t\t\t\t DEDUCTION DETAILS  \t\t\t\t|")
    println ("|_______________________________________________________________________|")
    println ("|    Salary: $monthlySalary \t\t\t\t PAYE: $monthlyPaye \t\t\t\t\t\t|")
    println ("|    Bonus:  ${roundTwoDecimals(annualBonus/12)} \t\t\t\t PRSI: $monthlyPrsi  \t\t\t\t\t\t|")
    println ("|    \t\t\t\t\t\t\t\t Cycle To Work: $cycleToWorkMonthlyDeduction \t\t\t\t|")
    println ("|_______________________________________________________________________|")
    println ("|    Gross: $grossPay \t\t\t\tTotal Deductions: $totalDeductions \t\t\t|")
    println ("|_______________________________________________________________________|")
    println ("|   \t\t\t\t\t\t NET PAY: ${roundTwoDecimals(grossPay - totalDeductions)}  \t\t\t\t\t\t\t|")
    println ("|_______________________________________________________________________|")
}

//https://discuss.kotlinlang.org/t/how-do-you-round-a-number-to-n-decimal-places/8843
//There are several options...try each of them out
fun roundTwoDecimals(number: Double) = round(number * 100) / 100
//fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()



