import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.text.DecimalFormat;

final class TimeGrapher {
    private static final int N_TEST_CASES = 25;

    /**
     * Runs the given TestCaseGenerator, collects the CPU time and displays it visually.
     *
     * @param testCaseGenerator generates test cases
     * @param maxN the maximum size of the test cases
     */
    public static void graphTime(TestCaseGenerator testCaseGenerator, int maxN) {
        int step = maxN / N_TEST_CASES;

        for (int t = 0; t <= N_TEST_CASES; t++) {
            int n = t * maxN / N_TEST_CASES;

            // Run the test case and collect the CPU time taken.
            ThreadMXBean thread = ManagementFactory.getThreadMXBean();
            long startCpu = thread.getCurrentThreadCpuTime();
            testCaseGenerator.runTestCase(n);
            long cpu = thread.getCurrentThreadCpuTime() - startCpu;

            // Visualize the CPU time with vertical bars.
            System.err.printf("N = %7d ", n);
            for (int i = 0; i < (cpu / 10000000); i++) {
                System.err.printf("%c", 0x2502 /* Unicode for a vertical bar */);
            }
            DecimalFormat timeFormatter = new DecimalFormat("0 ms");
            System.err.println(" " + timeFormatter.format(cpu / 1000000));
        }
    }
}
