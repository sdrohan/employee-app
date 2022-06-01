package ie.setu.models

import ie.setu.roundTwoDecimals

class Employee(var firstName: String, var surname: String, var gender: Char, var employeeID: Int,
               var grossSalary: Double, var payePercentage: Double, var prsiPercentage: Double,
               var annualBonus: Double, var cycleToWorkMonthlyDeduction: Double) {

    fun getFullName() = when (gender) {
        'm', 'M' -> "Mr. ${firstName} $surname}"
        'f', 'F' -> "Ms.  ${firstName} ${surname}"
        else -> "${firstName} ${surname}"
    }

    fun getMonthlySalary() = roundTwoDecimals(grossSalary / 12)
    fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (prsiPercentage / 100))
    fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (payePercentage / 100))
    fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (annualBonus / 12))
    fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkMonthlyDeduction))
    fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))

    fun getPayslip() =
        """
        ______________________________________________________________________
         Monthly Payslip:             ${getFullName()}, ID: ${employeeID}                 
        ______________________________________________________________________    
              PAYMENT DETAILS (gross pay: ${getGrossMonthlyPay()})                                                                    
        ______________________________________________________________________
                   Salary: ${getMonthlySalary()}
                   Bonus:  ${roundTwoDecimals(annualBonus / 12)}            
        ______________________________________________________________________
              DEDUCTION DETAILS (total Deductions: ${getTotalMonthlyDeductions()})      
        ______________________________________________________________________
                   PAYE: ${getMonthlyPAYE()}                
                   PRSI: ${getMonthlyPRSI()}  
                   Cycle To Work: ${cycleToWorkMonthlyDeduction}         
        ______________________________________________________________________
             NET PAY: ${getNetMonthlyPay()} 
        ______________________________________________________________________"""

    override fun toString(): String {
        return "Employee(firstName='$firstName', surname='$surname', gender=$gender, employeeID=$employeeID, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkMonthlyDeduction=$cycleToWorkMonthlyDeduction)"
    }


}