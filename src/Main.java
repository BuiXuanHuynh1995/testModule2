import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Read File.");
        System.out.println("2. Search student");
        System.out.println("3. Display student march>85");
        System.out.println("4. Sort student by march");
        System.out.println("5. Sort student by name");
        System.out.println("6. Write student list after sort by march");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

    public static void main(String[] args) {
        String path = "E:\\codeGym\\testModule2\\src\\hocvien.txt";
        String path1 = "E:\\codeGym\\testModule2\\src\\hocvien1.txt";
        ArrayList<Student> students = new ArrayList<>();
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        showMenu();
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    studentManager.readFile(path, students);
                    break;
                case 2:
                    studentManager.searchStudentById(students);
                    break;
                case 3:
                    studentManager.displayStudentMarch(students);
                    break;
                case 4:
                    studentManager.sortStudentByMarch(students);
                    break;
                case 5:
                    studentManager.sortStudentByName(students);
                    break;
                case 6:
                    studentManager.writeFile(path1,students);
                    break;
                case 0:
                    System.exit(0);
            }
            showMenu();
        }
    }
}
