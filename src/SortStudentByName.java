import java.util.Comparator;

public class SortStudentByName implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        String[]s1;
        String[]s2;
        s1=student1.getFullName().split(" ");
        s2=student2.getFullName().split(" ");
        int lastS1=(s1[s1.length-1].length());
        int lastS2=(s2[s2.length-1].length());
        int rs=(student1.getFullName().substring(student1.getFullName().length()-lastS1)).compareTo(student2.getFullName().substring(student2.getFullName().length()-lastS2));
        int rs1=(student1.getFullName().substring(0,student1.getFullName().length()-lastS1)).compareTo(student2.getFullName().substring(student2.getFullName().length()-lastS2));
//    return student1.getFullName().compareTo(student2.getFullName());
        if (rs==0){
            return rs1;
        }else {
            return rs;
        }
    }
}
