import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Read File.");
        System.out.println("2. Search student by id");
        System.out.println("3. Display student march>85");
        System.out.println("5. Search student's surname is Nguyen");
        System.out.println("6. Search student's email fail");
        System.out.println("7. Sort student by march");
        System.out.println("8. Write student list after sort by march");
        System.out.println("9. Sort student by name");
        System.out.println("10. Write student list after sort by name");
        System.out.println("11. Add Student");
        System.out.println("12. Update student information");
        System.out.println("13. Delete Student");
        System.out.println("0. Exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        showMenu();
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    studentManager.readFile();
                    break;
                case 2:
                    studentManager.displayStudentList();
                    break;
                case 3:
                    studentManager.searchStudentById();
                    break;
                case 4:
                    studentManager.displayStudentMarch();
                    break;
                case 5:
                    studentManager.displaySurNameNguyen();
                    break;
                case 6:
                    studentManager.displayEmailFail();
                    break;
                case 7:
                    studentManager.sortStudentByMarch();
                    break;
                case 8:
                    studentManager.writeFileSortedMarch();
                    break;
                case 9:
                    studentManager.sortStudentByName();
                    break;
                case 10:
                    studentManager.writeFileSortedName();
                    break;
                case 11:
                    studentManager.addStudent();
                    break;
                case 12:
                    studentManager.updateStudentInfoById();
                    break;
                case 13:
                    studentManager.deleteStudentById();
                    break;
                case 0:
                    System.exit(0);
            }
            showMenu();
        }
    }
}
