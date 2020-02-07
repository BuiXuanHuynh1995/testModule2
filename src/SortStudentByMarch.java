import java.util.Comparator;

public class SortStudentByMarch implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getMarch()==student2.getMarch()){
            return 0;
        }
        else if (student1.getMarch()>student2.getMarch()){
            return -1;
        }else {
            return 1;
        }
    }
}
