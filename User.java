// Class User

import java.util.Random;

// package SoundUp;

public class User{
    private String name;
    private int bpm;
    private int age;
    private int indexAverageBpm=0;
    private int averageLastBpm;
    private int[] bpmMatrix = new int[5];

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
    public int updateBpmOneTime(int lowerBound, int upperBound)
    {
        Random random = new Random();
        int randomRateOfChange;

        //int lowerBound = -1;
        //int upperBound = 5;

        randomRateOfChange = lowerBound +random.nextInt(upperBound - lowerBound); // generates a bpm 
        
        return bpm+randomRateOfChange;
    }

    public void displayBpm()
    {
        System.out.println("Bpm : " + bpm);
    }
    public void displayAverage()
    {
        System.out.println("Average : " + averageLastBpm);
    }

    public void updateBpm()
    {
        int millis = 1500;
        for (int i = 0; i< 20; i++)
        {
            try
            {
                Thread.sleep(millis);
            }
            catch(InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }

            if (bpm<100)
            {
                bpm = updateBpmOneTime(-1, 5);
            }
            if (bpm>=100 && bpm<140)
            {
                bpm = updateBpmOneTime(-1, 2);
            }
            if (bpm>=140 && bpm<223-age)
            {
                bpm = updateBpmOneTime(-1, 0);
            }
            
            displayBpm();
            updateAverageBpm(bpm);

            if (i>5)
            {
                displayAverage();
            }
                
        }
    }

    public void updateAverageBpm(int newBpm)
    {
        bpmMatrix[indexAverageBpm] = newBpm;

        int sum=0;
        for (int i= 0; i<5; i++)
        {
            sum += bpmMatrix[i];
        }
        averageLastBpm =(int) sum/5;

        indexAverageBpm = indexAverageBpm+1;
        indexAverageBpm = indexAverageBpm%5;

    }

    

}