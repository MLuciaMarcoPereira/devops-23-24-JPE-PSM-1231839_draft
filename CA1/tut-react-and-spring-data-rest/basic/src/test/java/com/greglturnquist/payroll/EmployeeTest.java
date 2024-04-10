package com.greglturnquist.payroll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    String firstName = "Frodo";
    String lastName = "Baggins";
    String description = "a hobbit from the Shire";
    String jobTitle = "ring bearer";
    int jobYears = 0;
    String email = "frodo.baggins@middleearth.com";

    @BeforeEach
    void setUp() throws InstantiationException {
        Employee employee = new Employee(firstName, lastName, description, jobTitle, jobYears, email);
    }

    @Test
    void testEquality() throws InstantiationException {
        Employee employee1 = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        Employee employee2 = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");

        assertEquals(employee1, employee2);
    }

    @Test
    void testInequality() throws InstantiationException {
        Employee employee1 = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        Employee employee2 = new Employee("Samwise", "Gamgee", "a hobbit from the Shire", "gardener", 0, "samwise.gamgee@middleearth.com");

        assertNotEquals(employee1, employee2);
    }

    @Test
    void testToString() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");

        assertEquals("Employee{id=null, firstName='Frodo', lastName='Baggins', description='a hobbit from the Shire', jobTitle='ring bearer', jobYears=0, email='frodo.baggins@middleearth.com'}", employee.toString());
    }

    @Test
    void testSetFirstName() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        employee.setFirstName("Samwise");

        assertEquals("Samwise", employee.getFirstName());
    }

    @Test
    void testSetLastName() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        employee.setLastName("Gamgee");

        assertEquals("Gamgee", employee.getLastName());
    }

    @Test
    void testSetDescription() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        employee.setDescription("a hobbit from the Shire");

        assertEquals("a hobbit from the Shire", employee.getDescription());
    }

    @Test
    void testSetJobTitle() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        employee.setJobTitle("gardener");

        assertEquals("gardener", employee.getJobTitle());
    }

    @Test
    void testSetJobYears() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        employee.setJobYears(1);
    }

    @Test
    void testSetEmail() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        employee.setEmail("frodo.baggins2@middleearth.com");
    }

    @Test
    void testSetFirstNameNullShouldThrowException() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        assertThrows(IllegalArgumentException.class, () -> employee.setFirstName(null));
    }

    @Test
    void testSetLastNameNullShouldThrowException() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        assertThrows(IllegalArgumentException.class, () -> employee.setLastName(null));
    }

    @Test
    void testSetDescriptionNullShouldThrowException() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        assertThrows(IllegalArgumentException.class, () -> employee.setDescription(null));
    }

    @Test
    void testSetJobTitleNullShouldThrowException() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        assertThrows(IllegalArgumentException.class, () -> employee.setJobTitle(null));
    }

    @Test
    void testSetJobYearsNegativeShouldThrowException() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        assertThrows(IllegalArgumentException.class, () -> employee.setJobYears(-1));
    }

    @Test
    void testSetEmailNullShouldThrowException() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        assertThrows(IllegalArgumentException.class, () -> employee.setEmail(null));
    }

    @Test
    void testSetEmailEmptyShouldThrowException() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        assertThrows(IllegalArgumentException.class, () -> employee.setEmail(""));
    }

    @Test
    void testSetEmailInvalidEmailShouldThrowException() throws InstantiationException {
        Employee employee = new Employee("Frodo", "Baggins", "a hobbit from the Shire", "ring bearer", 0, "frodo.baggins@middleearth.com");
        assertThrows(IllegalArgumentException.class, () -> employee.setEmail("invalid.email"));
    }
}