package test.algorithm.stackandqueue;

public class Hanoi2 {
    /**
    * 
    * @param num ���ӵ���Ŀ
    * @param left Դ��
    * @param mid ������
    * @param right Ŀ����
    * 
    * ��⵱���� N ���ʱ�򣬴�ӡ�����ƶ����̺������ƶ��ܲ��������õݹ飩
    * 
    * ��ŵ������2��
    * �޸�һ����Ϸ�������Ʋ��ܴ���������ֱ���ƶ������Ҳ࣬Ҳ���ܴ����Ҳ�����ƶ�������࣬�����뾭���м������
    * 
    * ��⣺����� N ���������ϵ��¼�Ϊ 1 - N�� 
    * 
    * ��� N �������ڡ��󡱣�ϣ��ȫ���ƶ������С����������£�ͬ����-->����-->�ң���-->�С� ͬ�����Էֽ�Ϊ������
    * 	�ٽ� 1~N-1 ��ӡ����ƶ������ҡ�
    * 	�ڽ��� N ��ӡ����ƶ������С�
    * 	�۽� 1~N-1 ��ӡ��ҡ��ƶ������С�
    * 
    * ��� N �������ڡ��󡱣�ϣ��ȫ���ƶ������ҡ����������£�ͬ����-->��
    * 	�ٽ� 1~N-1 ��ӡ����ƶ������ҡ�
    * 	�ڽ� N ��ӡ����ƶ������С�
    * 	�۽� 1~N-1 ��ӡ��ҡ��ƶ�������
    * 	�ܽ� N ��ӡ��С��ƶ������ҡ�
    * 	�ݽ� 1~N-1 ��ӡ����ƶ������ҡ�
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
