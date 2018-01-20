package com.example.marcvandenberg.googlemaphack;

import android.content.res.AssetManager;

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 * Created by marcvandenberg on 1/12/18.
 */

public class TestProcess {

    private HashMap<String, String[]> mNodeDat = new HashMap<>();

    private HashMap<String, List<String>> mWayDat = new HashMap<>();

    public String mVal = "";

    public TestProcess(){
        try {
            InputStream is = getClass().getResourceAsStream("map.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(is);
            /*
            Element root = document.getRootElement();

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

        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch (org.jdom2.JDOMException e){
            e.printStackTrace();
        }


    }

    public HashMap<String, List<String>> GetWays(){
        return mWayDat;
    }

    public HashMap<String, String[]> GetNodes(){
        return mNodeDat;
    }

}
