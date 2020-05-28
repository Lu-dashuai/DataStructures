package jack.queue;

import java.util.Scanner;

/**
 * һЩ������Ϣ
 * Description: ����ʵ�ֶ���<br/>
 * date: 2020/5/18 1:16<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */
public class ArrQueueTest {

    public static void main(String[] args) {
        ArrQueueList arrQueueList = new ArrQueueList(3);
        boolean bo = false;
        char c = ' ';//��������
        Scanner scanner = new Scanner(System.in);
        while (!bo) {
            System.out.println("����[a]���");
            System.out.println("����[g]ȡ��");
            System.out.println("����[h]��ȡͷ����ֵ");
            System.out.println("����[s]��ӡ����");
            char next = scanner.next().charAt(0);
            ;
            switch (next) {
                case 'a':
                    System.out.println("������һ�����֣�");
                    int i = scanner.nextInt();
                    arrQueueList.add(i);
                    break;
                case 'g':
                    try {
                        int head = arrQueueList.getHead();
                        System.out.println("ȡ��ͷ��" + head);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 'h':
                    try {
                        int head = arrQueueList.head();
                        System.out.println("ͷ��" + head);
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
 * ����һ������
 */
class ArrQueueList {
    private int size;//����ĳ���
    private int head;//ͷ������
    private int food;//β������
    private int[] arr;//����������

    /**
     * ���캯����ʼ������Ĵ�С�����Ҹ�head �� food ��ָ�� ͷ��
     *
     * @param size
     */
    public ArrQueueList(int size) {
        this.size = size;
        arr = new int[size];
        head = -1;// ��ʼ��ʱ ��Ϊָ�붼ָ���һ��
        food = -1;
    }
    //����д��ɾ�Ĳ� ���еķ�������д���� 1. �ж��Ƿ�Ϊnull 2. �ж��Ƿ�����

    /**
     * �����Ƿ�Ϊnull
     *
     * @return
     */
    public boolean isNull() {
        return head == food;//��ͷ��ָ��ֵ == β��ָ��ֵ ����Ϊnull
    }

    /**
     * �����Ƿ���
     *
     * @return
     */
    public boolean isFull() {
        return food == size - 1;//����һ�����е�size = 3��    0->1->2 ������е�food = 2  �����Ǳ����������
    }

    /**
     * ���������һ��ֵ
     *
     * @param val
     */
    public void add(int val) {
        if (isFull()) {
            System.out.println("����~~");
            return;
        }
        food++;
        arr[food] = val;
    }

    /**
     * ȡ�����е�ͷ��
     */
    public int getHead() {
        if (isNull()) {
            throw new RuntimeException("�յ�!!!");
        }
        head++;
        return arr[head];
    }

    /**
     * ͷ����ֵ
     *
     * @return
     */
    public int head() {
        if (isNull()) {
            throw new RuntimeException("�յģ�����");
        }
        return arr[head + 1];
    }

    /**
     * ��ӡ����
     */
    void show() {
        if (isNull()) {
            System.out.println("�յģ�����");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i,arr[i]);
        }
    }


}
