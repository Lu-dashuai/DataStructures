package jack.queue;

import java.util.Scanner;

/**
 * 一些声明信息
 * Description: 数组实现队列<br/>
 * date: 2020/5/18 1:16<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */
public class ArrQueueTest {

    public static void main(String[] args) {
        ArrQueueList arrQueueList = new ArrQueueList(3);
        boolean bo = false;
        char c = ' ';//接受命令
        Scanner scanner = new Scanner(System.in);
        while (!bo) {
            System.out.println("输入[a]添加");
            System.out.println("输入[g]取出");
            System.out.println("输入[h]获取头部的值");
            System.out.println("输入[s]打印队列");
            char next = scanner.next().charAt(0);
            ;
            switch (next) {
                case 'a':
                    System.out.println("请输入一个数字：");
                    int i = scanner.nextInt();
                    arrQueueList.add(i);
                    break;
                case 'g':
                    try {
                        int head = arrQueueList.getHead();
                        System.out.println("取出头：" + head);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 'h':
                    try {
                        int head = arrQueueList.head();
                        System.out.println("头：" + head);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 's':
                    arrQueueList.show();
                    break;
                default:
                    break;
            }

        }
    }


}

/**
 * 创建一个队列
 */
class ArrQueueList {
    private int size;//数组的长度
    private int head;//头的坐标
    private int food;//尾的坐标
    private int[] arr;//数组存放数据

    /**
     * 构造函数初始化数组的大小，并且给head 和 food 都指向 头部
     *
     * @param size
     */
    public ArrQueueList(int size) {
        this.size = size;
        arr = new int[size];
        head = -1;// 初始化时 都为指针都指向第一个
        food = -1;
    }
    //下面写增删改查 队列的方法，先写两个 1. 判断是否为null 2. 判断是否满了

    /**
     * 队列是否为null
     *
     * @return
     */
    public boolean isNull() {
        return head == food;//当头部指针值 == 尾部指针值 队列为null
    }

    /**
     * 队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return food == size - 1;//比如一个队列的size = 3，    0->1->2 这个队列的food = 2  现在是被填满的情况
    }

    /**
     * 给队列添加一个值
     *
     * @param val
     */
    public void add(int val) {
        if (isFull()) {
            System.out.println("满了~~");
            return;
        }
        food++;
        arr[food] = val;
    }

    /**
     * 取出队列的头部
     */
    public int getHead() {
        if (isNull()) {
            throw new RuntimeException("空的!!!");
        }
        head++;
        return arr[head];
    }

    /**
     * 头部的值
     *
     * @return
     */
    public int head() {
        if (isNull()) {
            throw new RuntimeException("空的！！！");
        }
        return arr[head + 1];
    }

    /**
     * 打印队列
     */
    void show() {
        if (isNull()) {
            System.out.println("空的！！！");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i,arr[i]);
        }
    }


}
