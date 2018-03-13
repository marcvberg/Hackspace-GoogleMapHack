package com.example.marcvandenberg.googlemaphack;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.util.Xml;

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Created by marcvandenberg on 1/12/18.
 */

public class TestProcess {

    private HashMap<String, String[]> mNodeDat = new HashMap<>();

    private HashMap<String, List<String>> mWayDat = new HashMap<>();

    public String mVal = "";

    public TestProcess(InputStream is){
        try {

            XmlPullParser xpp = Xml.newPullParser();
            xpp.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            xpp.setInput(is, null);
            xpp.nextTag();

            xpp.require(XmlPullParser.START_TAG, null, "feed");

            List entries = new ArrayList();

            while (xpp.next() != XmlPullParser.END_TAG) {
                if (xpp.getEventType() != XmlPullParser.START_TAG){
                    continue;
                }

                String name = xpp.getName();
                if (name.equals("way") || name.equals("node")){
                    entries.add(readEntry(xpp));
                }
            }

            /*Element root = document.getRootElement();

            List<Element> nodes = root.getChildren("node");
            List<Element> ways = root.getChildren("way");

            for(int i = 0; i < nodes.size(); i++){
                String[] piece = {nodes.get(i).getAttributeValue("lat"),nodes.get(i).getAttributeValue("lon")};
                mNodeDat.put(nodes.get(i).getAttributeValue("id"),piece);
            }

            for(int i = 0; i < ways.size(); i++){
                List<Element> nodeRef = ways.get(i).getChildren("nd");
                List<String> refs = new ArrayList<>();
                for(int j = 0; j < nodeRef.size(); j++){
                    refs.add(nodeRef.get(j).getAttributeValue("ref"));
                }

                mWayDat.put(ways.get(i).getAttributeValue("id"), refs);
            }*/
            is.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        finally{
        }


    }

    private

    public HashMap<String, List<String>> GetWays(){
        return mWayDat;
    }

    public HashMap<String, String[]> GetNodes(){
        return mNodeDat;
    }

}
