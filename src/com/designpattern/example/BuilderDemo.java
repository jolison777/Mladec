package com.designpattern.example;

class Employee
{
	private int id;
	private String name;
	private String emType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmType() {
		return emType;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", emType=" + emType + "]";
	}
	public void setEmType(String emType) {
		this.emType = emType;
	}
}
interface EmpBuilder
{
	void employeeDetails();
	void employeeType();
	Employee employeeData();
}
class ImlBuilder implements EmpBuilder
{
	private Employee emp = new Employee();
	@Override
	public void employeeDetails()
	{
		emp.setId(100);
		emp.setName("Ashwin");
	}
	@Override
	public void employeeType() {
		emp.setEmType("REGULAR");
	}
	
	@Override
	public Employee employeeData()
	{
		return emp;
	}
	public void display() {
		emp.toString();
	}
}
class BuilderTest
{
	public void employeeInfo(EmpBuilder builder)
	{
		builder.employeeDetails();
		builder.employeeType();
		builder.employeeData();
	}
}
public class BuilderDemo {
 
	public static void main(String[] args) {
		ImlBuilder empObj = new ImlBuilder();
		BuilderTest testBuild = new BuilderTest();
		testBuild.employeeInfo(empObj);
		Employee emp=empObj.employeeData();
		empObj.display();
		System.out.println(empObj.employeeData());
	}
 
}
 
 //no completed
 