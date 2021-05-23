import java.util.Random;

// package SoundUp;

public class User{
    private String name;
    private int bpm;

    public User (String name)
    {
        this.name = name;
        bpm = createBpm();
    }

    public User()
    {
        User user = new User( "no name") ;
    }

    //generates the bpm of the user when he starts the run
    public int createBpm()
    {
        Random random = new Random();
        int randomBpm;
        randomBpm = 50 +random.nextInt(90-50); // generates a bpm between 50 and 90
        return randomBpm;
    }

    //udpates the bpm of the user as the race progresses
    public int updateBpm()
    {
        Random random = new Random();
        int randomRateOfChange;

        int lowerBound = -1;
        int upperBound = 5;

        randomRateOfChange = lowerBound +random.nextInt(upperBound - lowerBound); // generates a bpm 
        
        return randomRateOfChange;
    }

    public void displayBpm()
    {
        System.out.println("hello");
    }

    

}