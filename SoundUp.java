// Main method

import java.io.*;
import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class SoundUp {
    public static void main(String[] args){
        //  User charlotte = new User ("Charlotte");
        //  charlotte.displayBpm();
        //  charlotte.updateBpm();
        
        ArrayList<Music> musicArray = new ArrayList<Music>();
        try
        {
            
            File musicFile = new File ("musics.txt");
            Scanner input = new Scanner(musicFile);
            while(input.hasNextLine())
            {
              //  System.out.println("PAS DE PROBLEME");
                String nameMusic = input.nextLine();
                //System.out.println(nameMusic);
                String authorMusic = input.nextLine();
                //System.out.println(authorMusic);
                String tpm = input.nextLine();
                int bpmMusic = Integer.parseInt(tpm);
                //System.out.println(bpmMusic);
                Music music = new Music (nameMusic, bpmMusic, authorMusic);
                musicArray.add(music);
            }
            input.close();
        }
        catch(FileNotFoundException e )
        {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i<musicArray.size() ; i++)
        {
            musicArray.get(i).displayMusic();
        }

        Chrono chrono = new Chrono();
        chrono.start(); // démarrage du chrono
        try
            {
                Thread.sleep(2000);
            }
            catch(InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }
        
        System.out.println(chrono.getDureeTxt());
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }
        System.out.println(chrono.getDureeTxt());

    }

    

}
