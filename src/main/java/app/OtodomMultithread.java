package app;

import java.io.*;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OtodomMultithread {

    //1926

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(30);

        long start = System.currentTimeMillis();

        String webSiteUrl = "https://www.otodom.pl/sprzedaz/mieszkanie/sopot/";
        String content = Helper.getWebSite(webSiteUrl);
        Set<String> setOfLinks = Helper.getSetOfLinks(content);

        for (int i = 0; i < setOfLinks.size(); i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    Helper.readWebsite(setOfLinks.toArray()[finalI].toString(), finalI + ".html");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();

        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

}
