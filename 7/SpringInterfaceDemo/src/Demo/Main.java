package Demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {

        Resource res = new ClassPathResource("Demo/bean.xml");
        BeanFactory ft = new XmlBeanFactory(res);

        Hello h = (Hello) ft.getBean("hello");

        Random r1 = h.getRandom();
        Random r2 = h.getRandom();
        System.out.println("û�в���Lookup����ע�룺");
        System.out.println("Random ������ʵ��ָ��ͬһ�����ã�" + (r1 == r2));
        r1.printRandom();
        r2.printRandom();

        Random r3 = h.createRandom();
        Random r4 = h.createRandom();
        System.out.println("����Lookup����ע�룺");
        System.out.println("Random ������ʵ��ָ��ͬһ�����ã�" + (r3 == r4));
        r3.printRandom();
        r4.printRandom();
        
        //��ʹ�ó�����
        Random r5=h.createRandom1();
        Random r6=h.createRandom1();
        System.out.println("û�в���Lookup����ע�룺");
        System.out.println("Random ������ʵ��ָ��ͬһ�����ã�" + (r5 == r6));
        r5.printRandom();
        r6.printRandom();

    }

}  