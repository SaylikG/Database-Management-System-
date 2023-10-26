import java.util.*;

class Student
{
    public int Rno;
    public String Name;
    public int Age;
    public int Marks;

    public static int Generator;

    static 
    {
        Generator = 0;v
    }
  public void Display()
  {
    System.out.println(this.Rno + " " + this.Name + " " + this.Age + " "+ this.Marks );
  }
}

class DBMS
{
   public LinkedList <Student> lobj;

   public DBMS()
   {
    lobj = new LinkedList<Student>();
   }

   public void StartDBMS()
   {
     System.out.println("Started");
     System.out.println(" Schema Created");
   }

   public void InsertIntoTable(String name, int age, int marks)
   {
     Student sobj = new Student(marks, name,age,marks);
     lobj.add(sobj);
   }

   public void SelectFrom()
   {
     System.out.println("Records from Student table are");

     for(Student sref : lobj)
     {
        sref.Display();
     }
   }

    public void SelectFrom(int no)
   {
       for(Student sref : lobj)
     {
        if(sref.Rno == no)
        {
            sref.Display();
            break;
        }
     }
   }

     public void DeleteFrom(int no)
   {
     int i = 0;

     for(Student sref : lobj)
     {
       if(sref.Rno == no)
       {
         lobj.remove(i);
         break;
       }
       i++;
     }
   
   }


    public int Aggregate_Max()
   {
     int iMax = 0;
     for(Student sref : lobj)
     {
        if(sref.Marks > iMax)
        {
            iMax = sref.Marks;
        }
     }
     return iMax;
   }

   
    public int Aggregate_Min()
   {
    Student temp = lobj.get(0);
    int iMin = temp.Marks;

     for(Student sref : lobj)
     {
        if(sref.Marks < iMin)
        {
            iMin = sref.Marks;
        }
     }
     return iMin;
   }
   
   
    public int Aggregate_Sum()
   {
     int iSum = 0;
     for(Student sref : lobj)
     {
        iSum = iSum + sref.Marks;
     }
     return iSum;
   }


      public float Aggregate_Avrg()
   {
     int iSum = 0;
     for(Student sref : lobj)
     {
       iSum = iSum + sref.Marks;
     }
     return (iSum / (lobj.size()));
   }
   

}

class DBproject
{
    public static void main(String Arg[])
    {
       DBMS obj = new DBMS();
       obj.StartDBMS();

       obj.InsertIntoTable("Rahul",23, 89);
       obj.InsertIntoTable("Sagar",26, 98);
       obj.InsertIntoTable("Pooja",20, 56);   
       obj.InsertIntoTable("Sayli",30, 78);
       obj.InsertIntoTable("Tejas",29, 68);

       obj.SelectFrom();
       obj.SelectFrom(4);
       obj.SelectFrom(10);
      

       System.out.println("Maximum marks"+obj.Aggregate_Max());
       System.out.println("Minimum marks"+obj.Aggregate_Min());
       
       System.out.println("Maximum marks"+obj.Aggregate_Sum());
       System.out.println("Maximum marks"+obj.Aggregate_Avrg());

       obj.DeleteFrom(4);
       obj.SelectFrom();
       
    }
}