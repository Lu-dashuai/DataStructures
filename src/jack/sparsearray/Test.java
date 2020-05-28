package jack.sparsearray;


import java.util.Scanner;

/**
 * һЩ������Ϣ
 * Description: ��������Ϸ---->ϡ������
 * date: 2020/5/15 14:44<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */

public class Test {
    private static int[][] table;//ȫ�ֶ�ά����
    private static int[][] sparseArr;//ȫ��ϡ������
    private static int num = 0;//��¼�������»��Ǻ�������
    private static int sum = 0;//��¼����ĸ���

    /**
     * ����ִ�ж�ά����Ĵ���
     * @param args
     */
//    public static void main(String[] args) {
//        // 1. ��������������
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("������Ҫ���������̡��С�����ע���������֣���");
//        int x = scanner.nextInt();
//        System.out.println("������Ҫ���������̡��С�����ע���������֣���");
//        int y = scanner.nextInt();
//        createTableNormal(x, y);
//
//        boolean bo = false;
//        while (!bo) {
//            if (num % 2 == 0) {//Ĭ�ϰ�������
//                System.out.println(Chesspiece.WHITE.getColor()+"Ϊ"+Chesspiece.WHITE.getType());
//                System.out.println("������x���꣺");
//                x = scanner.nextInt();
//                System.out.println("������y���꣺");
//                y = scanner.nextInt();
//                downTable(x,y,Chesspiece.WHITE.getType());
//            }else {
//                System.out.println(Chesspiece.BLACK.getColor()+"Ϊ"+Chesspiece.BLACK.getType());
//                System.out.println("������x���꣺");
//                x = scanner.nextInt();
//                System.out.println("������y���꣺");
//                y = scanner.nextInt();
//                downTable(x,y,Chesspiece.BLACK.getType());
//            }
//            num++;
//        }
//    }

    /**
     * ����ִ��ϡ������Ĵ���
     * @param args
     */
    public static void main(String[] args) {
        // 1. ��������������
        Scanner scanner = new Scanner(System.in);
        System.out.println("������Ҫ���������̡��С�����ע���������֣���");
        int x = scanner.nextInt();
        System.out.println("������Ҫ���������̡��С�����ע���������֣���");
        int y = scanner.nextInt();
        createTableSparseArray(x, y);
        //2. ��ϡ��� ת��Ϊ ��ͨ�� ���
        SparseArrayToNomal();

        boolean bo = false;
        while (!bo) {
            if (num % 2 == 0) {//Ĭ�ϰ�������
                System.out.println(Chesspiece.WHITE.getColor() + "Ϊ" + Chesspiece.WHITE.getType());
                System.out.println("������x���꣺");
                x = scanner.nextInt();
                System.out.println("������y���꣺");
                y = scanner.nextInt();
                downSparseTable(x, y, Chesspiece.WHITE.getType());
            } else {
                System.out.println(Chesspiece.BLACK.getColor() + "Ϊ" + Chesspiece.BLACK.getType());
                System.out.println("������x���꣺");
                x = scanner.nextInt();
                System.out.println("������y���꣺");
                y = scanner.nextInt();
                downSparseTable(x, y, Chesspiece.BLACK.getType());
            }
            num++;
        }
    }

    /**
     * ϡ����������
     * @param x
     * @param y
     * @param type
     */
    private static void downSparseTable(int x, int y, int type) {
        sum = sum +1;
        int m = sparseArr.length+1;//������
        int n = sparseArr[0].length;//������
        int[][] tmp = new int[m][n];//��ϡ�����鱣�� x ��+1���ݣ�y��������

        //ԭ��Ŀ���
        for (int i=0;i<sparseArr.length;i++){
            tmp[i][0] = sparseArr[i][0];
            tmp[i][1] = sparseArr[i][1];
            tmp[i][2] = sum;
        }


        tmp[sum][0]=x;
        tmp[sum][1]=y;
        tmp[sum][2]=type;

        sparseArr = tmp;
        //��ӡϡ������
        System.out.println("��ӡϡ���");
        for (int i = 0; i < sparseArr.length; i++) { //���м���
            for (int j = 0; j < sparseArr[0].length; j++) {//��ӡÿ��
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }
        //��ϡ������ת��Ϊ��ά����
        SparseArrayToNomal();
    }

    /**
     * ����ʼ��ϡ���ת��Ϊ��ͨ��������
     */
    private static void SparseArrayToNomal() {

        //����ϡ�������һ������
        int x = sparseArr[0][0];
        int y = sparseArr[0][1];
        table = new int[x][y];//ϡ����00Ϊ������01Ϊ����
        //����ϡ������ڶ��п�ʼ�������
        //for ѭ�� ϡ��� ��ֵ�� ��ά��
        int val = 0;
        for (int i=1;i<sparseArr.length;i++){
            x = sparseArr[i][0];//������
            y = sparseArr[i][1];//������
            val = sparseArr[i][2];//ֵ
            table[x][y]=val;
        }
        System.out.println("��ϡ���ת��Ϊ��ͨ����������");
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.printf("%d\t",table[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * �����������ͼ
     *
     * @param x ����
     * @param y ����
     */
    public static void createTableNormal(int x, int y) {
        //int��Ĭ��ֵΪ0
        table = new int[x][y];
        for (int i = 0; i < x; i++) { //���м���
            for (int j = 0; j < y; j++) {//��ӡÿ��
                System.out.printf("%d\t", table[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * �����������ͼ ͨ��ϡ������
     *
     * @param x
     * @param y ϡ�����飺һ�������У�����Ϊ��0,0����ʾ���̵�����������0��1����ʾ���̵�����������0��2����ʾ���̷�0�ĸ���
     */
    public static void createTableSparseArray(int x, int y) {
        sparseArr = new int[1][3];//��ʼ��ϡ�����飬ֻ�б�ʾ���е�ֵ
        sparseArr[0][0] = x;
        sparseArr[0][1] = y;
        sparseArr[0][2] = sum;
        //��ӡϡ������
        System.out.println("��ӡϡ���");
        for (int i = 0; i < 1; i++) { //���м���
            for (int j = 0; j < 3; j++) {//��ӡÿ��
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * table��չʾ
     */
    public static void showTable() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%d\t", table[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * ��������
     *
     * @param x �ŵ�������
     * @param y �ŵ�������
     * @param
     */
    public static void downTable(int x, int y, int type) {
        table[x][y] = type;
        showTable();
    }
}

enum Chesspiece {
    WHITE("��", 1),
    BLACK("��", 2);


    private String color;
    private int type;

    Chesspiece(String color, int type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Chesspiece{" +
                "color='" + color + '\'' +
                ", type=" + type +
                '}';
    }


    public static void main(String[] args) {
        //��ȡ�±�
        int ordinal = Chesspiece.WHITE.ordinal();
        System.out.printf("%d\n", ordinal);//0
        //��ȡ������
        String name = Chesspiece.WHITE.name();
        System.out.printf("%s\n", name);//WHITE
        //��дtoString()�������ӡ
        String white = Chesspiece.WHITE.toString();//�����ײ㷵�ص���name
        System.out.println(white);//Chesspiece{color='��', type=0}
        //����get�Ľ��
        int type = Chesspiece.BLACK.getType();
        System.out.println(type);//1
        String color = Chesspiece.BLACK.getColor();
        System.out.println(color);//��
    }

}
