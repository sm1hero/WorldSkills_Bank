package com.example.worldskills_bank;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

public class XmlParse {

    public String getValueFromXML(String data, String value) {
        String result = null;



        return result;
    }

    private XmlPullParser prepareXpp(String data) throws XmlPullParserException {

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);

        XmlPullParser xpp = factory.newPullParser();

        xpp.setInput(new StringReader(data));

        return xpp;
    }


}
