package com.bridgelabz;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;


import org.junit.jupiter.api.Test;

public class EmployeePayrollServiceTest {

    @Test

    public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {

        EmployeePayrollData[] arrayOfEmp = { new EmployeePayrollData(1, "Jeff Bezos", 100000.0),
                new EmployeePayrollData(2, "Bill Gates", 200000.0),
                new EmployeePayrollData(3, "Mark Zuckerberg", 300000.0) };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmp));

        employeePayrollService.writeEmployeeData(EmployeePayrollService.IOService.FILE_IO);


        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        assertEquals(3, entries);
    }
}
