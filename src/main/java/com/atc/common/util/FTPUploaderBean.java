package com.atc.common.util;

/**
 * Created by Vic.Feng on 22/12/2015.
 */

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
//import org.apache.commons.net.ProtocolCommandListener;

public class FTPUploaderBean {
    public FTPUploaderBean() {
        super();
    }

    FTPClient ftp = null;


    public FTPUploaderBean(String host, String user, String pwd) throws Exception {
        ftp = new FTPClient();
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        ftp.connect(host);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftp.login(user, pwd);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();
    }


    /**
     * Creates a nested directory structure on a FTP server
     *
     * @param ftpClient an instance of org.apache.commons.net.ftp.FTPClient class.
     * @param dirPath   Path of the directory.
     * @return true if the directory was created successfully, false otherwise
     * @throws IOException if any error occurred during client-server communication
     */
    public static boolean makeDirectories(FTPClient ftpClient, String dirPath) throws IOException {
        String[] pathElements = dirPath.split("/");
        if (pathElements != null && pathElements.length > 0) {

            for (String singleDir : pathElements) {
                if (!singleDir.isEmpty()) {
                    boolean existed = ftpClient.changeWorkingDirectory(singleDir);
                    if (!existed) {
                        boolean created = ftpClient.makeDirectory(singleDir);
                        if (created) {
                            System.out.println("CREATED directory: " + singleDir);
                            ftpClient.changeWorkingDirectory(singleDir);
                        } else {
                            System.out.println("COULD NOT create directory: " + singleDir);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void uploadFile(String localFileFullName, String fileName, String hostDir) throws Exception {
        try {
            InputStream input = new FileInputStream(new File(localFileFullName));
            this.ftp.storeFile(hostDir + fileName, input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadFile(String fileName, String hostDir, InputStream inputStream) throws Exception {
        try {
            this.ftp.storeFile(hostDir + fileName, inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void retreiveFile(String fileName, String hostDir, OutputStream outputStream) throws Exception {
        try {
            this.ftp.retrieveFile(hostDir + fileName, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void disconnect() {
        if (this.ftp.isConnected()) {
            try {
                this.ftp.logout();
                this.ftp.disconnect();
            } catch (IOException f) {
                // do nothing as file is already saved to server
            }
        }
    }


}