import bl.Util;
import entity.Address;
import entity.EmplProj;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmplProjService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class Domain {
    public static void main(String[] args) throws SQLException {
        Util util = new Util();
       Connection connection = util.getConnection();
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();
        EmplProjService emplProjService = new EmplProjService();

        Address address = new Address();
        address.setId(1);
        address.setCountry("Russia");
        address.setCity("Novosibirsk");
        address.setStreet("Petuhova");
        address.setPostCode("656743");

        Employee employee = new Employee();
        employee.setId(2);
        employee.setFirstName("Petr");
        employee.setLastName("Petrov");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1976, Calendar.APRIL, 22);
        employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
        employee.setAddressId(address.getId());

        Project project = new Project();
        project.setId(1);
        project.setTitle("MegaSegaDriveProject");

        EmplProj emplProj = new EmplProj();
        emplProj.setEmployeeId(employee.getId());
        emplProj.setProjectId(project.getId());

        try {
          //  addressService.add(address);
           // employeeService.add(employee);
           /* projectService.add(project);
            emplProjService.add(emplProj);
            List<Address> list = addressService.getAll();
            for (Address a : list){
                System.out.println(a);
            }
            List<Employee> employeeList = employeeService.getAll();
            for (Employee e : employeeList){
                System.out.println(e);
            }
            List<Project> projectList = projectService.getAll();
            for (Project p : projectList){
                System.out.println(p);
            }*/

           /* List<EmplProj> emplProjList = emplProjService.getAll();
            for (EmplProj ep : emplProjList){
                System.out.println(ep);
            }*/
          /* Address a = addressService.getById(address.getId());
            System.out.println(a);*/
         /*   Employee e = employeeService.getById(employee.getId());
            System.out.println(e);
           Project p = projectService.getById(project.getId());
            System.out.println(p);
            EmplProj ep = emplProjService.getByEmpployeeIdAndProjectId(employee.getId(), project.getId());
            System.out.println(ep);*/
         /*   addressService.update(address);
            employeeService.update(employee);
            emplProjService.update(emplProj);
            projectService.update(project);*/
            projectService.remove(project);
           //employeeService.remove(employee); //not work
        // addressService.remove(address); // not work

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
