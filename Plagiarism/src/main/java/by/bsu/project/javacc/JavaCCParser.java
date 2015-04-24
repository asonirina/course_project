package by.bsu.project.javacc;

import by.bsu.project.javacc.general.ParseException;

import java.util.List;

/**
 * User: iason
 * Date: 24.04.15
 */
public interface JavaCCParser {
    public List<String> getNodes();
    public void Input() throws ParseException;
}
