package test.algorithm.stackandqueue;

public class Hanoi {
    /**
    * 
    * @param num 盘子的数目
    * @param left 源座
    * @param mid 辅助座
    * @param right 目的座
    * 
    * 用递归的方式实现汉诺塔问题的求解。
    * 
    * 汉诺塔问题：
    * 汉诺塔（又称河内塔）问题是源于印度一个古老传说的益智玩具。大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。
    * 大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。
    * 
    * 理解：
    * 为了将N个盘子从 left 移动到 right,需要先将第N个盘子上面的N-1个盘子移动到 mid 上，这样才能将第N个盘子移动到 right 上。
    * 同理，为了将第N-1个盘子从 mid 移动到 right 上，需要将N-2个盘子移动到 left 上，这样才能将第N-1个盘子移动到 right 上。
    */
 
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(3, "left", "mid", "right");
    }
    
    public void hanoi(int num, String left, String mid, String right) {
//    	System.out.println("n = " + n + ", orgin = " + orgin + ", assist = " + assist + ", destination = " + destination);
    	if(num == 1) {
    		move(left, right);
    	}else {
    		hanoi(num - 1, left, right, mid);
    		move(left, right);
    		hanoi(num - 1, mid, left, right);
    	}
    }
    
    public void move(String orgin,String destination) {
    	System.out.println("Direction : " + orgin + " --> " + destination);
    }
}
