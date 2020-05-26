package Other.知识点;

/*
 *    Coder静态代码块执行 --- Coder构造代码块执行 --- Coder无参空构造执行
 *
 *
 *   BlockTest静态代码块执行 --- BlockTest的主函数执行了 --- Coder静态代码块执行 --- Coder构造代码块执行 --- Coder无参空构造执行
 *   Coder构造代码块执行 --- Coder无参空构造执行
 * 
 */
public class 代码块测试题 {
	static {
		System.out.println("BlockTest静态代码块执行");
	}

	{
		System.out.println("BlockTest构造代码块执行");
	}


	public 代码块测试题(){
		System.out.println("BlockTest无参构造执行了");
	}

	public static void main(String[] args) {
		System.out.println("BlockTest的主函数执行了");
		Coder c = new Coder();
		Coder c2 = new Coder();
	}
}

class Coder {

	static {
		System.out.println("Coder静态代码块执行");
	}

	{
		System.out.println("Coder构造代码块执行");
	}

	public Coder() {
		System.out.println("Coder无参空构造执行");
	}

}
