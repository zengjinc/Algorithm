package design_pattern;

/**
 * 单例模式
 */
public class Singleton {
	
	private static Singleton singleton;
	
	private Singleton(){}
	
	public static Singleton getSingleton(){
		if(singleton == null){
			synchronized (Singleton.class) {
				if(singleton == null){
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
	
	public static void main(String[] args) {
		Singleton test = Singleton.getSingleton();
		
		System.out.println(test);
	}
	
}
