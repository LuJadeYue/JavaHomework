package Package3;
// Introduced in Chapter 1
/** Beetle with parts for the Beetle game. */
public class Beetle {

  /** True if this Beetle has a body. */
  private boolean body;

  /** Number of eyes this Beetle has, from 0-2. */
  private int eyes;

  /** Number of feelers this Beetle has, from 0-2. */
  private int feelers;

  /** True if this Beetle has a head. */
  private boolean head;

  /** Number of legs this Beetle has, from 0-6. */
  private int legs;

  /** True if this Beetle has a tail. */
  private boolean tail;

  /** A new Beetle has no parts. */
  public Beetle() {
    body = false;
    eyes = 0;
    feelers = 0;
    head = false;
    legs = 0;
    tail = false;
  }
 
  /** Try to add a body and return whether this succeeded. */
  public boolean addBody() {
    if (body) {
      return false;
    } else {
      body = true;
      return true;
    }
  }

  /** Try to add an eye and return whether this succeeded. */
  public boolean addEye() {
    if (head && (eyes < 2)) {
      eyes++;
      return true;
    } else {
      return false;
    }
  }

  /** Try to add a head and return whether this succeeded. */
  public boolean addHead() {
    if (body && !head) {
      head = true;
      return true;
    } else {
      return false;
    }
  }
      
  /** Try to add a feeler and return whether this succeeded. */
  public boolean addFeeler() {
    if (head && (feelers < 2)) {
      feelers++;
      return true;
    } else {
      return false;
    }
  }

  /** Try to add a leg and return whether this succeeded. */
  public boolean addLeg() {
    if (body && (legs < 6)) {
      legs++;
      return true;
    } else {
      return false;
    }
  }
  
  /** Try to add a tail and return whether this succeeded. */
  public boolean addTail() {
    if (body && !tail) {
      tail = true;
      return true;
    } else {
      return false;
    }
  }

  // Added in Chapter 2
  /** Return true if that Beetle has the same parts as this one. */
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (that == null) {
      return false;
    }
    if (getClass() != that.getClass()) {
      return false;
    }
    Beetle thatBeetle = (Beetle)that;
    return body == thatBeetle.body
      && eyes == thatBeetle.eyes
      && feelers == thatBeetle.feelers
      && head == thatBeetle.head
      && legs == thatBeetle.legs
      && tail == thatBeetle.tail;
  }

  /** Return true if this Beetle has all of its parts. */
  public boolean isComplete() {
    return body && (eyes == 2) && (feelers == 2)
      && head && (legs == 6) && tail;
  }
  
  public String toString() {
    if (body) {
      String result = "";
      if (feelers > 0) {
        result += "\\";
        if (feelers == 2) {
          result += " /";
        }
        result += "\n";
      }
      if (head) {
        if (eyes > 0) {
          result += "o";
        } else {
          result += " ";
        }
        result += "O";
        if (eyes == 2) { result += "o"; }
        result += "\n";
      }
      if (legs > 0) {
        result += "-";
      } else {
        result += " ";
      }
      result += "#";
      if (legs > 1) {
        result += "-";
      }
      result += "\n";
      if (legs > 2) {
        result += "-";
      } else {
        result += " ";
      }
      result += "#";
      if (legs > 3) {
        result += "-";
      }
      result += "\n";
      if (legs > 4) {
        result += "-";
      } else {
        result += " ";
      }
      result += "#";
      if (legs > 5) {
        result += "-";
      }
      if (tail) {
        result += "\n v";
      }
      return result;
    } else {
      return "(no parts yet)";
    }
  }

}
