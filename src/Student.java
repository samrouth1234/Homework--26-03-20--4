import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String Classroom;
    private float score;
    Student(){}
    Student(int id,String name,String gender,int age,String Classroom, float score){
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.Classroom=Classroom;
        this.score=score;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassroom() {
        return Classroom;
    }

    public void setClassroom(String classroom) {
        Classroom = classroom;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    void input(Scanner input){
        boolean isIDValid = false;
        do {
            String strId;
            System.out.print("Enter ID : ");
            try {
                strId = input.next();
                id = Integer.parseInt(strId);
                isIDValid = true;
            } catch (Exception ex) {
                System.out.println(" Invalid ID format!! (Integer only! )");
            }
        } while (!isIDValid);
        System.out.print("Enter Name =");
        input.nextLine();
        name=input.nextLine();
        System.out.print("Enter Gender =");
        gender=input.nextLine();
        boolean isAgeValid=false;
        do {
            String IsAge;
            System.out.print("Enter Age =");
            try{
                IsAge=input.next();
                age = Integer.parseInt(IsAge);
                isAgeValid=true;
            }catch (Exception E){
                System.out.println(" INVALID AGE FORMAT..!! (INTEGER ONLY.! )");
            }
        }while (!isAgeValid);
        System.out.print("Enter Classroom :");
        input.nextLine();
        Classroom=input.nextLine();
        boolean isScore=false;
        do{
            String strScore;
            System.out.print("Enter Score =");
            try {
                strScore=input.next();
                score=Integer.parseInt(strScore);
                isScore=true;
            }catch (Exception Ex){
                System.out.println(" INVALID SCORE FORMAT..!! (INTEGER ONLY.! )");
            }
        }while (!isScore);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", Classroom='" + Classroom + '\'' +
                ", score=" + score +
                '}';
    }

    void output(){
        System.out.println("ID = "+","+id+","+"\t"+"Name ="+","+name+","+"Gender ="+","+gender+","+"\t"+"Age ="+","+age+","+"\t"+"Room ="+","+Classroom+","+"Score ="+","+score+",");
    }
}
