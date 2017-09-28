public class Vector {

  // instance vars
  
  Object[] eD; // elementData]
  int eC; // element count

  
  // constructors
  
  public Vector() {
    this(10); // Calls deeper constructor
  }

  public Vector(int initialCap) {
    eD = new Object[initialCap];
    eC = 0;
  }

  
  // instance methods
  
  public int size() {
    return eC;
  }

  public boolean isEmpty() {
    return eC == 0;
  }

  public Object get(int index) {
    return eD[index];
  }

  public Object set(int index, Object obj) {
    Object temp = eD[index];
    eD[index] = obj;
    return temp;
  }

  // add object to end of vector, extend cap if needed
  public void add(Object obj) {
    checkLength();
    eD[eC] = obj;
    eC++;
  }

  public void add(int index, Object obj) {
    checkLength();
    for(int i = eC - 1; i >= index; i--) {
      eD[i+1] = eD[i];
    }
    eD[index] = obj;
    eC++;
  }

  void checkLength() {
    if(size() <= eD.length) {
      int newCap = eD.length * 2;
      Object[] newData = new Object[newCap];
      for(int i = 0; i < newCap; i++) {
        newData[i] = eD[i];
      }
    }
  }
}
