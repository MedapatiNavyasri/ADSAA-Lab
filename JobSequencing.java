import java.util.*;

class JobSequencing {

    static class Job {
        int id, deadline, profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    static void jobSequencing(Job jobs[], int n) {

        // sort by profit descending
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }

        int[] slot = new int[maxDeadline];
        Arrays.fill(slot, -1);

        int totalProfit = 0;

        for (int i = 0; i < n; i++) {

            for (int j = jobs[i].deadline - 1; j >= 0; j--) {

                if (slot[j] == -1) {
                    slot[j] = jobs[i].id;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        System.out.println("Selected Jobs:");
        for (int i = 0; i < maxDeadline; i++) {
            if (slot[i] != -1)
                System.out.print("J" + slot[i] + " ");
        }

        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of jobs:");
        int n = sc.nextInt();

        Job jobs[] = new Job[n];

        System.out.println("Enter deadline and profit:");

        for (int i = 0; i < n; i++) {
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(i + 1, deadline, profit);
        }

        jobSequencing(jobs, n);
    }
}