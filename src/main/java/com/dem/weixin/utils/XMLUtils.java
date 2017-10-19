package com.dem.weixin.utils;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by DEM on 2017/5/5.
 */
public class XMLUtils {
    /**
     * 给XML文件追加一段内容
     *
     * @param xml          XML文件对象
     * @param appendingXml 需要插入的内容
     * @throws Exception
     */
    public static void appendXML(File xml, String appendingXml) throws Exception {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(xml);
        Document flagment = DocumentHelper.parseText(appendingXml);
        Element flagEle = flagment.getRootElement();
        flagEle.setQName(new QName(flagEle.getName(), doc.getRootElement()
                .getNamespace()));
        if (flagEle.elements().size() > 0) {
            for (Object c : flagEle.elements()) {
                Element cel = (Element) c;
                cel.setQName(new QName(cel.getName(), flagEle.getNamespace()));
            }
        }
        doc.getRootElement().add(flagEle);
        XMLWriter writer = new XMLWriter(new FileWriter(xml));
        writer.write(doc.getRootElement());
        writer.close();
    }

    public static File[] getFileList(){
        File root = new File("C:\\Users\\DEM\\Desktop\\area");
        File[] files = root.listFiles();
        return files;
    }

    public static void deleteElement(String fileStr ) throws Exception{

        File file = new File(fileStr);
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        Element root = document.getRootElement();
        List<Element> cityList = root.elements("city");
        for (Element city : cityList) {
            List<Element> countyList = city.elements("county");
            for (Element county : countyList) {
                List<Element> townList = county.elements("town");
                for (Element town : townList) {
                    List<Element> villageList = town.elements("village");
                    for (Element village : villageList) {
                        town.remove(village);
//
                    }
                }
            }

        }

        FileWriter fileWriter = new FileWriter(fileStr);//获得文件输入流
        OutputFormat outPrint = OutputFormat.createPrettyPrint();//创建输入流的打印格式,当前是树形格式,还有一个紧凑格式(OutputFormat.createCompactFormat())
        XMLWriter writer = new XMLWriter(fileWriter, outPrint);
        writer.write(document);//写入数据
        writer.close();//字符流必须关闭否则数据将缓存在内存中
        ;
    }

    public static void addFile(File file) throws Exception{
        SAXReader saxReader1 = new SAXReader();
        Document document1 = saxReader1.read("C:\\Users\\DEM\\Desktop\\area\\result.xml");
        Element root1= document1.getRootElement();
        SAXReader saxReader2 = new SAXReader();
        Document document2 = saxReader2.read(file);
        Element root2= document1.getRootElement();
        List<Element> provinces = root2.elements("province");
        for (Element province : provinces) {
            Node node = document1.node(0);
            
            int i = document1.nodeCount();
            System.out.println(i);
        }
        FileWriter fileWriter = new FileWriter("C:\\Users\\DEM\\Desktop\\area\\result.xml");//获得文件输入流
        OutputFormat outPrint = OutputFormat.createPrettyPrint();//创建输入流的打印格式,当前是树形格式,还有一个紧凑格式(OutputFormat.createCompactFormat())
        XMLWriter writer = new XMLWriter(fileWriter, outPrint);
        writer.write(document1);//写入数据
        writer.close();//字符流必须关闭否则数据将缓存在内存中

    }


    public static void main(String[] args) throws Exception {
        File[] fileList = getFileList();

        addFile(new File("C:\\Users\\DEM\\Desktop\\area\\12.xml"));


      /*  for (File file : fileList) {
//            System.out.println(file.getPath());
            deleteElement(file.getPath());
        }*/

    }
}
