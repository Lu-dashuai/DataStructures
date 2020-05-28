package jack.queue;

import java.util.LinkedList;

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
        LinkedQueue linkedQueue = new LinkedQueue(5);
        linkedQueue.add(10);
        linkedQueue.add(20);
        linkedQueue.add(30);
        linkedQueue.add(40);
        linkedQueue.add(50);
        linkedQueue.show();
        int size = linkedQueue.getSize();
        System.out.println("���ȣ�"+size);
        linkedQueue.del();
        linkedQueue.show();
        size = linkedQueue.getSize();
        System.out.println("���ȣ�"+size);
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
        arr[food] = val;//��ֵ
        food = (food + 1 ) % size; //food�����һλ
        System.out.println("��ӳɹ�,foodΪ��" + food);
    }

    /**
     * ɾ��һ������
     */
    public void del() {
        if (isNull()) {
            System.out.println("����Ϊnull~~~");
            return;
        }
        int val = arr[head];
        this.head = ( head + 1) % size;
        System.out.println("ɾ��["+val+"]�ɹ�,headΪ��" + head);
    }

    /**
     * ���س���
     *
     * @return
     */
    public int getSize() {
        return  (food - head + size) % size;
    }

    /**
     * չʾ��ǰ����
     */
    public void show(){
        //��head��ʼ����ʾѭ����Ч���ȴ�
        for (int i = head; i < head + getSize(); i++) {
            //ȡ������õ���ʵ�� �����ڵ�ָ��
            System.out.println("arr["+i%size+"] = "+arr[i%size]);
        }
    }

}
