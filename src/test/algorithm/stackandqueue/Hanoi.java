package test.algorithm.stackandqueue;

public class Hanoi {
    /**
    * 
    * @param num ���ӵ���Ŀ
    * @param left Դ��
    * @param mid ������
    * @param right Ŀ����
    * 
    * �õݹ�ķ�ʽʵ�ֺ�ŵ���������⡣
    * 
    * ��ŵ�����⣺
    * ��ŵ�����ֳƺ�������������Դ��ӡ��һ�����ϴ�˵��������ߡ������촴�������ʱ�������������ʯ���ӣ���һ�������ϴ������ϰ��մ�С˳������64Ƭ�ƽ�Բ�̡�
    * ���������������Ű�Բ�̴����濪ʼ����С˳�����°ڷ�����һ�������ϡ����ҹ涨����СԲ���ϲ��ܷŴ�Բ�̣�����������֮��һ��ֻ���ƶ�һ��Բ�̡�
    * 
    * ��⣺
    * Ϊ�˽�N�����Ӵ� left �ƶ��� right,��Ҫ�Ƚ���N�����������N-1�������ƶ��� mid �ϣ��������ܽ���N�������ƶ��� right �ϡ�
    * ͬ��Ϊ�˽���N-1�����Ӵ� mid �ƶ��� right �ϣ���Ҫ��N-2�������ƶ��� left �ϣ��������ܽ���N-1�������ƶ��� right �ϡ�
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
