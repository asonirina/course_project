package by.bsu.project.javacc.utol;

import by.bsu.project.general.model.AttributeCounting;
import by.bsu.project.javacc.general.ParseException;
import by.bsu.project.javacc.parser.white.White;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;

/**
 * User: iason
 * Date: 22.04.15
 */
public class SpacesExtractor {
    private static Logger logger = Logger.getLogger(SpacesExtractor.class);
    private White white;

    public SpacesExtractor (byte source[]) {
        white = new White(new ByteArrayInputStream(source));
    }

    public void extractSpaces(AttributeCounting ac) {
        try {
            white.Input();
            ac.setSpaces(100* white.getSpaces()/white.getLineNo());
            ac.setTabs(100* white.getTabs()/white.getLineNo());

        } catch (ParseException ex) {
            logger.error(ex.getMessage());
        }
    }
}
