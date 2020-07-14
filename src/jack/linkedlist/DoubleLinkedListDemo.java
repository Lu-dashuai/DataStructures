package jack.linkedlist;


import java.text.BreakIterator;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/7/14 11:11<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node4 = new HeroNode(4, "吴用", "智多星");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node4);

//        doubleLinkedList.list();



        HeroNode node3 = new HeroNode(3, "林冲", "豹子头");
        doubleLinkedList.add(node3);
        doubleLinkedList.list();

        System.out.println();
        System.out.println("========delete============");

        doubleLinkedList.delete(node2);
        doubleLinkedList.list();

        System.out.println();
        System.out.println("=======update=============");
        HeroNode node5 = new HeroNode(1, "林冲", "豹子头");
        doubleLinkedList.updata(node5);
    }
}

class DoubleLinkedList{

    //初始化头节点，不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    /**
     * 获取头节点
     * @return
     */
    public HeroNode getHead(){
        return head;
    }

    /**
     * 通过no判断添加节点（有序）
     */
    public void add(HeroNode node){
        if (node.no==0){
            System.out.println("no不能为0");
            return;
        }
        HeroNode tmp = head;
        //遍历所有节点，判断节点的大小，如果大就往他前面插入
        while (true){
            if (tmp.next == null){
                //遍历到最后了
                tmp.next = node;
                node.pre = tmp;
                break;
            }
            if (tmp.next.no == node.no){
                System.out.println("该节点已经存在");
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
     * 删除节点
     * @param node
     */
    public void delete(HeroNode node){
        if (head.next == null){
            System.out.println("该链表为null");
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
     * 更改
     * @param node
     */
    public void updata(HeroNode node){
        HeroNode tmp = head;
        if (tmp.next == null){
            System.out.println("该链表为null");
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
     * 遍历链表
     */
    public void list(){
        //辅助变量
        HeroNode temp = head.next;
        if (head.next == null) {
            System.out.println("头节点为null");
            return;
        }

        while (true){
            //判断是否到最后
            if (temp == null){
                break;
            }
            System.out.println(temp);
            //后移
            temp = temp.next;
        }
    }


}




/**
 * 初始化节点
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
