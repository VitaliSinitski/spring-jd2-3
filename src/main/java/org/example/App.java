package org.example;

import org.example.employee.Department;
import org.example.employee.Employee;
import org.example.employee.EmployeeDetails;
import org.example.employee.Meeting;
import org.example.people.Car;
import org.example.people.Description;
import org.example.people.Home;
import org.example.people.People;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.getEntityManager();

/*        Department department = new Department("Department");

        EmployeeDetails employeeDetails = new EmployeeDetails(null, "City",
                "Country", "State", "Street", null);
        Meeting meeting = new Meeting("FirstMeeting", null);
        Set<Meeting> set = new HashSet<>();
        set.add(meeting);
        Employee employee = new Employee("First Name", "Last Name",
                "Cell Phone", employeeDetails, department, set);
        Set<Employee> setEmployee = new HashSet<>();
        setEmployee.add(employee);
        meeting.setEmployees(setEmployee);
        employeeDetails.setEmployee(employee);
        em.getTransaction().begin();
        em.persist(employeeDetails);
        em.getTransaction().commit();*/
        //System.out.println(meeting);
/*        EntityManager em = HibernateUtil.getEntityManager();
        Set<Car> cars = new HashSet<>();
        Car car = new Car();
        car.setName("Kia");
        car.setType("Ceed");
        cars.add(car);
        Description description = new Description();
        description.setDescription("description");
        Home home = new Home();
        home.setAddress("Street");
        home.setDescription(description);
        description.setHome(home);
        People people = new People();
        people.setName("Maks");
        people.setAge(19);
        people.setHome(home);
        people.setCars(cars);
        Set<People> peoples = new HashSet<>();
        peoples.add(people);
        car.setPeoples(peoples);
        home.setPeople(peoples);
        em.getTransaction().begin();
        em.persist(people);
        em.getTransaction().commit();*/


        //simpleQuery(em);
        orderQuery(em);

        HibernateUtil.close();
    }

    private static void simpleQuery(EntityManager em) {
/*
        Query query = em.createQuery(
                "from Employee emp where emp.firstName = :name"
        );
        query.setParameter("name", "First name")
                .getResultList().forEach(System.out::println);
*/


        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);

        Root<Employee> emp = criteria.from(Employee.class);
        criteria.select(emp)
                .where(cb.equal(emp.get("firstName"), "First Name"));

        List<Employee> employees = em.createQuery(criteria).getResultList();
        employees.forEach(System.out::println);
    }

    private static void orderQuery(EntityManager em) {
        Query query = em.createQuery(
                "from Employee emp where emp.firstName like :name order by emp.firstName desc"
        );
        query.setParameter("name", "First%")
                .getResultList().forEach(System.out::println);


        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);

        Root<Employee> emp = criteria.from(Employee.class);
//        emp.fetch("employeeDetails");

        Expression<String> cellPhone = emp.get("cellPhone");

        List<Predicate> predicates = new ArrayList<>();

        Predicate or = cb.or(cellPhone.in("Cell Phone1", "Cell Phone2", "Cell Phone3"),
                cb.equal(emp.get("lastName"), "Last Name9"));
        Predicate firstName = cb.like(emp.get("firstName"), "First%");

        Optional.ofNullable(or)
                .ifPresent(predicates::add);
        Optional.ofNullable(firstName)
                .ifPresent(predicates::add);

        Predicate predicate = cb.and(
                predicates.toArray(new Predicate[predicates.size()]));

        criteria.select(emp).where(predicate)
                .orderBy(cb.desc(emp.get("firstName")));


        int pageSize = 4;
        int pageNumber = 1;

        TypedQuery<Employee> typedQuery = em.createQuery(criteria);
        typedQuery.setFirstResult(pageSize * (pageNumber - 1));
        typedQuery.setMaxResults(pageSize);
        System.out.println();
        List<Employee> employees = typedQuery.getResultList();

        employees.forEach(System.out::println);
    }

}
