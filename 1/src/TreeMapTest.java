import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {

		// ��ָ��������
		TreeMap<String, String> treeMap1 = new TreeMap<String, String>();
		treeMap1.put("2", "1");
		treeMap1.put("b", "1");
		treeMap1.put("1", "1");
		treeMap1.put("a", "1");
		System.out.println("treeMap1=" + treeMap1);

		// ָ��������
		TreeMap<String, String> treeMap2 = new TreeMap<String, String>(
				new Comparator<String>() {

					/*
					 * int compare(Object o1, Object o2) ����һ���������͵����ͣ� ���ظ�����ʾ��o1
					 * С��o2�� ����0 ��ʾ��o1��o2��ȣ� ����������ʾ��o1����o2��
					 */
					public int compare(String o1, String o2) {

						// ָ�����������ս�������
						return o2.compareTo(o1);
					}
				});
		treeMap2.put("2", "1");
		treeMap2.put("b", "1");
		treeMap2.put("1", "1");
		treeMap2.put("a", "1");
		System.out.println("treeMap2=" + treeMap2);
	}

}
