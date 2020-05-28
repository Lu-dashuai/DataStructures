package jack.queue;

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
        this.food = (this.food % size) + 1; //food向后移一位
        this.arr[this.food] = val;//给值
        System.out.println("添加成功,food为：" + this.food);
    }

    /**
     * 删除一个队列
     */
    public void del() {
        if (isNull()) {
            System.out.println("队列为null~~~");
            return;
        }
        this.arr[this.head] = 0;
        this.head = (this.head % size) + 1;
        System.out.println("添加成功,head为：" + this.head);
    }

    /**
     * 返回长度
     *
     * @return
     */
    public int getSize() {
        if (isFull()) {
            return this.size;
        }
        if (isNull()) {
            return 0;
        }
        return Math.abs(this.head - this.food);
    }


}
