package week1.employee_wage_computation.service;
import java.util.*;

import week1.employee_wage_computation.model.CompanyEmpWage;

public class EmpWageBuilder implements IEmpWageBuilder {

    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private List<CompanyEmpWage> companyEmpWageList = new ArrayList<>();
    private Map<String, CompanyEmpWage> companyMap = new HashMap<>();

    @Override
    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        CompanyEmpWage companyEmpWage =
                new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        companyEmpWageList.add(companyEmpWage);
        companyMap.put(company, companyEmpWage);
    }

    @Override
    public void computeEmpWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            companyEmpWage.setTotalEmpWage(computeEmpWage(companyEmpWage));
            System.out.println(companyEmpWage);
        }
    }

    private int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int empHrs, totalEmpHrs = 0, totalWorkingDays = 0;

        while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth &&
               totalWorkingDays < companyEmpWage.numOfWorkingDays) {

            totalWorkingDays++;

            int empCheck = (int) (Math.random() * 3);  // UC1
            switch (empCheck) {                        // UC4
                case IS_PART_TIME:
                    empHrs = 4;                        // UC3
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;                        // UC2
                    break;
                default:
                    empHrs = 0;
            }

            int dailyWage = empHrs * companyEmpWage.empRatePerHour; // UC2
            companyEmpWage.dailyWages.add(dailyWage);               // UC13
            totalEmpHrs += empHrs;
        }

        return totalEmpHrs * companyEmpWage.empRatePerHour;         // UC5, UC6
    }

    @Override
    public int getTotalWage(String company) {
        return companyMap.get(company).totalEmpWage;                // UC13
    }
}
