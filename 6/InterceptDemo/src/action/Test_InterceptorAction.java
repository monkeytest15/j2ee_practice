package action;

import com.opensymphony.xwork2.ActionSupport;  

public class Test_InterceptorAction extends ActionSupport    
{  
      
    private String username;  
  
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
      
      
    public String execute() throws Exception  
    {  
        return SUCCESS;  
    }  
      
    public String test() throws Exception  
    {  
          
        System.out.println("��ʱ������������ϣ��Ѿ�������action�е�test����");  
        return SUCCESS;  
    }  
  
}  