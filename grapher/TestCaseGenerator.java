/** Implemented by an algorithm tester that runs a program against generated test cases. */
public interface TestCaseGenerator {
    /**
     * Runs a program against a generated test case.
     *
     * @param n the input size of the test case
     */
    public void runTestCase(int n);
}
