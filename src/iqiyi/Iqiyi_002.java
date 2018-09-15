package iqiyi;

import java.util.*;

public class Iqiyi_002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Nodes> nodesList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int aTemp = sc.nextInt();
                int bTemp = sc.nextInt();
                int a = aTemp < bTemp ? aTemp : bTemp;
                int b = aTemp < bTemp ? bTemp : aTemp;
                nodesList.add(new Nodes(a, b));
            }
            getResult(n, nodesList);
        }

        sc.close();
    }

    public static void getResult(int n, List<Nodes> nodesList) {

        Collections.sort(nodesList, new Comparator<Nodes>() {
            @Override
            public int compare(Nodes o1, Nodes o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Nodes nodes = nodesList.get(i);
            if (map.containsKey(nodes.start)) {
                map.get(nodes.start).add(nodes.end);
            } else {
                LinkedList<Integer> ends = new LinkedList<>();
                ends.add(nodes.end);
                map.put(nodes.start, ends);
            }
        }

        for (int i = 0; i < n; i++) {
            Nodes nodes = nodesList.get(i);
            LinkedList<Integer> ends = map.get(nodes.start);
            int j = 0;
            while (j < ends.size()) {
                int end = ends.get(j);
                LinkedList<Integer> next = map.get(end);
                if (next != null && next.size() != 0) {
                    ends.poll();
                    ends.add(next.poll());
                }
                j++;
            }
        }

        System.out.println(map.toString());

        int count = 0;
        for (int i = 0; i < n; i++) {
            Nodes nodes = nodesList.get(i);
            count += map.get(nodes.start).size();
        }

        System.out.println(count);
    }
}

class Nodes {
    int start;
    int end;

    public Nodes(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
