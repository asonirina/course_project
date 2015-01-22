package by.bsu.project.model;

import java.io.Serializable;

/**
 * <p>A class representing a link between a sentence and another sentence.
 * Can be sorted on the similarity score. Can be marked as ignored if the
 * results should be displayed without regard to this score.</p>
 * <p>Title: Sherlock 2000</p>
 * <p>Description: Plagiarism Detection Software</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: University of Warwick</p>
 * @author Daniel White
 * @version 4
 */
public class SentenceScore
    implements Serializable, Comparable, Cloneable {
  /** The name of the document this object links to */
  public String name;
  /** The ID of the sentence this object links to */
  public int id;
  /** The score of the link represented by this object */
  public byte score;
  // Whether the link is ignored.
  private boolean ignore = false;

  /**
   * Constructor.
   * @param name The name of the file linked to.
   * @param id The id of the sentence within that file.
   * @param score The similarity score between these two sentences.
   */
  SentenceScore(String name, int id, byte score) {
    this.name = name;
    this.id = id;
    this.score = score;
  }

  /**
       * Returns a shallow clone of this object. There are no mutable fields in this
   * Object.
   * @return A shallow clone of this object.
   */
  public Object clone() {
    try {
      return super.clone();
    }
    catch (CloneNotSupportedException ex) {
      return null;
    }
  }

  /**
   * Used to sort links in order of their score.
   * @param o The object to compare to.
   * @return A negative score if this object is larger, zero if they are the
   * same and a positive score if this object is smaller.
   */
  public int compareTo(Object o) {
    SentenceScore temp = (SentenceScore) o;
    // if(ignore && !temp.ignore)
    //  return -1;
    if (temp.ignore && !ignore) {
      return -1;
    }
    if (temp.score < score) {
      return -1;
    }
    else if (temp.score == score) {
      return 0;
    }
    else { // if temp.score > score in other words.
      return 1;
    }

  }

  /**
   * Two SentenceScore objects are equal iff they have equal name, id, score
   * and ignore fields.
   * @param o The object to compare to this one.
   * @return true if they are equal, false otherwise
   */
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (! (o instanceof SentenceScore)) {
      return false;
    }

    SentenceScore temp = (SentenceScore) o;
    return name.equals(temp.name) && temp.id == id && temp.score == score &&
        temp.ignore == ignore;
  }

  /**
   * Is this link ignored?
   * @return Whether the links is ignored or not
   */
  public boolean isIgnored() {
    return ignore;
  }

  /**
   * A new value for the ignored field.
   * @param val The new value for the ignored field.
   */
  protected void setIgnored(boolean val) {
    ignore = val;
  }
}
