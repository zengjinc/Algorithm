package test.algorithm.stackandqueue;

public class Hanoi2 {
    /**
    * 
    * @param num 盘子的数目
    * @param left 源座
    * @param mid 辅助座
    * @param right 目的座
    * 
    * 求解当塔有 N 层的时候，打印最优移动过程和最优移动总步数（利用递归）
    * 
    * 汉诺塔问题2：
    * 修改一下游戏规则：限制不能从最左侧的塔直接移动到最右侧，也不能从最右侧的塔移动到最左侧，都必须经过中间的塔。
    * 
    * 理解：如果有 N 层塔，从上到下记为 1 - N。 
    * 
    * 如果 N 层塔都在“左”，希望全部移动到“中”，步骤如下（同理：中-->左，中-->右，右-->中。 同样可以分解为三步）
    * 	①将 1~N-1 层从“左”移动到“右”
    * 	②将第 N 层从“左”移动到“中”
    * 	③将 1~N-1 层从“右”移动到“中”
    * 
    * 如果 N 层塔都在“左”，希望全部移动到“右”，步骤如下（同理：右-->左）
    * 	①将 1~N-1 层从“左”移动到“右”
    * 	②将 N 层从“左”移动到“中”
    * 	③将 1~N-1 层从“右”移动到“左”
    * 	④将 N 层从“中”移动到“右”
    * 	⑤将 1~N-1 层从“左”移动到“右”
    */
 
    public static void main(String[] args) {
    	Hanoi2 hanoi = new Hanoi2();
    	int count = hanoi.hanio2(3, "left", "mid", "right");
    	System.out.println("It will move " + count + " steps.");
    }
    
    public int hanio2(int num, String left, String mid, String right) {
    	if(num < 0) {
    		return 0;
    	}
    	return process(num, left, mid, right, left, right);
    }
    
    public int process(int num, String left, String mid, String right, String from, String to) {
    	if(num == 1) {
    		if(from.equals("mid") || to.equals("mid")) {
    			System.out.println("Direction : " + from + " --> " + to);
    			return 1;
    		}else {
    			System.out.println("Direction : " + from + " --> " + mid);
    			System.out.println("Direction : " + mid + " --> " + to);
    			return 2;
    		}
    	}
    	if(from.equals("mid") || to.equals("mid")) {
    		String another = (from.equals("left") || to.equals("left")) ? right : left;
    		
    		int part1 = process(num - 1, left, mid, right, from, another);
    		
    		System.out.println("Direction : " + from + " --> " + to);
    		int part2 = 1;
    		
    		int part3 = process(num, left, mid, right, another, to);
    		
    		return part1 + part2 + part3;
    	}else {
    		int part1 = process(num - 1, left, mid, right, from, to);
    		
    		System.out.println("Direction : " + from + " --> " + mid);
    		int part2 = 1;
    		
    		int part3 = process(num - 1, left, mid, right, to, from);
    		
    		System.out.println("Direction : " + mid + " --> " + to);
    		int part4 = 1;
    		
    		int part5 = process(num - 1, left, mid, right, from, to);
    		
    		return part1 + part2 + part3 + part4 + part5;    		
    	}
    }
}
