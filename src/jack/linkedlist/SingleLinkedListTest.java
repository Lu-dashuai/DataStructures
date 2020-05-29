package jack.linkedlist;

import com.atguigu.tree.Test;

import javax.xml.stream.FactoryConfigurationError;

/**
 * һЩ������Ϣ
 * Description: ������ʵ����ɾ�Ĳ�<br/>
 * date: 2020/5/29 1:12<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(new Node(1,"Ů1"));
//        singleLinkedList.add(new Node(2,"Ů2"));
//        singleLinkedList.add(new Node(3,"Ů3"));
//        singleLinkedList.add(new Node(4,"Ů4"));
//        singleLinkedList.add(new Node(3,"Ů3"));
        //�������
        singleLinkedList.addByOrder(new Node(1,"Ů1"));
        singleLinkedList.addByOrder(new Node(3,"Ů3"));
        singleLinkedList.addByOrder(new Node(2,"Ů2"));
        singleLinkedList.addByOrder(new Node(4,"Ů4"));
        //�ظ����
        singleLinkedList.addByOrder(new Node(3,"Ů3"));
        //�����Ѿ����ڵ�id
        singleLinkedList.update(new Node(3,"С��Ů"));
        //����δ���ڵ�id
        singleLinkedList.update(new Node(10,"С��Ů"));

        //ɾ�����ڵ�id
        singleLinkedList.del(1);
        //ɾ��δ���ڵ�id
        singleLinkedList.del(11);
        singleLinkedList.list();
    }


}

class SingleLinkedList{
    //��ʼ��ͷ�ڵ�
    private Node head = new Node(0,"");

    /**
     * �����һ��node�ڵ�
     * @param node
     */
    public void add(Node node){
        //����һ����ʱ�ڵ� ָ��head
        Node temp = head;
        while (true){
            if (temp.next == null){//˵���������
                break;
            }
            temp = temp.next; //����++���Ʊ�֤ѭ��
        }
        temp.next = node;
    }

    /**
     * ����id��˳����ӣ��������id�ظ�����ʾ�Ѿ���Ӹ�id�������ظ����
     * @param node
     */
    public void addByOrder(Node node){
        Node temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null)break; //β��
            if (temp.next.id > node.id) break; // 1--->3  ����2�ˣ���ʱtemp = 1 ��if(1.next.id=3 > 2) ��ϲ�����ҵ��� temp = 1
            if (temp.next.id == node.id){
                flag = true;
                System.out.printf("id:[%d]�Ѿ���ӹ��ˣ������ظ����\n",node.id);
                break;
            }
            temp = temp.next;
        }
        if (!flag){//temp = 1
            node.next = temp.next; // 2-->3
            temp.next = node;//1--->2
        }
    }

    /**
     * ����ĳ���ڵ� name
     * @param node
     */
    public void update(Node node){
        Node temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                System.out.println("�������~~");
                break;
            }
            if (temp.id == node.id){
                flag = !flag;
                temp.name = node.name;
                break;
            }
            temp = temp.next;
        }
        if (!flag){
            System.out.printf("����ʱ������û�����id��%d��\n",node.id);
        }
    }

    /**
     * ɾ��ĳ���ڵ�
     * @param id
     */
    public void del(int id){
        Node temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                System.out.println("�������~~~");
                break;
            }
            if (temp.next.id == id){//�ҵ���ɾ���Ľڵ����һ���ڵ�
                flag = !flag;
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }
        if (!flag) System.out.printf("ɾ��ʱ��û�ҵ�id����%d��\n",id);
    }

    /**
     * ����������
     */
    public void list(){
        Node temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

/**
 * ����node�ڵ�
 */
class Node{
    public int id;
    public String name;
    public Node next; //next������һ���ڵ���

    /**
     * ���췽��
     * @param id
     * @param name
     */
    public Node(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}