package week1.employee_wage_computation.service;
public interface IEmpWageBuilder {
    void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);
    void computeEmpWage();
    int getTotalWage(String company);
}
