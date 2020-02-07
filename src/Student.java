import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String fullName;
    private String email;
    private int march;

    public Student() {
    }

    public Student(String id, String fullName, String email, int march) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.march = march;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMarch() {
        return march;
    }

    public void setMarch(int march) {
        this.march = march;
    }

    public void studentDisplay(){
        System.out.printf("%-30s%-30s%-50s%-5s\n",id,fullName,email,march);
    }
}
