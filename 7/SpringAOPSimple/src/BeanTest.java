import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class BeanTest
{
    public static void main(String[] args)throws Exception
{
  //����Spring����
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/ApplicationContext.xml");
  //��ȡ�������
  Person p = (Person)ctx.getBean("person");
  //ִ��info����
  p.info();
         System.out.println("===========================================");
  //ִ��run����
  p.run();
    }
}
