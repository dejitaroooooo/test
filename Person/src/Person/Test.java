package Person;

public class Test {
	public static void main(String[] args){


		/*
		Person taro = new Person();
		taro.name = "山田太郎";
		taro.age = 20;
		System.out.println(taro.name);
		System.out.println(taro.age);

		Person jiro = new Person();
		jiro.name = "木村次郎";
		jiro.age = 18;
		System.out.println(jiro.name);
		System.out.println(jiro.age);

		Person hanako = new Person();
		hanako.name = "鈴木花子";
		hanako.age = 16;
		System.out.println(hanako.name);
		System.out.println(hanako.age);

		taro.talk();
		taro.walk();
		taro.run();
		*/

		/*インスタンス化演習課題？*/
		System.out.println("インスタンス化演習課題");
		Robot aibo = new Robot();
		aibo.name = "aibo";
		aibo.walk();

		Robot asimo = new Robot();
		asimo.name = "アシモ";
		asimo.talk();

		Robot pepper = new Robot();
		pepper.name = "ペッパー君";
		pepper.run();

		Robot doraemon = new Robot();
		doraemon.name = "ドラえもん";
		doraemon.walk();
		doraemon.talk();
		doraemon.run();

		/*
		Person taro = new Person();
		taro.name="taro";
		taro.age=18;
		System.out.println(taro.name);
		System.out.println(taro.age);

		Person jiro = new Person("jiro",20);
		System.out.println(jiro.name);
		System.out.println(jiro.age);
		*/

		/*コンストラクタ演習課題*/
		System.out.println("\r\nコンストラクタ演習課題");
		Person saburo = new Person("saburo");
		System.out.println(saburo.name);
		System.out.println(saburo.age);

		Person nameless = new Person(25);
		System.out.println(nameless.name);
		System.out.println(nameless.age);

		Person hanako = new Person(17,"hanako");
		System.out.println(hanako.name);
		System.out.println(hanako.age);


	}
}
