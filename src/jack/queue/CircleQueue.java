package jack.queue;

/**
 * һЩ������Ϣ
 * Description: ����ʵ�ֻ��ζ���<br/>
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
     * �ж��Ƿ�Ϊnull
     *
     * @return
     */
    public boolean isNull() {
        return this.food == this.head;
    }

    /**
     * �ж��Ƿ��� ===> (food + 1) % size == head
     *
     * @return
     */
    public boolean isFull() {
        return (food + 1) % size == head;
    }

    /**
     * ���һ�����ֵ�����
     *
     * @param val
     */
    public void add(int val) {
        if (isFull()) {
            System.out.println("��������~~");
            return;
        }
        this.food = (this.food % size) + 1; //food�����һλ
        this.arr[this.food] = val;//��ֵ
        System.out.println("��ӳɹ�,foodΪ��" + this.food);
    }

    /**
     * ɾ��һ������
     */
    public void del() {
        if (isNull()) {
            System.out.println("����Ϊnull~~~");
            return;
        }
        this.arr[this.head] = 0;
        this.head = (this.head % size) + 1;
        System.out.println("��ӳɹ�,headΪ��" + this.head);
    }

    /**
     * ���س���
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
