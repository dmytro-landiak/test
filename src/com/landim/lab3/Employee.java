package com.landim.lab3;

public class Employee {

    private String name;
    private String position;
    private Double salary;

    /**
     * Default Employee constructor. After instantiation all instance variables will contain default values.
     */
    public Employee() {}

    /**
     * Custom Employee constructor.
     * @param name employee's name
     * @param position employee's name
     * @param salary employee's salary
     */
    public Employee(String name, String position, Double salary) {
        setName(name);
        setPosition(position);
        setSalary(salary);
    }

    /**
     * Getter for 'name' field.
     * @return employee's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for 'name' field.
     * @param name - employee's name to be set.
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for 'position' field.
     * @return employee's position.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Setter for 'position' field.
     * @param position - employee's position to be set.
     */
    public final void setPosition(String position) {
        this.position = position;
    }

    /**
     * Getter for 'salary' field.
     * @return employee's salary.
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * Setter for 'salary' field.
     * @param salary - employee's position to be set.
     */
    public final void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * Returns formatted brief string representation of employee instance.
     * @return string representation of employee instance.
     */
    @Override
    public String toString() {
        return String.format("Employee \n{\n\tname: %s, \n\tposition: %s,\n\tsalary: %d\n}");
    }
}
