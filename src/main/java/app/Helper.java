package app;

import java.io.*;
import java.net.URL;
import java.util.Set;
import java.util.TreeSet;

public class Helper {

    public static String getWebSite(String link) throws IOException {
        URL otodom = new URL(link);
        BufferedReader in = new BufferedReader(new InputStreamReader(otodom.openStream()));

        String inputLine;
        StringBuffer stringBuffer = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            stringBuffer.append(inputLine);
            stringBuffer.append(System.lineSeparator());
        }
        in.close();
        return stringBuffer.toString();
    }

    public static Set<String> getSetOfLinks(String content) {
        Set<String> setOfLinks = new TreeSet<>();
        for (int i = 0; i < content.length(); i++) {
            i = content.indexOf("https://www.otodom.pl/oferta/", i);
            if (i < 0)
                break;
            String substring = content.substring(i);
            String link = substring.split(".html")[0];
            setOfLinks.add(link);
        }
        return setOfLinks;
    }

    public static void readWebsite(String link, String fileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false));
        String content = getWebSite(link);
        bw.write(content);
        bw.close();
    }

}
