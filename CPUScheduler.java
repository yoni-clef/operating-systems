import java.util.ArrayList;
import java.util.List;

public abstract class CPUScheduler
{
    private final List<Row> rows; // List to store process information
    private final List<Event> timeline; // List to store the scheduling timeline events
    private int timeQuantum; // Time quantum for scheduling algorithms that need it
    
    public CPUScheduler()
    {
        rows = new ArrayList(); // Initialize the list of processes
        timeline = new ArrayList(); // Initialize the timeline of events
        timeQuantum = 1; // Default time quantum
    }
    
    public boolean add(Row row)
    {
        return rows.add(row); // Add a process to the list
    }
    
    public void setTimeQuantum(int timeQuantum)
    {
        this.timeQuantum = timeQuantum; // Set the time quantum
    }
    
    public int getTimeQuantum()
    {
        return timeQuantum; // Get the current time quantum
    }
    
    public double getAverageWaitingTime()
    {
        double avg = 0.0;
        
        for (Row row : rows)
        {
            avg += row.getWaitingTime(); // Sum all waiting times
        }
        
        return avg / rows.size(); // Calculate average waiting time
    }
    
    public double getAverageTurnAroundTime()
    {
        double avg = 0.0;
        
        for (Row row : rows)
        {
            avg += row.getTurnaroundTime(); // Sum all turnaround times
        }
        
        return avg / rows.size(); // Calculate average turnaround time
    }
    
    public Event getEvent(Row row)
    {
        for (Event event : timeline)
        {
            if (row.getProcessName().equals(event.getProcessName()))
            {
                return event; // Return the event corresponding to the given process
            }
        }
        
        return null; // Return null if no matching event is found
    }
    
    public Row getRow(String process)
    {
        for (Row row : rows)
        {
            if (row.getProcessName().equals(process))
            {
                return row; // Return the row corresponding to the given process name
            }
        }
        
        return null; // Return null if no matching row is found
    }
    
    public List<Row> getRows()
    {
        return rows; // Get the list of all processes
    }
    
    public List<Event> getTimeline()
    {
        return timeline; // Get the list of all timeline events
    }
    
    public abstract void process(); // Abstract method to be implemented by subclasses for processing
}
 
