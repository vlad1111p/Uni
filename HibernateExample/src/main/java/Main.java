import model.Account;
import model.Card;
import model.Employee;
import model.Project;
import services.AccountService;
import services.CardService;
import services.EmployeeService;
import services.ProjectService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProjectService projectService = new ProjectService();
        AccountService accountService = new AccountService();
        EmployeeService employeeService = new EmployeeService();
        CardService cardService = new CardService();


        Employee employee = new Employee();
        employee.setFirstName("Maria");
        employee.setLastName("Popescu");
        employeeService.addEmployee(employee);

        Employee employee2 = new Employee();
        employee2.setFirstName("Elena");
        employee2.setLastName("Ionescu");
        employeeService.addEmployee(employee2);

        List<Employee> employeesList = new ArrayList();
        employeesList.add(employee);
        employeesList.add(employee2);

        Project project = new Project();
        project.setName("Project1");
        project.setDescription("Description");
        project.setStartDate(java.sql.Date.valueOf("2020-01-02"));
        project.setEndDate(java.sql.Date.valueOf("2020-07-09"));
        project.setEmployeesList(employeesList);
        projectService.addProject(project);

        Card card1 = new Card();
        Card card2 = new Card();
        cardService.addCard(card1);
        cardService.addCard(card2);
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);

        Account account = new Account();
        account.setBankName("BCR");
        account.setEmployee(employee);
        account.setCards(cards);
        accountService.addAccount(account);


        employeeService.deleteEmployee(employee);

    }
}
