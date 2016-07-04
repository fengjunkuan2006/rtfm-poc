package com.atc.common.util;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import java.io.BufferedReader;import java.io.InputStream;import java.io.InputStreamReader;import java.io.OutputStream;import java.net.HttpURLConnection;import java.net.URL;/** * Created by Vic.Feng on 16/12/2015. */public final class HttpRequestUtil {    private static final Logger logger = LoggerFactory.getLogger(HttpRequestUtil.class);    private HttpRequestUtil() {    }    /**     * Send http request     *     * @param requestUrl    URL     * @param requestMethod Request method (GET or POST)     * @param outputStr     Data     * @return String       Returned data     */    public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {        final StringBuffer buffer = new StringBuffer();        try {            final URL url = new URL(requestUrl);            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();            httpUrlConn.setDoOutput(true);            httpUrlConn.setDoInput(true);            httpUrlConn.setUseCaches(false);            // Set request method (GET or POST)            httpUrlConn.setRequestMethod(requestMethod);            if ("GET".equalsIgnoreCase(requestMethod))                httpUrlConn.connect();            // Add the data            if (null != outputStr && !outputStr.equals("")) {                final OutputStream outputStream = httpUrlConn.getOutputStream();                // Set the charset                outputStream.write(outputStr.getBytes("UTF-8"));                outputStream.close();            }            // Convert the result to string            InputStream inputStream = httpUrlConn.getInputStream();            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);            String str = null;            while ((str = bufferedReader.readLine()) != null) {                buffer.append(str);            }            bufferedReader.close();            inputStreamReader.close();            // Release resources            inputStream.close();            inputStream = null;            httpUrlConn.disconnect();        } catch (Exception e) {            logger.error(e.getMessage());        }        return buffer.toString();    }    public static String getRequest(String requestUrl) {        return httpRequest(requestUrl, "GET", null);    }    public static String postRequest(String requestUrl, String outputStr) {        return httpRequest(requestUrl, "POST", outputStr);    }}