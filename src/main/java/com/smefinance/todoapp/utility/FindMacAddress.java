package com.era.eswift.utility;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.InputStream;

@Slf4j
public class FindMacAddress {

    public final static String getMacAddress(String HostOS, String IPAddress) throws Exception {
        log.info("HostOS: "+HostOS);
        log.info("IPAddress: "+IPAddress);

        String OS = System.getProperty("os.name");
        Process ping = Runtime.getRuntime().exec("ping -n 3 " + IPAddress);
        Process arp = null;
        String outStream = "";
        StringBuffer buffer = new StringBuffer();
        try {
            if (HostOS.equals("SERVER")) {
                if (OS.startsWith("Windows")) {
                    arp = Runtime.getRuntime().exec("arp -a " + IPAddress);
                } else if (OS.startsWith("Linux")) {
                    arp = Runtime.getRuntime().exec("arp " + IPAddress);
                } else if (OS.startsWith("Solaris")) {
                    arp = Runtime.getRuntime().exec("arp " + IPAddress);
                } else {
                    outStream = "Unknown Operating System: " + OS;
                }
            } else if (HostOS.equals("CLIENT")) {
                if (OS.startsWith("Windows")) {
                    arp = Runtime.getRuntime().exec("nbtstat -A " + IPAddress);
                } else if (OS.startsWith("Linux")) {
                    arp = Runtime.getRuntime().exec("arp " + IPAddress);
                } else if (OS.startsWith("Solaris")) {
                    arp = Runtime.getRuntime().exec("arp " + IPAddress);
                } else {
                    outStream = "Unknown Operating System: " + OS;
                }
            } else {
                outStream = "Command not working.";
            }
            InputStream inStream = new BufferedInputStream(arp.getInputStream());
            for (;;) {
                int c = inStream.read();
                if (c == -1) {
                    break;
                }
                buffer.append((char) c);
            }
            outStream = buffer.toString();
            inStream.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return outStream;
    }

}
