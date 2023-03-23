package org.example;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Question25 {

    File file;
    Document document;



    public Question25(String uri) throws ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();

        this.file = new File(uri);
        try {
            this.document = parser.parse(file);
        } catch (SAXException e) {
            System.out.println("SAXException");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("IOException");
            throw new RuntimeException(e);
        }
    }

    public void insert() throws SQLException, ClassNotFoundException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtech","root","anodas2002");
        Statement statement = connection.createStatement();

        Element root = document.getDocumentElement();
        System.out.println(root);

        NodeList questions = root.getChildNodes();

        System.out.println(questions.getLength());

//        for (int i = 0; i < questions.getLength(); i++) {
//            Node node = questions.item(i);
//            System.out.println(node.getNodeName());
//            if(node.getNodeType()==Node.ELEMENT_NODE){
//                System.out.println(node.getFirstChild().getTextContent());
//            }
//
//        }

        statement.close();
        connection.close();
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParserConfigurationException, IOException, SAXException {
        Question25 question25 = new Question25("C:\\Users\\ANOMITRO\\IdeaProjects\\JavaAndXML\\src\\main\\java\\org\\example\\question_q25.xml");
        question25.insert();
    }
}