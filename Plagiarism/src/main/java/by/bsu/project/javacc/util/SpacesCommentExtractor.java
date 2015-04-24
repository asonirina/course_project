package by.bsu.project.javacc.util;

import by.bsu.project.general.model.AttributeCounting;
import by.bsu.project.javacc.general.ParseException;
import by.bsu.project.javacc.parser.comment.Comment;
import by.bsu.project.javacc.parser.white.White;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;

/**
 * User: iason
 * Date: 22.04.15
 */
public class SpacesCommentExtractor {
    private static Logger logger = Logger.getLogger(SpacesCommentExtractor.class);
    private White white;
    private Comment comment;

    public SpacesCommentExtractor (byte source[]) {
        white = new White(new ByteArrayInputStream(source));
        comment = new Comment(new ByteArrayInputStream(source));
    }

    public void extractSpaces(AttributeCounting ac) {
        try {
            white.Input();
            ac.setSpaces(white.getSpaces());
            ac.setTabs(white.getTabs());
            ac.setLines(white.getLineNo());

            comment.Input();
            ac.setComments(comment.getCommentLength());

        } catch (ParseException ex) {
            logger.error(ex.getMessage());
        }
    }
}
