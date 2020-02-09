import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentManager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    Student student;

    public void readFile() {
        final String PATH = "E:\\codeGym\\testModule2\\src\\hocvien.txt";
        BufferedReader bufferedReader = null;
        String line = "";
        String splitBy = ";";
        String[] information;
        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));
            while ((line = bufferedReader.readLine()) != null) {
                information = line.split(splitBy);
                student = new Student(information[0], information[1], information[2], Integer.parseInt(information[3]));
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void displayStudentList(){
        for (Student student : students) {
            student.studentDisplay();
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

    public void displayStudentMarch() {
        for (Student student : students) {
            if (student.getMarch() > 85) {
                student.studentDisplay();
            }
        }
    }

    Pattern pattern;
    Matcher matcher;
    public void displaySurNameNguyen() {
        String regexSurNameNguyen = "^(Nguyen).*?";
        pattern = Pattern.compile(regexSurNameNguyen);
        ArrayList<Student> surNameNguyenList = new ArrayList<>();
        for(Student student : students) {
            matcher = pattern.matcher(student.getFullName());
            if (matcher.matches()){
                surNameNguyenList.add(student);
            }
        }
        if(surNameNguyenList.size() == 0){
            System.out.println("Not Found");
        }else{
            for(Student surnameNguyen : surNameNguyenList) {
                surnameNguyen.studentDisplay();
            }
        }
    }

    public void displayEmailFail() {
        final String EMAIL_REGEX ="\\D+";
        ArrayList<Student>emailFailList=new ArrayList<>();
        for(Student student : students) {
            boolean pattern = Pattern.matches(EMAIL_REGEX,student.getEmail());
            if(!pattern){
                emailFailList.add(student);
            }
        }
        if(emailFailList.size()==0) {
            System.out.println("Not Email Fail");
        }else{
            for(Student emailFail : emailFailList) {
                emailFail.studentDisplay();
            }
        }
    }

    public void sortStudentByMarch() {
        Collections.sort(students, new SortStudentByMarch());
        for(Student student : students) {
            student.studentDisplay();
        }
    }

    public void writeFileSortedMarch() {
        final String PATH = "E:\\codeGym\\testModule2\\src\\sapxepdiem.txt";
        sortStudentByMarch();
        try {
            OutputStream OutputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(OutputStream);
            for(Student student : students) {
                objectOutputStream.writeObject(student);
                objectOutputStream.flush();
            }
            objectOutputStream.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void sortStudentByName() {
        Collections.sort(students, new SortStudentByName());
        for (Student student : students) {
            student.studentDisplay();
        }
    }

    public void writeFileSortedName() {
        sortStudentByName();
        final String PATH = "E:\\codeGym\\testModule2\\src\\sapxephoten.txt";
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Student student : students) {
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
        System.out.print("Enter student's id:");
        String studentId = scanner.nextLine();

        System.out.print("Enter student's name:");
        String studentName = scanner.nextLine();

        System.out.print("Enter student's email:");
        String studentEmail = scanner.nextLine();

        System.out.print("Enter student's march:");
        int studentMarch = scanner.nextInt();
        Student newStudent = new Student(studentId, studentName, studentEmail, studentMarch);
        students.add(newStudent);
        displayStudentList();
    }

    public void updateStudentInfoById(){
        System.out.print("please enter the id: ");
        String id = scanner.nextLine();
        int isIdExist = isIdExist(id);
        if (isIdExist == -1) {
            System.out.println("No found to student id to edit");
        } else {
            System.out.println("Enter student's id again:");
            String studentId=scanner.nextLine();
            student.setId(studentId);

            System.out.println("Enter student's name again:");
            String studentName=scanner.nextLine();
            student.setFullName(studentName);

            System.out.println("Enter student's email again:");
            String studentEmail=scanner.nextLine();
            student.setEmail(studentEmail);

            System.out.println("Enter student's march  again:");
            int studentMarch=scanner.nextInt();
            student.setMarch(studentMarch);
        }
        displayStudentList();
    }

    public void deleteStudentById(){
        System.out.print("please enter the id: ");
        String id = scanner.nextLine();
        int isIdExist = isIdExist(id);
        if (isIdExist == -1) {
            System.out.println("No result!");
        } else {
            students.remove(isIdExist);
            for (Student student : students) {
                student.studentDisplay();
            }
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

    public void writeFileStudent() {
        final String PATH = "E:\\codeGym\\testModule2\\src\\hocvien.txt";
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Student student : students) {
                line = student.getId() + ";" + student.getFullName() + ";" + student.getEmail() + ";" + student.getMarch() + "\n";
                bufferedWriter.write(line);
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
