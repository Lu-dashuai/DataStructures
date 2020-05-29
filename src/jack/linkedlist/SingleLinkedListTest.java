package jack.linkedlist;

import com.atguigu.tree.Test;

import javax.xml.stream.FactoryConfigurationError;

/**
 * 一些声明信息
 * Description: 单链表实现增删改查<br/>
 * date: 2020/5/29 1:12<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(new Node(1,"女1"));
//        singleLinkedList.add(new Node(2,"女2"));
//        singleLinkedList.add(new Node(3,"女3"));
//        singleLinkedList.add(new Node(4,"女4"));
//        singleLinkedList.add(new Node(3,"女3"));
        //乱序加入
        singleLinkedList.addByOrder(new Node(1,"女1"));
        singleLinkedList.addByOrder(new Node(3,"女3"));
        singleLinkedList.addByOrder(new Node(2,"女2"));
        singleLinkedList.addByOrder(new Node(4,"女4"));
        //重复添加
        singleLinkedList.addByOrder(new Node(3,"女3"));
        //更改已经存在的id
        singleLinkedList.update(new Node(3,"小美女"));
        //更改未存在的id
        singleLinkedList.update(new Node(10,"小美女"));

        //删除存在的id
        singleLinkedList.del(1);
        //删除未存在的id
        singleLinkedList.del(11);
        singleLinkedList.list();
    }


}

class SingleLinkedList{
    //初始化头节点
    private Node head = new Node(0,"");

    /**
     * 简单添加一个node节点
     * @param node
     */
    public void add(Node node){
        //创建一个临时节点 指向head
        Node temp = head;
        while (true){
            if (temp.next == null){//说明到最后了
                break;
            }
            temp = temp.next; //进行++后移保证循环
        }
        temp.next = node;
    }

    /**
     * 按照id的顺序添加，并且如果id重复，提示已经添加该id，不能重复添加
     * @param node
     */
    public void addByOrder(Node node){
        Node temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null)break; //尾部
            if (temp.next.id > node.id) break; // 1--->3  进来2了，此时temp = 1 ，if(1.next.id=3 > 2) 恭喜老铁找到了 temp = 1
            if (temp.next.id == node.id){
                flag = true;
                System.out.printf("id:[%d]已经添加过了，不能重复添加\n",node.id);
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
     * 更新某个节点 name
     * @param node
     */
    public void update(Node node){
        Node temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                System.out.println("到最后了~~");
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
            System.out.printf("更改时，根本没有这个id【%d】\n",node.id);
        }
    }

    /**
     * 删除某个节点
     * @param id
     */
    public void del(int id){
        Node temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                System.out.println("到最后了~~~");
                break;
            }
            if (temp.next.id == id){//找到被删除的节点的上一个节点
                flag = !flag;
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }
        if (!flag) System.out.printf("删除时，没找到id：【%d】\n",id);
    }

    /**
     * 遍历单链表
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
 * 创建node节点
 */
class Node{
    public int id;
    public String name;
    public Node next; //next代表下一个节点类

    /**
     * 构造方法
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