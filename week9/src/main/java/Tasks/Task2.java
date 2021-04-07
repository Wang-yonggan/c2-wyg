package Tasks;

//模拟圆圈
public class Task2 {

    public static int get_last(int n, int m) {
        Node nodes[] = new Node[n];
        for (int i = 0; i < n; i++)
            nodes[i] = new Node(i, (i + n - 1) % n, (i + 1) % n, 1);
        int index = 0;
        while (n > 1) {
            //走m步,i计数
            for (int i = 0; i < m - 1; i++)
                index = nodes[index].next;
            //删除，维护
            Node node = nodes[index];
            node.live = 0;
            nodes[node.pre].next = node.next;
            nodes[node.next].pre = node.pre;
            index = node.next;//更新Index
            n--;
        }
        return index;
    }

    public static void main(String[] args) {
        int n = 10, m = 17;
        System.out.println(get_last(n, m));
    }
}

class Node {
    int value;
    int pre;
    int next;
    int live;

    public Node(int value, int pre, int next, int live) {
        this.value = value;
        this.pre = pre;
        this.next = next;
        this.live = live;
    }
}