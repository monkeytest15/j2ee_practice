import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

public class SaxParserService extends DefaultHandler {
	private static int INDENT = 2;

	// ����������
	public static void main(String[] argv) {

		String uri = "src/test1.xml";
		try {
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			parserFactory.setValidating(false);
			parserFactory.setNamespaceAware(false);
			SaxParserService MySaxParserInstance = new SaxParserService();
			SAXParser parser = parserFactory.newSAXParser();
			parser.parse(uri, MySaxParserInstance);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
		} catch (FactoryConfigurationError ex) {
			ex.printStackTrace();
		}
	}

	private int idx = 0; // indent

	// ������ַָ�����
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// instantiates s, indents output, prints character values in element
		String s = new String(ch, start, length);
		if (!s.startsWith("\n")) // �յ�value����ӡ
			System.out.println(getIndent() + " Value: " + s);
	}

	// �����ĵ�β
	public void endDocument() throws SAXException {
		idx -= INDENT;
		System.out.println(getIndent() + "end document");

		System.out.println("...PARSING ends");
	}

	// ������β
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		idx -= INDENT;
	}

	// �����ĵ�����ʼ��
	public void startDocument() throws SAXException {
		idx += INDENT;
		System.out.println("PARSING begins...");
		System.out.println(getIndent() + "start document: ");
	}

	// ������ͷ
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		idx += INDENT;
		System.out.println('\n' + getIndent() + "start element: " + qName);
	}

	private String getIndent() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < idx; i++)
			sb.append(" ");
		return sb.toString();
	}

}