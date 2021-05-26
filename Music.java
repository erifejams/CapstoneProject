// Class Music
import java.io.*;
import java.util.Scanner;

public class Music {
    private String name;
    private int bpm;
    private String author;
    private final int timing = 20;
    
    
    // constructor
    public Music (String name, int bpm, String author)
    
    {
        this.name = name;
        this.bpm = bpm;
        this.author = author;
    }
    
    // default constructor
    public Music()
    {
        Music music = new Music("no name", 0, "no author");
    }
    
    public void setName(String newName)
    {
        name = newName;
    }            
    
    public String getName()
    {
        return name;
    }
    
    public void setAuthor(String newAuthor)
    {
        author = newAuthor;
    }            
    
    public String getAuthor()
    {
        return author;
    }
    
    public void setBpm(int newBpm)
    {
        bpm = newBpm;
    }            
    
    public int getBpm()
    {
        return bpm;
    }

    public void readFile()
    {
        try
        {
            File musicList = new File ("HighSales.txt");
            Scanner input = new Scanner(musicList);
            while(input.hasNext())
            {
                String nameMusic = input.nextLine();
                String authorMusic = input.nextLine();
                int bpmMusic = input.nextInt();
               // Music music = new Music ();
            }
        }
        catch(FileNotFoundException e )
        {
            System.out.println(e.getMessage());
        }
    }
}
