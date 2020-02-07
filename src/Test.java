public class Test {
    public static void main(String[] args) {
        String string="Bui Xuan Huynh";
        String string1="Nguyen Tien Nghiaaaaaaaa";
        String[] str;
        String[] str1;
        str=string.split(" ");
        str1=string1.split(" ");
        int lastS1=(str[str.length-1].length());
        int lastS2=(str1[str.length-1].length());
        System.out.println(lastS1);
        System.out.println(lastS2);
        String name = (string.substring(string.length()-lastS1));
        System.out.println(name);
        System.out.println(string.substring(0,string.length()-lastS1));
    }
}
