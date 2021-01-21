package collectionsqueue.collectionspriorityqueue;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    public Job dispatchNextJob(Queue<Job> jobs) {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.poll();
    }

    public Queue<Job> addJob(Job... jobs) {
        return new PriorityQueue<Job>(List.of(jobs));
    }
}
