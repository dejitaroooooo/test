package Person;

public class Capsule {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Person taro = new Person("山田太郎",20);

		//System.out.println(taro.name);//taro.nameはprivate変数のため参照できずエラーとなる
		System.out.println(taro.getName());
	}

}
