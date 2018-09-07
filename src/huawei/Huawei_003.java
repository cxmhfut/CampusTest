package huawei;

import java.util.*;

public class Huawei_003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.nextLine();
            unzip(input);
        }

        sc.close();
    }

    public static void unzip(String input) {
        input += "a";
        char ch[] = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        char pre = ch[0];
        sb.append(pre);
        int i = 1;
        int num = 0;
        List<String> ls = new ArrayList<>();
        List<Integer> lnum = new ArrayList<>();
        while (i < ch.length) {
            if (pre >= '0' && pre <= '9') {
                if (ch[i] >= '0' && ch[i] <= '9') {
                    num = num * 10 + ch[i] - '0';
                } else {
                    lnum.add(num);
                    sb = new StringBuilder();
                    sb.append(ch[i]);
                }
            } else {
                if (ch[i] >= '0' && ch[i] <= '9') {
                    ls.add(sb.toString());
                    num = ch[i] - '0';
                } else {
                    sb.append(ch[i]);
                }
            }
            pre = ch[i];
            i++;
        }
        List<MyChar> myChars = new ArrayList<>();
        for (int j = 0; j < ls.size(); j++) {
            MyChar myChar = new MyChar(ls.get(j), lnum.get(j));
            myChars.add(myChar);
        }

        Collections.sort(myChars, new Comparator<MyChar>() {
            @Override
            public int compare(MyChar o1, MyChar o2) {
                if (o1.getCount() == o2.getCount()) {
                    if (o1.getS().length() == o2.getS().length()) {
                        return o1.getS().compareTo(o2.getS());
                    } else {
                        return o1.getS().length() - o2.getS().length();
                    }
                }
                return o1.getCount() - o2.getCount();
            }
        });

        for (MyChar myChar : myChars) {
            System.out.print(myChar);
        }
        System.out.println();
    }
}

class MyChar {
    private String s;
    private int count;

    MyChar(String s, int count) {
        this.s = s;
        this.count = count;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
