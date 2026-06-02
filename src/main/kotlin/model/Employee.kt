package model

data class Employee (
    var employeeId: Int,
    var firstName: String,
    var surname: String,
    var department: String,
    var jobTitle: String,
    var hourlyRate: Double,
    var hoursWorked: Int,
    var overtimeHoursWorked: Int,
    var bonusPercentage: Double,
    var taxRatePercentage: Double,
    var pensionContributionPercentage: Double){

    override fun toString(): String {
        return "[Employee] id=$employeeId | name=$firstName $surname | dept=$department | job=$jobTitle | rate=€$hourlyRate | hours=$hoursWorked | overtime=$overtimeHoursWorked | bonus=$bonusPercentage% | tax=$taxRatePercentage% | pension=$pensionContributionPercentage%"
    }
}