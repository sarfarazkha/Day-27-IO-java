package com.bridgelabz;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeePayrollServiceTest {

    @Test
    public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {

        EmployeePayrollData[] arrayOfEmp = {new EmployeePayrollData(1, "mukesh ambani", 100000.0),
                new EmployeePayrollData(2, "anand mahindra", 400000.0),
                new EmployeePayrollData(3, "radhakrishnan damani", 600000.0)};
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmp));

        employeePayrollService.writeEmployeeData(EmployeePayrollService.IOService.FILE_IO);

        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        assertEquals(3, entries);
    }
}
