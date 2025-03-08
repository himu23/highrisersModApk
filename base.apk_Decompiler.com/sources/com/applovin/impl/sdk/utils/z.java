package com.applovin.impl.sdk.utils;

import android.util.Xml;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class z {
    /* access modifiers changed from: private */
    public Stack<a> aWD;
    /* access modifiers changed from: private */
    public StringBuilder aWE;
    /* access modifiers changed from: private */
    public long aWF;
    /* access modifiers changed from: private */
    public a aWG;
    /* access modifiers changed from: private */
    public final x logger;

    z(n nVar) {
        if (nVar != null) {
            this.logger = nVar.BN();
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    public static y e(String str, n nVar) throws SAXException {
        return new z(nVar).dM(str);
    }

    public y dM(String str) throws SAXException {
        if (str != null) {
            this.aWE = new StringBuilder();
            this.aWD = new Stack<>();
            this.aWG = null;
            Xml.parse(str, new ContentHandler() {
                public void endPrefixMapping(String str) {
                }

                public void ignorableWhitespace(char[] cArr, int i, int i2) {
                }

                public void processingInstruction(String str, String str2) {
                }

                public void setDocumentLocator(Locator locator) {
                }

                public void skippedEntity(String str) {
                }

                public void startPrefixMapping(String str, String str2) {
                }

                public void startDocument() {
                    x unused = z.this.logger;
                    if (x.Fn()) {
                        z.this.logger.f("XmlParser", "Begin parsing...");
                    }
                    long unused2 = z.this.aWF = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                }

                public void endDocument() {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - z.this.aWF;
                    x unused = z.this.logger;
                    if (x.Fn()) {
                        x a = z.this.logger;
                        a.f("XmlParser", "Finished parsing in " + seconds + " seconds");
                    }
                }

                public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
                    try {
                        a aVar = !z.this.aWD.isEmpty() ? (a) z.this.aWD.peek() : null;
                        a aVar2 = new a(str2, z.this.a(attributes), aVar);
                        if (aVar != null) {
                            aVar.c(aVar2);
                        }
                        z.this.aWD.push(aVar2);
                    } catch (Exception e) {
                        x unused = z.this.logger;
                        if (x.Fn()) {
                            x a = z.this.logger;
                            a.c("XmlParser", "Unable to process element <" + str2 + ">", e);
                        }
                        throw new SAXException("Failed to start element", e);
                    }
                }

                public void endElement(String str, String str2, String str3) {
                    z zVar = z.this;
                    a unused = zVar.aWG = (a) zVar.aWD.pop();
                    z.this.aWG.dN(z.this.aWE.toString().trim());
                    z.this.aWE.setLength(0);
                }

                public void characters(char[] cArr, int i, int i2) {
                    String trim = new String(Arrays.copyOfRange(cArr, i, i2)).trim();
                    if (StringUtils.isValidString(trim)) {
                        z.this.aWE.append(trim);
                    }
                }
            });
            a aVar = this.aWG;
            if (aVar != null) {
                return aVar;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }

    /* access modifiers changed from: private */
    public Map<String, String> a(Attributes attributes) {
        if (attributes == null) {
            return Collections.emptyMap();
        }
        int length = attributes.getLength();
        HashMap hashMap = new HashMap(length);
        for (int i = 0; i < length; i++) {
            hashMap.put(attributes.getQName(i), attributes.getValue(i));
        }
        return hashMap;
    }

    private static class a extends y {
        a(String str, Map<String, String> map, y yVar) {
            super(str, map, yVar);
        }

        /* access modifiers changed from: package-private */
        public void dN(String str) {
            this.JN = str;
        }

        /* access modifiers changed from: package-private */
        public void c(y yVar) {
            if (yVar != null) {
                this.SG.add(yVar);
                return;
            }
            throw new IllegalArgumentException("None specified.");
        }
    }
}
