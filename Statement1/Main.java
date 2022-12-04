import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        StudentData studentData = new StudentData(50);
        
        int opt=0;

        while(opt!=1){
            System.out.println("Select option of action you want to perform: ");
            System.out.print("1. Exit\t2. Enroll Student\t3. Remove Student\t4. Update Student\t5. Display Database\t6. Display Selected Student");
            
            switch (opt) {
                case 2:
                    studentData.EnrollStudent();
                    break;
                
                case 3:
                    studentData.RemoveStudent();

                case 4:
                    studentData.UpdateStudent();

                case 5:
                    studentData.DisplayStudentData();

                case 6: 
                    studentData.DisplaySelectedStudent();
                default:
                    break;
            }

        }
    
    }
}

class StudentData{
    int size;
    int counter = 0;
    Student [] studentArr;
    Scanner sc = new Scanner(System.in);

    StudentData(int size){
        this.size = size;
        studentArr = new Student[size];
    }

    public void EnrollStudent(){
        System.out.print("Enter Student name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student branch: ");
        String branch = sc.nextLine();

        studentArr[counter] = new Student(name, branch);
        counter++;
    }


    public void RemoveStudent(){
        System.out.print("Enter name of student you want to remove:");
        String name = sc.nextLine();
        for (int i = 0; i < studentArr.length; i++) {
            if(studentArr[i].name == name){
                studentArr[i] = null;
                break;
            }
        }
    }

    public void UpdateStudent(){
        System.out.print("Enter name of student you want to update details about:");
        String name = sc.nextLine();
        System.out.print("Enter new Student name: ");
        String newName = sc.nextLine();
        System.out.print("Enter new Student branch: ");
        String newBranch = sc.nextLine();
        
        for (int i = 0; i < studentArr.length; i++) {
            if (studentArr[i]!=null&&studentArr[i].name == name) {
                studentArr[i] = new Student(newName, newBranch);
                break;
            }
        }
    }

    public void DisplayStudentData(){
        System.out.println("-----------Student Details----------");
        for (int i = 0; i < studentArr.length; i++) {
            if (studentArr[i]!=null) {
                studentArr[i].DisplayStudent();
                System.out.println("\n");
            }
        }
    }

    public void DisplaySelectedStudent(){
        System.out.print("Enter name of Student you want to display");
        String name = sc.nextLine();
        for (int i = 0; i < studentArr.length; i++) {
            if (studentArr[i]!=null && studentArr[i].name == name) {
                studentArr[i].DisplayStudent();
                break;
            }
        }
    }


}

class Student{
    String name;
    String branch;

    Student(String name,String branch){
        this.name = name;
        this.branch = branch;
    }

    public void DisplayStudent(){
        System.out.println("Name: "+ name);
        System.out.println("Branch: "+ branch);
    }
}
