package TwoHeap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ScheduleTask {
    public static int tasks(List<List<Integer>> tasksList) {
        int optimalMachines = 0;

        PriorityQueue<int[]> machinesAvailable = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> tasksQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

       for (List<Integer> task : tasksList)
           tasksQueue.add(new int[]{task.get(0), task.get(1)});

       while (!tasksQueue.isEmpty()) {
           int[] task = tasksQueue.poll();
           int[] currentMachine = null;

           if (!machinesAvailable.isEmpty() && task[0] >= machinesAvailable.peek()[0]){
               currentMachine = machinesAvailable.poll();
               currentMachine[0] = task[1];
           } else {
               optimalMachines += 1;
               currentMachine = new int[]{task[1], optimalMachines};
           }

           machinesAvailable.add(currentMachine);
       }
        return optimalMachines;
    }
}
