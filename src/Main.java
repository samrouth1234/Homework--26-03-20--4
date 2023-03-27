import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static void pressKey(){
        Scanner add=new Scanner(System.in);
        System.out.println("Press to continue ...");
        add.nextLine();
    }
    public static void main(String[] args) {
        ArrayList<Student>students=new ArrayList<>();
        int option=0;
        Scanner scanners=new Scanner(System.in);
        do {
            System.out.println("=========================Student Management System=========================");
            System.out.println("1.Insert Student to System");
            System.out.println("2.Edit Student to System");
            System.out.println("3.Search Student to System");
            System.out.println("4.Delete Student to System");
            System.out.println("5.Show Student to System");
            System.out.println("6.Exit :");
            String strOption;
            System.out.print(">>>> Choose your option from 1-6 :");
            strOption = scanners.nextLine();
            try {
                option = Integer.parseInt(strOption);
            } catch (Exception ex) {
                // Meaning program access form default
                option = 0;
                System.out.println("ERROR!!! INVALID INPUT ..! TRY AGAIN ");
            }
            switch (option){
                case 1:
                    System.out.println("=================================Insert Student to System=================================");
                    Student newStudent=new Student();
                    newStudent.input(scanners);
                    students.add(newStudent);
                    System.out.println("Successfully add Student to System.......!");
                    scanners.nextLine();
                    break;
                case 2:
                    System.out.println("=================================Edit Student to System=================================");
                    System.out.println("********************************** Update Student **********************************");
                    int idUpdate;
                    boolean idUpdates=false;
                    System.out.println("Enter ID to Update :");
                    idUpdate=scanners.nextInt();
                    for(int i=0;i< students.size();i++){
                        if(idUpdate==students.get(i).getId()){
                            idUpdates=true;
                            students.get(i).input(scanners);
                        }
                    }
                    if(!idUpdates){
                        System.out.println("Enter not right Try again..!");
                    }
                    scanners.nextLine();
                    break;
                case 3:
                    System.out.println("=================================Search Student to System=================================");
                    int searchOption;
                    System.out.println("1.Search By ID ");
                    System.out.println("2.Search By Name");
                    System.out.println("3.Search By Gender");
                    System.out.println("4.Search By ClassName");
                    System.out.println("5.Exit");
                    System.out.print("Choose option 1->5 :");
                    searchOption=scanners.nextInt();
                    scanners.nextLine();
                    switch (searchOption){
                        case 1:
                            System.out.println("***************************** Search By ID *****************************");
                            int searchID;
                            boolean isIDValidSearch = false;
                            do {
                                String searchMyid;
                                System.out.print("Enter ID to Search :");
                                try {
                                    searchMyid = scanners.next();
                                    searchID = Integer.parseInt(searchMyid);
                                    isIDValidSearch = true;
                                    for(int i=0;i< students.size();i++){
                                        if(searchID==students.get(i).getId()){
                                            isIDValidSearch=true;
                                            students.get(i).output();
                                        }
                                    }
                                    if(!isIDValidSearch){
                                        System.out.println("Student with ="+searchID+"don't exist..!!!");
                                    }
                                } catch (Exception ex) {
                                    System.out.println(" INVALID ID SEARCH..!! (Integer only! )");
                                }
                            } while (!isIDValidSearch);
                            break;
                        case 2:
                            boolean isCheckname=false;
                            System.out.println("***************************** Search By Name *****************************");
                            System.out.print("Enter Name to Search :");
                            String searchName=scanners.nextLine();
                            for (int i=0;i< students.size();i++){
                                if(students.get(i).getName().equalsIgnoreCase(searchName)){
                                    System.out.println(students.get(i));
                                    isCheckname=true;
                                }
                            }
                            if(!isCheckname) System.out.println("search Name not found....!");
                            break;
                        case 3:
                            System.out.println("***************************** Search By Gender *****************************");
                            boolean isCheckGender=false;
                            System.out.print("Enter Name to Search :");
                            String searchGender=scanners.nextLine();
                            for(int i=0;i<students.size();i++){
                                if(students.get(i).getGender().equalsIgnoreCase(searchGender)){
                                    System.out.println(students.get(i));
                                    isCheckGender=true;
                                }
                            }
                            if (!isCheckGender){
                                System.out.println("Search Gender not found....!");
                            }
                            break;
                        case 4:
                            System.out.println("***************************** Search By Classroom *****************************");
                            boolean isCheckClassroom=false;
                            System.out.print("Enter Classroom :");
                            String searchClassroom=scanners.nextLine();
                            for (int i=0;i<students.size();i++){
                                if (students.get(i).getClassroom().equalsIgnoreCase(searchClassroom)){
                                    System.out.println(students.get(i));
                                    isCheckClassroom=true;
                                }
                            }
                            if(isCheckClassroom){
                                System.out.println("Search Classroom not found....!");
                            }
                            break;
                        case 5:
                            System.out.println("Exit .!");
                            break;
                    }
                    scanners.nextLine();
                    break;
                case 4:
                    System.out.println("=================================Delete Student to System=================================");
                    int idDelete;
                    boolean isCheckDelete=false;
                    System.out.print("Enter ID to Delete =");
                    idDelete=scanners.nextInt();
                    for(int i=0;i< students.size();i++){
                        if(idDelete==students.get(i).getId()){
                            students.remove(i);
                            isCheckDelete=true;
                        }
                    }
                    System.out.println("Delete element :"+idDelete+" is Successfully");
                    if (!isCheckDelete){
                        System.out.println("Delete wrong element....!");
                    }
                    pressKey();
                    scanners.nextLine();
                    break;
                case 5:
                    System.out.println("=================================Show Student to System=================================");
                    /*
                    for(int i=0;i< students.size();i++){
                        students.get(i).output();
                    }
                     */
                    for (Student student : students) {
                        student.output();
                    }
                    System.out.println("------------------------------------Press Enter to Continue--------------------------------------------");
                    break;
                case 6:
                    System.out.println("Exit ");
                    break;
                default:
                    System.out.println("Wrong Choose option ..");
                    break;
            }
        }while (option!=6);
    }
}