import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager {
    public void readFile(String path, ArrayList<Student>students){
        String filepath = path;
        BufferedReader bufferedReader=null;
        String line ="";
        String splitBy=";";
        String[] information;
        try{
            bufferedReader = new BufferedReader(new FileReader(path));
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

    public void searchStudentById(ArrayList<Student>students) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.studentDisplay();
            }else {
                System.out.println("Not found");
            }
        }
    }

    public void displayStudentMarch(ArrayList<Student>students){
        for (Student student:students) {
            if (student.getMarch()>85){
                student.studentDisplay();
            }
        }
    }

    public void sortStudentByMarch(ArrayList<Student>students){
        Collections.sort(students, new SortStudentByMarch());
        for (Student student: students){
            student.studentDisplay();
        }
    }

    public void sortStudentByName(ArrayList<Student>students){
        Collections.sort(students,new SortStudentByName());
        for (Student student:students) {
            student.studentDisplay();
        }
    }

    public void writeFile(String path,ArrayList<Student>students){
        try {
            OutputStream OutputStream = new FileOutputStream(path);
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
}
