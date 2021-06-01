// Main method

import java.io.*;
import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class SoundUp {
    public static void main(String[] args) throws FileNotFoundException{
        User charlotte = new User ("Charlotte");
        charlotte.displayBpm();
        charlotte.updateBpm();
        


        //////////////////////////////////THIS IS CODE TO PLAY THE MUSIC FOR THE HIGH BPM///////////////////////////////////////////
        ArrayList<Music> musicArray = new ArrayList<Music>();
        try
        {
            
            File HighmusicFile = new File ("HighBpmMusic.txt");
            Scanner input = new Scanner(HighmusicFile);
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
                //System.out.println();
            }
            input.close();
        }
        catch(FileNotFoundException e )
        {
            System.out.println(e.getMessage());
        }

        /*
        for (int i = 0; i<musicArray.size() ; i++)
        {
            musicArray.get(i).displayMusic();
        }
        */


        //////////////////////////////////THIS IS CODE TO PLAY THE MUSIC FOR THE MIDDLE BPM///////////////////////////////////////////
        ArrayList<Music> musicArray2 = new ArrayList<Music>();
        try
        {

            File MiddlemusicFile = new File ("MiddleBpmMusic.txt");
            Scanner input2 = new Scanner(MiddlemusicFile);
            while(input2.hasNextLine() )
            {
                String nameMusic2 = input2.nextLine();
                String authorMusic2 = input2.nextLine();
                String tpm2 = input2.nextLine();
                int bpmMusic2 = Integer.parseInt(tpm2);
                Music music2 = new Music (nameMusic2, bpmMusic2, authorMusic2);
                musicArray2.add(music2);
                //System.out.println();
            }
            input2.close();
        }
        catch(FileNotFoundException e )
        {
            System.out.println(e.getMessage());
        }


        //////////////////////////////////THIS IS CODE TO PLAY THE MUSIC FOR THE LOW BPM///////////////////////////////////////////

        ArrayList<Music> musicArray3 = new ArrayList<Music>();
        try
        {
            File LowmusicFile = new File ("LowBpmMusic.txt");
            Scanner input3 = new Scanner(LowmusicFile);
            while(input3.hasNextLine())
            {
                String nameMusic3 = input3.nextLine();
                String authorMusic3 = input3.nextLine();
                String tpm3 = input3.nextLine();
                int bpmMusic3 = Integer.parseInt(tpm3);
                Music music3 = new Music (nameMusic3, bpmMusic3, authorMusic3);
                musicArray3.add(music3);
                //System.out.println();
            }
            input3.close();
        }
        catch(FileNotFoundException e )
        {
            System.out.println(e.getMessage());
        }



        ///////////////////THIS IS THE CODE TO PLAY THE DIFFERENT MUSIC BASED ON THE BPM OF THE USER//////////////////
        int toPlayMusicBpm;  //to get the bpm of the user, so i can use to detemine the song
        toPlayMusicBpm = charlotte.sendBpm();


        System.out.println("This is charlotte's bpm "  + toPlayMusicBpm);
        Random random = new Random();

        if (toPlayMusicBpm<100){
            int index = random.nextInt(musicArray.size());
            for(int i = 0; i <= musicArray.size(); i++){
                if(i == index){
                    System.out.println("this song is " +  musicArray3.get(i).getName() + " by " + musicArray3.get(i).getAuthor()); 
                }
            }
        }else if (toPlayMusicBpm>=100 && toPlayMusicBpm<140){
            //pick at random from middle bpm list
            int index = random.nextInt(musicArray.size());
            for(int i = 0; i <= musicArray.size(); i++){
                if(i == index){
                    System.out.println("this song is " +  musicArray2.get(i).getName() + " by " + musicArray2.get(i).getAuthor()); 
                }
            }
        }else if (toPlayMusicBpm>=140 && toPlayMusicBpm<223){
            //pick at random from high bpm list
            int index = random.nextInt(musicArray.size());
            for(int i = 0; i <= musicArray.size(); i++){
                if(i == index){
                    System.out.println("this song is " +  musicArray.get(i).getName() + " by " + musicArray.get(i).getAuthor()); 
                }
            }
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
