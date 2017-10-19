package com.dem.weixin.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * Created by DEM on 2017/5/6.
 */
public class UniteXML {
    public static Document getDocument(InputStream is){
        Document doc=null;
        try {
            doc=new SAXReader().read(is);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return doc;
    }
    public static InputStream getInputStream(String path){
        File f=new File(path);
        if(!f.exists()){
            return null;
        }
        InputStream is=null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return is;
    }



    public Element getSubElement(Document doc,String tagName){
        Element el=(Element)doc.selectSingleNode("//"+tagName);
        return el;
    }


    public void writeXML(Document doc,String fileName){
        try {
            XMLWriter writer=new XMLWriter(new FileWriter(fileName));
            writer.write(doc);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public Document unitXMl(String path1,String path2,String tagName1,String tagName2,boolean isContain){
        Document doc1=getDocument(getInputStream(path1));
        Document doc2=getDocument(getInputStream(path2));

        Element elSub2=getSubElement(doc2,tagName2);
        Element elSub1=getSubElement(doc1,tagName1);

        if(isContain){
//   doc1.getRootElement().appendContent(elSub2.getParent());//直接插入的根标签下
            elSub1.appendContent(elSub2.getParent());//插入到tagName1标签下
        }else{
//   doc1.getRootElement().appendContent(elSub2);
            elSub1.appendContent(elSub2);
        }
        return doc1;
    }

    public static void main(String[] args) {
        UniteXML ux=new UniteXML();
//将c标签下所有内容插入到aa标签下，若参数设为true则可将c标签上一级下的所有内容插入到aa标签下
        Document doc=ux.unitXMl("C:\\Users\\DEM\\Desktop\\area\\11.xml", "C:\\Users\\DEM\\Desktop\\area\\12.xml", "province", "province", false);
        ux.writeXML(doc, "C:\\Users\\DEM\\Desktop\\area\\result.xml");
    }


}
