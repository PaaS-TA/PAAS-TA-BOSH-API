package org.openpaas.paasta.bosh.code;

public class BoshCode {
    public static String INSTANCE_STATE_START = "started";
    public static String INSTANCE_STATE_DETACHED = "detached";

    public static class ContentsType{
        public static String Applicationjavascript = "Application/javascript";
        public static String ApplicationJson  = "Application/json";
        public static String MultipartFormdata  = "multipart/form-data";
        public static String TextYaml= "text/yaml";
        public static String TextXml = "text/xml";
        public static String TextHtml = "text/html";
        public static String ApplicationXml = "Application/xml";
        public static String MultipartRelated = "Multipart/related";
        public static String ApplicationXFixedRecord = "Application/X-FixedRecord";
    }


}
