# Operating System
Shortest Remaining Time Scheduling Algorithm(SRT)
Shortest Remaining Time (SRT) scheduling algorithm, is a CPU scheduling algorithm used in operating systems. It is a preemptive version of the Shortest Job Next (SJN) algorithm, also known as Shortest Job First (SJF).

In SRT the process with the smallest estimated run-time to completion is selected for execution. If a new process arrives with an even shorter run-time  the currently executing process is preempted and put back into the ready queue. This ensures that the process with the shortest remaining time is always given priority.

The main advantage of the SRT algorithm is that it minimizes the average waiting time for processes leading to better overall system throughput and responsiveness. However, it can suffer from the potential for process starvation if short processes continually arrive preventing longer processes from ever executing.

Overall SRT is particularly useful in situations where there is a mix of short and long CPU-bound processes as it aims to minimize the turnaround time for processes by prioritizing shorter ones.

