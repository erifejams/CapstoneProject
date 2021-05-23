// Class Music

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
}
