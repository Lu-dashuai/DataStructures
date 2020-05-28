package jack.queue;

import java.util.LinkedList;

/**
 * 一些声明信息
 * Description: 数组实现环形队列<br/>
 * date: 2020/5/19 13:32<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */
public class CircleQueue {
    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue(5);
        linkedQueue.add(10);
        linkedQueue.add(20);
        linkedQueue.add(30);
        linkedQueue.add(40);
        linkedQueue.add(50);
        linkedQueue.show();
        int size = linkedQueue.getSize();
        System.out.println("长度："+size);
        linkedQueue.del();
        linkedQueue.show();
        size = linkedQueue.getSize();
        System.out.println("长度："+size);
    }

}

class LinkedQueue {
    private int size;
    private int head;
    private int food;
    private int[] arr;

    public LinkedQueue(int size) {
        this.size = size;
        arr = new int[size];
        this.head = 0;
        this.food = 0;
    }

    /**
     * 判断是否为null
     *
     * @return
     */
    public boolean isNull() {
        return this.food == this.head;
    }

    /**
     * 判断是否满 ===> (food + 1) % size == head
     *
     * @return
     */
    public boolean isFull() {
        return (food + 1) % size == head;
    }

    /**
     * 添加一个数字到队列
     *
     * @param val
     */
    public void add(int val) {
        if (isFull()) {
            System.out.println("队列已满~~");
            return;
        }
        arr[food] = val;//给值
        food = (food + 1 ) % size; //food向后移一位
        System.out.println("添加成功,food为：" + food);
    }

    /**
     * 删除一个队列
     */
    public void del() {
        if (isNull()) {
            System.out.println("队列为null~~~");
            return;
        }
        int val = arr[head];
        this.head = ( head + 1) % size;
        System.out.println("删除["+val+"]成功,head为：" + head);
    }

    /**
     * 返回长度
     *
     * @return
     */
    public int getSize() {
        return  (food - head + size) % size;
    }

    /**
     * 展示当前队列
     */
    public void show(){
        //从head开始，表示循环有效长度次
        for (int i = head; i < head + getSize(); i++) {
            //取余等于拿到真实的 数组内的指针
            System.out.println("arr["+i%size+"] = "+arr[i%size]);
        }
    }

}
