package by.bsu.project.utils;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Irina
 * Date: 16.03.13
 * Time: 13:50
 * To change this template use File | Settings | File Templates.
 */
public class TimeChecker  implements Checker{


    @Override
    public int compileFile(Process process) throws InterruptedException{
        return process.waitFor();
    }
}
