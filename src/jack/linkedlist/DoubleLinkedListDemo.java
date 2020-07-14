package jack.linkedlist;


import java.text.BreakIterator;

/**
 * һЩ������Ϣ
 * Description: <br/>
 * date: 2020/7/14 11:11<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode node2 = new HeroNode(2, "¬����", "������");
        HeroNode node4 = new HeroNode(4, "����", "�Ƕ���");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node4);

//        doubleLinkedList.list();



        HeroNode node3 = new HeroNode(3, "�ֳ�", "����ͷ");
        doubleLinkedList.add(node3);
        doubleLinkedList.list();

        System.out.println();
        System.out.println("========delete============");

        doubleLinkedList.delete(node2);
        doubleLinkedList.list();

        System.out.println();
        System.out.println("=======update=============");
        HeroNode node5 = new HeroNode(1, "�ֳ�", "����ͷ");
        doubleLinkedList.updata(node5);
    }
}

class DoubleLinkedList{

    //��ʼ��ͷ�ڵ㣬����ž�������
    private HeroNode head = new HeroNode(0,"","");

    /**
     * ��ȡͷ�ڵ�
     * @return
     */
    public HeroNode getHead(){
        return head;
    }

    /**
     * ͨ��no�ж���ӽڵ㣨����
     */
    public void add(HeroNode node){
        if (node.no==0){
            System.out.println("no����Ϊ0");
            return;
        }
        HeroNode tmp = head;
        //�������нڵ㣬�жϽڵ�Ĵ�С������������ǰ�����
        while (true){
            if (tmp.next == null){
                //�����������
                tmp.next = node;
                node.pre = tmp;
                break;
            }
            if (tmp.next.no == node.no){
                System.out.println("�ýڵ��Ѿ�����");
                return;
            }
            if (tmp.next.no > node.no){
                tmp.next.pre = node;
                node.next = tmp.next;
                node.pre = tmp;
                tmp.next=node;
                return;
            }

            tmp = tmp.next;
        }

    }

    /**
     * ɾ���ڵ�
     * @param node
     */
    public void delete(HeroNode node){
        if (head.next == null){
            System.out.println("������Ϊnull");
            return;
        }
        HeroNode tmp = head;
        while (true){
            if (tmp.next == null){
                break;
            }
            if (tmp.next.no == node.no){
                tmp.next.next.pre = tmp;
                tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
        }
    }

    /**
     * ����
     * @param node
     */
    public void updata(HeroNode node){
        HeroNode tmp = head;
        if (tmp.next == null){
            System.out.println("������Ϊnull");
            return;
        }
        while (true){
            if (tmp.next==null){
                break;
            }
            if (tmp.next.no == node.no){
                tmp.next.name = node.name;
                tmp.next.nickName = node.nickName;
            }
            tmp = tmp.next;
        }
    }

    /**
     * ��������
     */
    public void list(){
        //��������
        HeroNode temp = head.next;
        if (head.next == null) {
            System.out.println("ͷ�ڵ�Ϊnull");
            return;
        }

        while (true){
            //�ж��Ƿ����
            if (temp == null){
                break;
            }
            System.out.println(temp);
            //����
            temp = temp.next;
        }
    }


}




/**
 * ��ʼ���ڵ�
 */
class HeroNode{
    int no;
    String name;
    String nickName;
    HeroNode next;
    HeroNode pre;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
