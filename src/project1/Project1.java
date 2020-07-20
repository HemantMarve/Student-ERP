/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import java.sql.*;
import java.util.Comparator;

/**
 *
 * @author HEMANT MARVE
 */
class MyComparator implements Comparator
{
public int compare(Object obj1,Object obj2)
{
    Details d1=(Details)obj1;
    Details d2=(Details)obj2;
    if(Integer.parseInt(d1.roll)<Integer.parseInt(d2.roll))
        return -1;
    else if(Integer.parseInt(d1.roll)>Integer.parseInt(d2.roll))
        return +1;
    else
        return 0;
}


}
class MyComparator1 implements Comparator
{
public int compare(Object obj1,Object obj2)
{
    Details d1=(Details)obj1;
    Details d2=(Details)obj2;
    if(d1.attendance>d2.attendance)
        return -1;
    else if(d1.attendance<d2.attendance)
        return +1;
    else
        return -1;
}
}
class MyComparator3 implements Comparator
{
public int compare(Object obj1,Object obj2)
{
    Details d1=(Details)obj1;
    Details d2=(Details)obj2;
    if(d1.p>d2.p)
        return -1;
    else if(d1.p<d2.p)
        return +1;
    
   
    else
   
    return -1;
    
    }
    
}

class MyComparator4 implements Comparator
{
public int compare(Object obj1,Object obj2)
{
    Details d1=(Details)obj1;
    Details d2=(Details)obj2;
    if(Integer.parseInt(d1.dues)>Integer.parseInt(d2.dues))
        return -1;
    else if(Integer.parseInt(d1.dues)<Integer.parseInt(d2.dues))
        return +1;
    else
        return -1;
}
}

class Details
{
double attendance,p;
String name,mobile,roll,dues;
int s1,s2,s3,s4,t;
void Roll_No(String y)
{
roll=y;
}
Details()
{
}
Details(double a,String n,String m,String r,String d)
{

attendance=a;
name=n;
mobile=m;
roll=r;
dues=d;
}
void Detail(int a,int b,int c,int d,int e,double f)
{
    s1=a;
    s2=b;
    s3=c;
    s4=d;
    t=e;
    p=f;


}

    void DetailMarks(double a,String n,String m,String r,String d) {
        attendance=a;
        name=n;
        mobile=m;
        roll=r;
        dues=d;
         }
}
public class Project1 {
static Connection con;
 
      static   String dbUrl;
    public static int insert(NewJFrame f)
    {
       
        try
        {
            PreparedStatement    stmt = con.prepareStatement("insert into Details(Roll,Name,Mobile,Attendance,Dues)values(?,?,?,?,?)");
               stmt.setString(1,f.r);
                stmt.setString(2,f.n);
                stmt.setString(3,f.m);
                stmt.setDouble(4,f.a);
                stmt.setString(5,"0");
              stmt.executeUpdate();
              PreparedStatement    stmt1 = con.prepareStatement("insert into Security(Roll,PASSWORD)values(?,?)");
             stmt1.setString(1,f.r);
             stmt1.setString(2,"1234");
              stmt1.executeUpdate();
              return 0;
        }
        catch(SQLException e)
        {
        
        
        }
    return 1;
    }
    
   
    public static void main(String[] args)
    {
    //dbUrl =System.getProperty("user.dir");
      dbUrl = "//localhost:1527";
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
       con=DriverManager.getConnection("jdbc:derby:"+dbUrl+"/student", "hemantmarve", "keyboarde123");
       System.out.println("Statement object created");
             
           
       
       
               }
    catch(ClassNotFoundException ex)
    {
        System.out.println("unable to load database DRIVERS"+ex);
    }
    catch(SQLException ex)
    {
       System.out.println("Some ERROR related to db"+ex);
       }

        
        Project1 obj1=new Project1();
        NewJFrame frame=new NewJFrame();
        frame.setVisible(true);
       
    }
    
}
