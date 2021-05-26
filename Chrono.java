// Source : https://fr.jeffprod.com/blog/2015/un-chronometre-en-java/

/*
Chrono chrono = new Chrono();
chrono.start(); // démarrage du chrono
// ...
// code à chronométrer
// ...
chrono.pause(); // on peut faire une pause
// ...
chrono.resume(); // reprise du chrono
// ...
chrono.stop(); // arrêt
System.out.println(chrono.getDureeTxt()); // affichage au format "1 h 26 min 32 s"
*/

public class Chrono {

    private long tempsDepart=0;
    private long tempsFin=0;
    private long duree=0;

    public void start()
        {
        tempsDepart=System.currentTimeMillis();
        tempsFin=0;
        duree=0;
        }

    public void stop()
        {
        if(tempsDepart==0) {return;}
        tempsFin=System.currentTimeMillis();
        duree=(tempsFin-tempsDepart);
        tempsDepart=0;
        tempsFin=0;
        }        

    public String getDureeTxt()
        {
            tempsFin=System.currentTimeMillis();
            duree=(tempsFin-tempsDepart);
            duree = duree/1000;
        return timeToHMS(duree);
        }

    public static String timeToHMS(long tempsS) {

        // IN : (long) temps en secondes
        // OUT : (String) temps au format texte : "1 h 26 min 3 s"

        int h = (int) (tempsS / 3600);
        int m = (int) ((tempsS % 3600) / 60);
        int s = (int) (tempsS % 60);

        String r="";

        if(h>0) {r+=h+" j ";}
        if(m>0) {r+=m+" h ";}
        if(s>0) {r+=s+" min";}
        if(h<=0 && m<=0 && s<=0) {r="0 s";}

        return r;
        }

}
