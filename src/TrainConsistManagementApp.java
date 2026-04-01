import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class Bogie {
        String id;
        int capacity;

        Bogie(String id, int capacity) {
            this.id = id;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC13 - Performance Comparison ");
        System.out.println("==========================================\n");

        // 1. Prepare a large dataset (10,000 bogies)
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("B-" + i, (i % 100)));
        }

        // 2. Measure Loop Performance
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterWithLoop(bogies, 60);
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;

        // 3. Measure Stream Performance
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterWithStream(bogies, 60);
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        // 4. Display Results
        System.out.println("Results Count (Loop): " + loopResult.size());
        System.out.println("Results Count (Stream): " + streamResult.size());
        System.out.println("\nExecution Time (Nanoseconds):");
        System.out.println("Traditional Loop: " + loopDuration + " ns");
        System.out.println("Java Streams    : " + streamDuration + " ns");

        System.out.println("\nConclusion: " + (loopDuration < streamDuration ? "Loop was faster." : "Stream was faster."));
    }

    // Logic for Loop Filtering
    public static List<Bogie> filterWithLoop(List<Bogie> list, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : list) {
            if (b.capacity > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    // Logic for Stream Filtering
    public static List<Bogie> filterWithStream(List<Bogie> list, int threshold) {
        return list.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }
}