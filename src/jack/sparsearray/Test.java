package jack.sparsearray;


import java.util.Scanner;

/**
 * 一些声明信息
 * Description: 五子棋游戏---->稀疏数组
 * date: 2020/5/15 14:44<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */

public class Test {
    private static int[][] table;//全局二维数组
    private static int[][] sparseArr;//全局稀疏数组
    private static int num = 0;//记录白棋先下还是黑棋先下
    private static int sum = 0;//记录下棋的个数

    /**
     * 用来执行二维数组的代码
     * @param args
     */
//    public static void main(String[] args) {
//        // 1. 创建空五子棋盘
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入要创建的棋盘【行】数（注意输入数字）：");
//        int x = scanner.nextInt();
//        System.out.println("请输入要创建的棋盘【列】数（注意输入数字）：");
//        int y = scanner.nextInt();
//        createTableNormal(x, y);
//
//        boolean bo = false;
//        while (!bo) {
//            if (num % 2 == 0) {//默认白棋先下
//                System.out.println(Chesspiece.WHITE.getColor()+"为"+Chesspiece.WHITE.getType());
//                System.out.println("请输入x坐标：");
//                x = scanner.nextInt();
//                System.out.println("请输入y坐标：");
//                y = scanner.nextInt();
//                downTable(x,y,Chesspiece.WHITE.getType());
//            }else {
//                System.out.println(Chesspiece.BLACK.getColor()+"为"+Chesspiece.BLACK.getType());
//                System.out.println("请输入x坐标：");
//                x = scanner.nextInt();
//                System.out.println("请输入y坐标：");
//                y = scanner.nextInt();
//                downTable(x,y,Chesspiece.BLACK.getType());
//            }
//            num++;
//        }
//    }

    /**
     * 用于执行稀疏数组的代码
     * @param args
     */
    public static void main(String[] args) {
        // 1. 创建空五子棋盘
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要创建的棋盘【行】数（注意输入数字）：");
        int x = scanner.nextInt();
        System.out.println("请输入要创建的棋盘【列】数（注意输入数字）：");
        int y = scanner.nextInt();
        createTableSparseArray(x, y);
        //2. 将稀疏表 转化为 普通表 输出
        SparseArrayToNomal();

        boolean bo = false;
        while (!bo) {
            if (num % 2 == 0) {//默认白棋先下
                System.out.println(Chesspiece.WHITE.getColor() + "为" + Chesspiece.WHITE.getType());
                System.out.println("请输入x坐标：");
                x = scanner.nextInt();
                System.out.println("请输入y坐标：");
                y = scanner.nextInt();
                downSparseTable(x, y, Chesspiece.WHITE.getType());
            } else {
                System.out.println(Chesspiece.BLACK.getColor() + "为" + Chesspiece.BLACK.getType());
                System.out.println("请输入x坐标：");
                x = scanner.nextInt();
                System.out.println("请输入y坐标：");
                y = scanner.nextInt();
                downSparseTable(x, y, Chesspiece.BLACK.getType());
            }
            num++;
        }
    }

    /**
     * 稀疏数组下棋
     * @param x
     * @param y
     * @param type
     */
    private static void downSparseTable(int x, int y, int type) {
        sum = sum +1;
        int m = sparseArr.length+1;//代表行
        int n = sparseArr[0].length;//代表列
        int[][] tmp = new int[m][n];//该稀疏数组保持 x 的+1扩容，y还是三行

        //原表的拷贝
        for (int i=0;i<sparseArr.length;i++){
            tmp[i][0] = sparseArr[i][0];
            tmp[i][1] = sparseArr[i][1];
            tmp[i][2] = sum;
        }


        tmp[sum][0]=x;
        tmp[sum][1]=y;
        tmp[sum][2]=type;

        sparseArr = tmp;
        //打印稀疏数组
        System.out.println("打印稀疏表：");
        for (int i = 0; i < sparseArr.length; i++) { //看有几行
            for (int j = 0; j < sparseArr[0].length; j++) {//打印每列
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }
        //将稀疏数组转换为二维数组
        SparseArrayToNomal();
    }

    /**
     * 将初始化稀疏表转化为普通表进行输出
     */
    private static void SparseArrayToNomal() {

        //处理稀疏数组第一行数据
        int x = sparseArr[0][0];
        int y = sparseArr[0][1];
        table = new int[x][y];//稀疏表的00为行数，01为列数
        //处理稀疏数组第二行开始后的数据
        //for 循环 稀疏表 赋值给 二维表
        int val = 0;
        for (int i=1;i<sparseArr.length;i++){
            x = sparseArr[i][0];//横坐标
            y = sparseArr[i][1];//纵坐标
            val = sparseArr[i][2];//值
            table[x][y]=val;
        }
        System.out.println("将稀疏表转化为普通表进行输出：");
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.printf("%d\t",table[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 创建五子棋地图
     *
     * @param x 几行
     * @param y 几列
     */
    public static void createTableNormal(int x, int y) {
        //int的默认值为0
        table = new int[x][y];
        for (int i = 0; i < x; i++) { //看有几列
            for (int j = 0; j < y; j++) {//打印每行
                System.out.printf("%d\t", table[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 创建五子棋地图 通过稀疏数组
     *
     * @param x
     * @param y 稀疏数组：一共有三列，坐标为（0,0）表示棋盘的总行数，（0，1）表示棋盘的总列数，（0，2）表示棋盘非0的个数
     */
    public static void createTableSparseArray(int x, int y) {
        sparseArr = new int[1][3];//初始化稀疏数组，只有表示行列的值
        sparseArr[0][0] = x;
        sparseArr[0][1] = y;
        sparseArr[0][2] = sum;
        //打印稀疏数组
        System.out.println("打印稀疏表：");
        for (int i = 0; i < 1; i++) { //看有几行
            for (int j = 0; j < 3; j++) {//打印每列
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * table的展示
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
     * 进行下棋
     *
     * @param x 放到的行数
     * @param y 放到的列数
     * @param
     */
    public static void downTable(int x, int y, int type) {
        table[x][y] = type;
        showTable();
    }
}

enum Chesspiece {
    WHITE("白", 1),
    BLACK("黑", 2);


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
        //获取下标
        int ordinal = Chesspiece.WHITE.ordinal();
        System.out.printf("%d\n", ordinal);//0
        //获取属性名
        String name = Chesspiece.WHITE.name();
        System.out.printf("%s\n", name);//WHITE
        //重写toString()方法后打印
        String white = Chesspiece.WHITE.toString();//本来底层返回的是name
        System.out.println(white);//Chesspiece{color='白', type=0}
        //返回get的结果
        int type = Chesspiece.BLACK.getType();
        System.out.println(type);//1
        String color = Chesspiece.BLACK.getColor();
        System.out.println(color);//黑
    }

}
