package logic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//Singleton -> falls jemand mehrere tabs öffnen sollte
public class Scrapping {

    private static Scrapping INSTANCE;

    private String actURL;

    //Teil eines Versuches die ideale thread.sleep-zeit zu finden
    //private int lastChange;
    //private String lastURL;

    private Scrapping(){
        actURL = "";
        //lastChange = 0;
        //lastURL = "";
    }

    public static Scrapping getINSTANCE(){
        if (Scrapping.INSTANCE == null){
            Scrapping.INSTANCE = new Scrapping();
        }
        return INSTANCE;
    }

    public String getActURL(){
        return actURL;
    }

    //Started Thread welcher jede Sekunde sich die Daten vom Server holt
    public void scrapThread(){
        new Thread(() -> {
            try {
                for (;;) {

                    Scrapping.getINSTANCE().scrap();
                    System.out.println("Scrapped succesfully: "+Scrapping.getINSTANCE().getActURL());
                    Thread.sleep(1000);
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        }).run();
    }


    //Gleiche methode wie beim client
    private void scrap(){

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

            this.actURL = source;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
