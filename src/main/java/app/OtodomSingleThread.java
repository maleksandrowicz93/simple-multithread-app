package app;

import java.io.*;
import java.util.Set;

public class OtodomSingleThread {

    //61111

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        String webSiteUrl = "https://www.otodom.pl/sprzedaz/mieszkanie/sopot/";
        String content = Helper.getWebSite(webSiteUrl);
        Set<String> setOfLinks = Helper.getSetOfLinks(content);

        for (int i = 0; i < setOfLinks.size(); i++) {
            Helper.readWebsite(setOfLinks.toArray()[i].toString(), i + ".html");
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

}
