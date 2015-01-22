package by.bsu.project.settings;

import java.io.File;

/**
 * Holds global settings used when running Sherlock; these should not need to
 * be changed unless a substantial modification to the algorithm is
 * implemented.
 *
 * @author Ben Hart
 * @author Mike Joy
 * @author Ashley Ward
 * @author Weiliang Zhang
 * @version 6 Sep 2002
 */
public class Settings {

    public static String FOLDER_PATH = "";

  /**
   * Number of file types.
   */
  public final static int NUMBEROFFILETYPES = 9;

  /**
   * Numeric value for the original.
   */
  public final static int ORI = 0;

  /**
   * Numeric value for the normalised.
   */
  public final static int NOR = 1;

  /**
   * Numeric value for the nowhile.
   */
  public final static int NOW = 2;

  /**
   * Numeric value for the nocomment.
   */
  public final static int NOC = 3;

  /**
   * Numeric value for the nocomment and normalised.
   */
  public final static int NCN = 4;

  /**
   * Numerica value for the no comment no white.
   */
  public final static int NCW = 5;

  /**
   * Numeric value for the comment.
   */
  public final static int COM = 6;

  /**
   * Numeric value for the sentence-based free-text parser.
   */
  public final static int SEN = 7;

  /**
   * Numeric value for the tokenised files.
   */
  public final static int TOK = 8;

   /**
   * The directory that holds the source code to be compared.
   */
  public static File sourceDirectory = null;

  /**
   * The string that is the file separator on this file system.
   */
  public static String fileSep = "";

  /**
   * Flag to say where messages go.
   */
  public static boolean runningGUI = true;

  /**
   * Flag ot say whether to print debug messages or not.
   */
  static boolean debug = false;

  /**
   * List of files that needs to be processed.
   */
  public static File[] fileList = null;

  /**
   * Log file.
   */
  public static File logFile = new File(System.getProperty("user.home"),
                                 "sherlock.log");

  /**
   * Return the list of files to be processed. This list does not give path
   * information at all because it is used just in SameLines.java and
   * the path data is automatically generated in that class.
   */
  public static String[] getStringFileList() {
    String[] list = new String[fileList.length];
    for (int i = 0; i < fileList.length; i++) {
      list[i] = fileList[i].getName();
    }
    return list;
  }

  /**
   * Return the list of files to be processed.
   */
  public static File[] getFileList() {
    return fileList;
  }

  /**
   * Debug message - only print if we are debugging.
   *
   * @param debugMsg the debug message to be printed
   */
  public static void debugMessage(String debugMsg) {
    if (debug) {
      message(debugMsg);
    }
  } // debugMessage


  /**
   * Take a message and print it where appropriate.
   *
   * @param msg the message to be printed
   */
  public static void message(String msg) {
    if (runningGUI) {
//      TextWindow.messages.append(msg + "\n");
//      TextWindow.messages.setCaretPosition
//          (TextWindow.messages.getDocument().getLength());
    }
    else {
      System.out.println(msg);
    }
  } // message



  public static File getSourceDirectory() {
    return sourceDirectory;
  }


} // Settings
