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
    printPayslip()
}

fun printPayslip() {

    val monthlySalary = roundTwoDecimals(grossSalary / 12)
    val monthlyPrsi = roundTwoDecimals(monthlySalary * (prsiPercentage / 100))
    val monthlyPaye = roundTwoDecimals(monthlySalary * (payePercentage / 100))
    val grossPay = roundTwoDecimals(monthlySalary + (annualBonus / 12))
    val totalDeductions = roundTwoDecimals((monthlyPrsi + monthlyPrsi + cycleToWorkMonthlyDeduction))

    println(
        """
        ______________________________________________________________________
         Monthly Payslip:             ${firstName.uppercase()} ${surname.uppercase()} (${gender.uppercase()}), ID: $employeeID                  
        ______________________________________________________________________    
              PAYMENT DETAILS (gross pay: $grossPay)                                                                    
        ______________________________________________________________________
                   Salary: $monthlySalary
                   Bonus:  ${roundTwoDecimals(annualBonus / 12)}            
        ______________________________________________________________________
              DEDUCTION DETAILS (total Deductions: $totalDeductions)      
        ______________________________________________________________________
                   PAYE: $monthlyPaye                
                   PRSI: $monthlyPrsi  
                   Cycle To Work: $cycleToWorkMonthlyDeduction         
        ______________________________________________________________________
             NET PAY: ${roundTwoDecimals(grossPay - totalDeductions)} 
        ______________________________________________________________________"""
    )
}
//https://discuss.kotlinlang.org/t/how-do-you-round-a-number-to-n-decimal-places/8843
//There are several options...try each of them out
fun roundTwoDecimals(number: Double) = round(number * 100) / 100
//fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()



