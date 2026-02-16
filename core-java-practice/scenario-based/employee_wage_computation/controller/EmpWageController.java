package week1.employee_wage_computation.controller;

import week1.employee_wage_computation.service.IEmpWageBuilder;

public class EmpWageController {
    private IEmpWageBuilder empWageBuilder;

    public EmpWageController(IEmpWageBuilder empWageBuilder) {
        this.empWageBuilder = empWageBuilder;
    }

    public void setupCompanies() {
        empWageBuilder.addCompanyEmpWage("TCS", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Infosys", 25, 22, 120);
        empWageBuilder.addCompanyEmpWage("Wipro", 22, 20, 110);
    }
    
    public void addCompany(String name, int wage, int days, int maxHrs) {
        empWageBuilder.addCompanyEmpWage(name, wage, days, maxHrs);
    }

    public void processWages() {
        empWageBuilder.computeEmpWage();
    }

    public void queryCompanyWage(String company) {
        System.out.println("Total Wage of " + company + " = " + empWageBuilder.getTotalWage(company));
    }
}
