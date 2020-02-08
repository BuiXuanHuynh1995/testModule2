import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentManager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student>students=new ArrayList<>();
    public void readFile(){
        final String PATH ="E:\\codeGym\\testModule2\\src\\hocvien.txt";
        BufferedReader bufferedReader=null;
        String line ="";
        String splitBy=";";
        String[] information;
        try{
            bufferedReader = new BufferedReader(new FileReader(PATH));
            while ((line=bufferedReader.readLine())!=null){
                information=line.split(splitBy);
                Student student = new Student(information[0],information[1],information[2],Integer.parseInt(information[3]));
                students.add(student);
            }
            for (Student student:students) {
                student.studentDisplay();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void searchStudentById() {
        System.out.print("please enter the id: ");
        String keyid = scanner.nextLine();
        int isIdExist = isIdExist(keyid);
        if (isIdExist == -1) {
            System.out.println("No result!");
           searchStudentById();
        } else {
            students.get(isIdExist).studentDisplay();
        }
    }

    public void displayStudentMarch(){
        for (Student student:students) {
            if (student.getMarch()>85){
                student.studentDisplay();
            }
        }
    }

    public void displaySurNameNguyen(){
        String regex = "^(Nguyen)(.*?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        ArrayList<Student>surNameNguyenList=new ArrayList<>();
        for (Student student:students) {
            matcher=pattern.matcher(student.getFullName());
            if (matcher.matches()){
                surNameNguyenList.add(student);
            }
        }
        if (surNameNguyenList.size()==0){
            System.out.println("Not Found");
        }else {
            for (Student nameNguyen:surNameNguyenList) {
                nameNguyen.studentDisplay();
            }
        }
    }
    
    public void displayEmailFail(){
        final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern pattern =Pattern.compile(EMAIL_REGEX);
        Matcher matcher;
        ArrayList<Student>emailFailList=new ArrayList<>();
        for (Student student:students) {
            matcher=pattern.matcher(student.getEmail());
            if (!matcher.matches()){
                emailFailList.add(student);
            }
        }
        if (emailFailList.size()==0){
            System.out.println("Not Email Fail");
        }else {
            for (Student emailFail:emailFailList) {
                emailFail.studentDisplay();
            }
        }
    }

    public void sortStudentByMarch(){
        Collections.sort(students, new SortStudentByMarch());
        for (Student student: students){
            student.studentDisplay();
        }
    }

    public void writeFileSortedMarch(){
        final String PATH ="E:\\codeGym\\testModule2\\src\\sapxepdiem.txt";
        sortStudentByMarch();
        try {
            OutputStream OutputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(OutputStream);
            for (Student student:students) {
                objectOutputStream.writeObject(student);
                objectOutputStream.flush();
            }
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortStudentByName(){
        Collections.sort(students,new SortStudentByName());
        for (Student student:students) {
            student.studentDisplay();
        }
    }

    public void writeFileSortedName(){
        sortStudentByName();
        final String PATH ="E:\\codeGym\\testModule2\\src\\sapxephoten.txt";
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Student student:students) {
                line = student.getId() + "; " + student.getFullName() + "; " + student.getEmail() + ";" + student.getMarch() + "\n";
                bufferedWriter.write(line);
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent() {
        System.out.print("Enter id:");
        String id = scanner.nextLine();

        System.out.print("Enter name:");
        String name = scanner.nextLine();

        System.out.print("Enter email:");
        String email = scanner.nextLine();

        System.out.print("Enter score:");
        int march = scanner.nextInt();
        Student newStudent = new Student(id, name, email, march);
        students.add(newStudent);
        for (Student student:students) {
            student.studentDisplay();
        }
    }

    public int isIdExist(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                return 1;
            }
        }
        return -1;
    }
}
