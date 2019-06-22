package com.student.oclass.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.student.oclass.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * 一个版本描述Activity, 包含一个ListView, 点击列表后出现每个版本的人员参与的Dialog
 * @author huangyebiaoke
 * @email huangyebiaoke@outlook.com
 */
public class VersionActivity extends BaseActivity {
    ListView listView;
    String[] data=null;
    NodeList nodeList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);
        listView=findViewById(R.id.listview_version);
        try {
            InputStream is=getAssets().open("version_information.xml");
            DocumentBuilderFactory dBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dBuilderFactory.newDocumentBuilder();
            Document document = dBuilder.parse(is);
            Element element=(Element) document.getDocumentElement();
            nodeList=element.getElementsByTagName("version");
            data=new String[nodeList.getLength()];
            Log.d("safsfa", "onCreate: "+nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element version= (Element) nodeList.item(i);
                data[i]=version.getAttribute("id");
                Log.d("safsfa", "onCreate: "+data[i]);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                VersionActivity.this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Element version=(Element) nodeList.item(position);
                AlertDialog.Builder builder=new AlertDialog.Builder(VersionActivity.this);
                builder.setTitle("版本信息")
                        .setMessage("需求分析：" +version.getElementsByTagName("request").item(0).getTextContent()+
                                "\n功能设计：" +version.getElementsByTagName("function").item(0).getTextContent()+
                                "\n后台编码：" +version.getElementsByTagName("end").item(0).getTextContent()+
                                "\n前台编码：" +version.getElementsByTagName("front").item(0).getTextContent()+
                                "\nUI设计：" +version.getElementsByTagName("ui").item(0).getTextContent()+
                                "\n测试："+version.getElementsByTagName("test").item(0).getTextContent())
                        .create().show();
            }
        });


    }

}
