public class PersonImpl implements Person {
	// ������Ա����
	private String name;
	private int age;

	// name���Ե� setter����
	public void setName(String name) {
		this.name = name;
	}

	// age���Ե�setter����
	public void setAge(int age) {
		this.age = age;
	}

	// info�������÷��������ڿ���̨��ӡһ���ַ���
	public void info() {
		System.out.println("�ҵ�������:  " + name + " , ��������Ϊ:  " + age);
	}

	// run�������÷���Ҳ�ڿ���̨��ӡһ���ַ�����
	public void run() {
		if (age < 45) {
			System.out.println("�һ����ᣬ����Ѹ��...");
		} else {
			System.out.println("������������ֻ������...");
		}
	}
}