import java.util.ArrayList;
import java.util.List;

public abstract class Employee {

    private String Name;
    private int Id;
    private long contactnum;

   public  Employee(String Name,int Id,long contactnum)
    {
        this.Name=Name;
        this.Id=Id;
        this.contactnum=contactnum;
    }

    public String getName()
    {
        return Name;

    }

    public int getID()
    {
        return Id;

    }


    public long contactnum() {
        return contactnum;
    }

    @Override
    public String toString() {
        return "Employee Detail:---------------------"+ '\n'
                +"Name : "+Name+'\n'
                +"Id : "+Id+'\n'
                +"Contact Number : "+contactnum+'\n'
                +"Salary : "+calculateSalary()+'\n';
    }

    public abstract double calculateSalary();
}

class FullTimeEmployee extends Employee{

    private double MonthSalary;

    public FullTimeEmployee(String Name,int Id, double MonthSalary,long contactnum)
    {
        super(Name,Id,contactnum);
        this.MonthSalary=MonthSalary;
    }

    public double getMonthSalary()
    {
        return MonthSalary;
    }

    @Override
    public double calculateSalary()
    {
        return MonthSalary;
    }

}

class partTimeEmployee extends Employee{

    private double hoursWork;

    private double hoursRate;

   public partTimeEmployee(String Name,int Id,double hoursWork,double hoursRate,long contactnum)
    {
        super(Name,Id,contactnum);
        this.hoursWork=hoursWork;
        this.hoursRate=hoursRate;
    }

    @Override
    public double calculateSalary() {
        return (int)hoursRate*hoursWork;
    }

}

class payRollSystem{
    private List<Employee> employeelist;

    public payRollSystem()
    {
        employeelist = new ArrayList<>();
    }

    public void addEmployee(Employee emp)
    {
        employeelist.add(emp);
    }

    public void removeEmployee(int Id)
    {
        Employee EmployeeToRemove =null;
        for(Employee xemployee:employeelist)
        {
            if(xemployee.getID()==Id)
            {
                EmployeeToRemove=xemployee;
                break;
            }
        }

        if (EmployeeToRemove != null)
        {
            employeelist.remove(EmployeeToRemove);
        }

    }

    public void displayEmployess()
    {
        for (Employee e:employeelist)
        {
            System.out.println(e);
        }
    }

}


class main{
    public static void main(String[] args) {
        payRollSystem obj=new payRollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("krish",101,100000.00, 997346844);
        obj.addEmployee(emp1);
        partTimeEmployee emp2=new partTimeEmployee("priya", 102, 10, 50, 997433131);
        obj.addEmployee(emp2);

//        obj.displayEmployess();

        obj.removeEmployee(101);
        obj.displayEmployess();
    }
}
