import org.springframework.aop.AfterReturningAdvice;
import java.lang.reflect.Method;

public class MyAfterAdvice implements AfterReturningAdvice
{
 //ʵ��AfterReturningAdvice�ӿڱ���ʵ��afterReturning�������÷�������Ŀ�귽��
 //���ý������Զ������á�
     public void afterReturning(Object returnValue, Method m, Object[] args, Object target)throws Throwable
 {
  System.out.println("�������ý���...");
System.out.println("Ŀ�귽���ķ���ֵ�� : " + returnValue);
  System.out.println("Ŀ�귽���� : " + m);
  System.out.println("Ŀ�귽���Ĳ����� : " + args);
  System.out.println("Ŀ������� : " + target);
    }
}