package CS489.lab1b.employeePensionPlanningSystemCLIApp;

import CS489.lab1b.employeePensionPlanningSystemCLIApp.PensionPlan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Comparator<Employee> {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan;

    @Override
    public int compare(Employee e1, Employee e2) {
        if(e1.getLastName().compareTo(e2.getLastName())<0){
            return -1;
        }else if(e1.getLastName().compareTo(e2.getLastName())>0){
            return 1;
        }else{
            return e1.getYearlySalary() < e2.getYearlySalary() ? -1 : (e1.getYearlySalary() > e2.getYearlySalary() ? 1 : 0);

        }

    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50, null));
        employees.add(new Employee(2, "Bernard", "Shaw", LocalDate.of(2018, 10, 3), 197750.00, null));
        employees.add(new Employee(3, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75,
                new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.50)));
        employees.add(new Employee(4, "Wesley", "Schneider", LocalDate.of(2018, 11, 2), 74500.00, null));

        Collections.sort(employees, new Employee());
        employees.forEach(System.out::println);

        System.out.println("\n Monthly Upcoming Enrollees");
        employees.stream()
                .filter(e -> e.getPensionPlan() == null && e.getEmploymentDate().plusYears(5).isBefore(LocalDate.now()))
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .forEach(System.out::println);
    }}