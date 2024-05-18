
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
      
        System.out.println("-----------------SRT-----------------");
        srt();
       
    }
    
   

    
    public static void srt()
    {
        CPUScheduler srt = new ShortestRemainingTime();
        srt.add(new Row("P1", 8, 1));
        srt.add(new Row("P2", 5, 1));
        srt.add(new Row("P3", 2, 7));
        srt.add(new Row("P4", 4, 3));
        srt.add(new Row("P5", 2, 8));
        srt.add(new Row("P6", 4, 2));
        srt.add(new Row("P7", 3, 5));
        srt.process();
        display(srt);
    }
    
    public static void display(CPUScheduler object)
    {
        System.out.println("Process\tAT\tBT\tWT\tTAT");

        for (Row row : object.getRows())
        {
            System.out.println(row.getProcessName() + "\t" + row.getArrivalTime() + "\t" + row.getBurstTime() + "\t" + row.getWaitingTime() + "\t" + row.getTurnaroundTime());
        }
        
        System.out.println();
        
        for (int i = 0; i < object.getTimeline().size(); i++)
        {
            List<Event> timeline = object.getTimeline();
            System.out.print(timeline.get(i).getStartTime() + "(" + timeline.get(i).getProcessName() + ")");
            
            if (i == object.getTimeline().size() - 1)
            {
                System.out.print(timeline.get(i).getFinishTime());
            }
        }
        
        System.out.println("\n\nAverage WT: " + object.getAverageWaitingTime() + "\nAverage TAT: " + object.getAverageTurnAroundTime());
    }
}
