/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author charl
 */
public class Playlist {
    private ArrayList<Music> playlist1;
    private ArrayList<Music> playlist2;
    private ArrayList<Music> playlist3;
    
    public Playlist()
    {
        playlist1 = readPlaylist1();
        playlist2 = readPlaylist2();
        playlist3 = readPlaylist3();
    }
    
    
    public ArrayList<Music> readPlaylist1() {
        //////////////////////////////////THIS IS CODE TO PLAY THE MUSIC FOR THE HIGH BPM///////////////////////////////////////////
        ArrayList<Music> musicArray = new ArrayList<Music>();
        try {

            File HighmusicFile = new File("HighBpmMusic.txt");
            Scanner input = new Scanner(HighmusicFile);
            while (input.hasNextLine()) {
                //  System.out.println("PAS DE PROBLEME");
                String nameMusic = input.nextLine();
                //System.out.println(nameMusic);
                String authorMusic = input.nextLine();
                //System.out.println(authorMusic);
                String tpm = input.nextLine();
                int bpmMusic = Integer.parseInt(tpm);
                //System.out.println(bpmMusic);
                Music music = new Music(nameMusic, bpmMusic, authorMusic);
                musicArray.add(music);
                //System.out.println();
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return musicArray;
    }

    public ArrayList<Music> readPlaylist2() {

        //////////////////////////////////THIS IS CODE TO PLAY THE MUSIC FOR THE MIDDLE BPM///////////////////////////////////////////
        ArrayList<Music> musicArray2 = new ArrayList<Music>();
        try {

            File MiddlemusicFile = new File("MiddleBpmMusic.txt");
            Scanner input2 = new Scanner(MiddlemusicFile);
            while (input2.hasNextLine()) {
                String nameMusic2 = input2.nextLine();
                String authorMusic2 = input2.nextLine();
                String tpm2 = input2.nextLine();
                int bpmMusic2 = Integer.parseInt(tpm2);
                Music music2 = new Music(nameMusic2, bpmMusic2, authorMusic2);
                musicArray2.add(music2);
                //System.out.println();
            }
            input2.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return musicArray2;

    }

    public ArrayList<Music> readPlaylist3() {
        //////////////////////////////////THIS IS CODE TO PLAY THE MUSIC FOR THE LOW BPM///////////////////////////////////////////

        ArrayList<Music> musicArray3 = new ArrayList<Music>();
        try {
            File LowmusicFile = new File("LowBpmMusic.txt");
            Scanner input3 = new Scanner(LowmusicFile);
            while (input3.hasNextLine()) {
                String nameMusic3 = input3.nextLine();
                String authorMusic3 = input3.nextLine();
                String tpm3 = input3.nextLine();
                int bpmMusic3 = Integer.parseInt(tpm3);
                Music music3 = new Music(nameMusic3, bpmMusic3, authorMusic3);
                musicArray3.add(music3);
                //System.out.println();
            }
            input3.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return musicArray3;
    }
    
    public void chooseMusic (User user)
    {
         ///////////////////THIS IS THE CODE TO PLAY THE DIFFERENT MUSIC BASED ON THE BPM OF THE USER//////////////////
        int toPlayMusicBpm;  //to get the bpm of the user, so i can use to detemine the song
        toPlayMusicBpm = user.sendBpm();
        if (toPlayMusicBpm<100){
            int index = (int)(Math.random() * ((playlist3.size()) + 1));
            for(int i = 0; i <= playlist3.size(); i++){
                if(i == index){
                    System.out.println("this song is " +  playlist3.get(i).getName() + " by " + playlist3.get(i).getAuthor()); 
                }
            }
        }else if (toPlayMusicBpm>=100 && toPlayMusicBpm<140){
            //pick at random from middle bpm list
            int index = (int)(Math.random() * ((playlist2.size()) + 1));
            for(int i = 0; i <= playlist2.size(); i++){
                if(i == index){
                    System.out.println("this song is " +  playlist2.get(i).getName() + " by " + playlist2.get(i).getAuthor()); 
                }
            }
        }else if (toPlayMusicBpm>=140 && toPlayMusicBpm<223){
            //pick at random from high bpm list
            int index = (int)(Math.random() * ((playlist1.size()) + 1));
            for(int i = 0; i <= playlist1.size(); i++){
                if(i == index){
                    System.out.println("this song is " +  playlist1.get(i).getName() + " by " + playlist1.get(i).getAuthor()); 
                }
            }
        }
    }
    
    
}
