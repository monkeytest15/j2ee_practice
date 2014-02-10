package mypack;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

public class Customer implements Serializable {

    private Long id;

    private String name;

    private Set orders=new HashSet();

    public Customer(String name, Set orders) {
        this.name = name;
        this.orders = orders;
    }

    public Customer() {
    }

    public Customer(Set orders) {
        this.orders = orders;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getOrders() {
        return this.orders;
    }

    public void setOrders(Set orders) {
        this.orders = orders;
    }

}







/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<��ͨHibernate��Java����־û��������>>  *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
