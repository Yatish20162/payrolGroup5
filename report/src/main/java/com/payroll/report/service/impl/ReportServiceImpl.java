package com.payroll.report.service.impl;

import com.payroll.report.dto.*;
import com.payroll.report.entity.Salary;
import com.payroll.report.exception.ResourceNotFoundException;
import com.payroll.report.mapper.SalaryMapper;
import com.payroll.report.repository.ReportRepository;
import com.payroll.report.repository.SalaryRepository;
import com.payroll.report.service.IReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ReportServiceImpl implements IReportService {

    private final SalaryRepository salaryRepository;
    private final ReportRepository reportRepository;


    @Override
    public boolean deleteAccount(Long employeeId) {

        boolean isDeleted = false;

        Salary salary = salaryRepository.findByEmployeeId(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Salary", "employeeId", employeeId)
        );
        if (salary != null) {
            salaryRepository.delete(salary);
            isDeleted = true;
        }

        return isDeleted;
    }

    @Override
    public boolean updateSalary(SalaryDto salaryDto) {
        boolean isUpdated = false;

        Salary salary = salaryRepository.findByEmployeeId(salaryDto.getEmployeeId()).orElseThrow(
                () -> new ResourceNotFoundException("salary", "employee", salaryDto.getEmployeeId())
        );

        if(salary != null){
            Salary updatedSalary = SalaryMapper.mapToSalary(salaryDto, salary);
            salaryRepository.save(updatedSalary);

            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean createReport(ReportDto reportDto) {
        boolean isCreated = false;
        System.out.println("Creating report for: " + reportDto.getEmployeeName() +
                ", Start Date: " + reportDto.getStartDate() +
                ", End Date: " + reportDto.getEndDate());

        Salary salary = salaryRepository.findByEmployeeId(reportDto.getEmployeeId()).orElseThrow(
                () -> new ResourceNotFoundException("salary", "employee", reportDto.getEmployeeId())

        );

        if(salary != null){
//            To-do -> make the cal for the get_deductions and there ask us for the Lwp's(send Eid , startDate , EndDate)
//            Generate Report Here
            isCreated = true;

        }
        return isCreated;
    }
}