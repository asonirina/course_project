package by.bsu.project.utils;

/**
 * User: Irina
 */
public class TimeChecker  implements Checker{


    @Override
    public int compileFile(Process process) throws InterruptedException{
        return process.waitFor();
    }
}
