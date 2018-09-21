package baidu;

public class Test1 {
    public static void main(String[] args) {
        String str = "Steve Jobs founded the apple";
        String str2 = str.substring(6,10);
        int pos = str.indexOf("the");
        String str3 = str.substring(pos);
        System.out.println(str2+" "+str3);
    }
}
