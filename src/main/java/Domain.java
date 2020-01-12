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
        address.setCity("Tomsk");
        address.setStreet("Lenina");
        address.setPostCode("634057");

        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Ivan");
        employee.setLastName("Ivanov");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1989, Calendar.MAY, 1);
        employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
        employee.setAddressId(address.getId());

        Project project = new Project();
        project.setId(1);
        project.setTitle("MegaProject");

        EmplProj emplProj = new EmplProj();
        emplProj.setEmployeeId(employee.getId());
        emplProj.setProjectId(project.getId());

        try {
            /*addressService.add(address);
            employeeService.add(employee);
            projectService.add(project);
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
            }
            List<EmplProj> emplProjList = emplProjService.getAll();
            for (EmplProj ep : emplProjList){
                System.out.println(ep);
            }*/
            projectService.getById(project.getId());
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (connection != null){
                connection.close();
            }
        }
    }
}
