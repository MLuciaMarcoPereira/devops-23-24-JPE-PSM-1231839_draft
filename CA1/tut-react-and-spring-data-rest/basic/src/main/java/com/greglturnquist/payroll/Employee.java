/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import java.util.Objects;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Entity // <1>
public class Employee {

    private @Id
    @GeneratedValue Long id; // <2>
    private String firstName;
    private String lastName;
    private String description;
    private String jobTitle;
    private int jobYears;
    private String email;

    private Employee() {
    }

    public Employee(String firstName, String lastName, String description, String jobTitle, int jobYears, String email) throws InstantiationException {
        if (firstName == null || lastName == null || description == null || email == null || jobYears < 0 || firstName.isEmpty() || lastName.isEmpty() || description.isEmpty())
            throw new InstantiationException("Please enter a valid first name, last name, description and job years.");
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.jobTitle = jobTitle;
        this.jobYears = jobYears;
        if (!isValidEmail(email)) {
            throw new InstantiationException("Please enter a valid email address.");
        }
        this.email = email;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pattern.matcher(email).matches();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(description, employee.description) &&
                Objects.equals(jobTitle, employee.jobTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, description);
    }

    public Long getId() {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id must not be null or negative");
        }
        return id;
    }

    public void setId(Long id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id must not be null or negative");
        }
        this.id = id;
    }

    public String getFirstName() {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name must not be empty");
        }
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name must not be empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name must not be empty");
        }
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name must not be empty");
        }
        this.lastName = lastName;
    }

    public String getDescription() {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description must not be empty");
        }
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description must not be empty");
        }
        this.description = description;
    }

    public String getJobTitle() {
        if (jobTitle == null || jobTitle.isEmpty()) {
            throw new IllegalArgumentException("Job title must not be empty");
        }
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        if (jobTitle == null || jobTitle.isEmpty()) {
            throw new IllegalArgumentException("Job title must not be empty");
        }
        this.jobTitle = jobTitle;
    }

    public int getJobYears() {
        if (jobYears < 0) {
            throw new IllegalArgumentException("Job years must not be negative");
        }
        return jobYears;
    }

    public void setJobYears(int jobYears) {
        if (jobYears < 0) {
            throw new IllegalArgumentException("Job years must not be negative");
        }
        this.jobYears = jobYears;
    }

    public String getEmail() {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email must not be empty");
        }
        return email;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email must be valid");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobYears=" + jobYears +
                ", email='" + email + '\'' +
                '}';
    }
}
// end::code[]
