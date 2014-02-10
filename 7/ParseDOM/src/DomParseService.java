import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//������Ҫ��org.xml.sax������
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParseService {

    public DomParseService(){
        //��1���õ�DOM�������Ĺ���ʵ��
        DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance();
        //�õ�javax.xml.parsers.DocumentBuilderFactory;���ʵ����������Ҫ�Ľ���������
        try {
            //��2����DOM�������DOM������
            DocumentBuilder dombuilder=domfac.newDocumentBuilder();
            //ͨ��javax.xml.parsers.DocumentBuilderFactoryʵ���ľ�̬����newDocumentBuilder()�õ�DOM������
            //��3����Ҫ������XML�ĵ�ת��Ϊ���������Ա�DOM������������
            InputStream is=new FileInputStream("src/test1.xml");            
            //��4������XML�ĵ������������õ�һ��Document
            Document doc=dombuilder.parse(is);
            //��XML�ĵ����������õ�һ��org.w3c.dom.Document�����Ժ�Ĵ����Ƕ�Document������е�
            //��5���õ�XML�ĵ��ĸ��ڵ�
            Element root=doc.getDocumentElement();
            //��DOM��ֻ�и��ڵ���һ��org.w3c.dom.Element����
            //��6���õ��ڵ���ӽڵ�
            NodeList books=root.getChildNodes();
            
            if(books!=null){
                for(int i=0;i<books.getLength();i++){
                    Node book=books.item(i);
                    if(book.getNodeType()==Node.ELEMENT_NODE){
                        //��7��ȡ�ýڵ������ֵ
                        String email=book.getAttributes().getNamedItem("email").getNodeValue();
                        System.out.println(email);
                        //ע�⣬�ڵ������Ҳ�������ӽڵ㡣���Ľڵ�����Ҳ��Node.ELEMENT_NODE
                        //��8����ѭ�ӽڵ�
                        for(Node node=book.getFirstChild();node!=null;node=node.getNextSibling()){
                            if(node.getNodeType()==Node.ELEMENT_NODE){
                                if(node.getNodeName().equals("name")){
                                    String name=node.getNodeValue();
                                    String name1=node.getFirstChild().getNodeValue();
                                    System.out.println(name);
                                    System.out.println(name1);
                                }
                                if(node.getNodeName().equals("price")){
                                    String price=node.getFirstChild().getNodeValue();
                                    System.out.println(price);
                                }
                            }
                        }
                    }
                }//��6��������һ��org.w3c.dom.NodeList�ӿ�������������ӽڵ�ģ�����һ����ѭ�ӽڵ�ķ����������н���
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DomParseService();
    }
}