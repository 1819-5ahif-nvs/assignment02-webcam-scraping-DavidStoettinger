package client;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main {

    private static Logger LOGGER;



    public static void main(String [] args)
    {
        //erstellt neuen logger
        LOGGER = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            // configuriert in logger und dessen formatierer
            //system.getProperty("user.dir") => gibt aktuellen pfad des projektes an
            fh = new FileHandler(
                    System.getProperty("user.dir")+"/log.log");

            LOGGER.addHandler(fh);
            //definiert format für logger
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            //keine info in der console
            LOGGER.setUseParentHandlers(false);



            //= while(true)
            for(;;) {
                scrap();
                Thread.sleep(1000);
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }


    private static void scrap(){

        Document doc = null;
        Element video = null;
        String source = null;
        try{
            //holt sich den html code von der website
            doc = Jsoup.connect("https://webtv.feratel.com/webtv/?cam=5132&design=v3&c0=0&c2=1&lg=en&s=0").userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").get();
            //holt sich das field "fer_video"
            video = doc.getElementById("fer_video");
            //holt sich von dem field "source" den wert vom ersten "src" attribut
            source = video.select("source").first().attr("src");
        }catch(Exception e){
            e.printStackTrace();
        }

        //fügt daten zum logger hinzu
        System.out.println(source);
        LOGGER.info(source);
    }


}
