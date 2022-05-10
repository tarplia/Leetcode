import java.util.HashMap;

class Demo {
  static class MyMap {
    static class KeyVal {
      int key;
      int val;
      public KeyVal(int k, int v) {
        key = k;
        val = v;
      }
    }

    KeyVal[] contents;
    int size;

    public MyMap() {
      contents = new KeyVal[200];
      size = 0;
    }

    public int get(int key) {
      for (int i = 0; i < size; i++) {
        if (contents[i].key == key) {
          return contents[i].val;
        }
      }
      return 0;
    }

    public void put(int key, int val) {
      for (int i = 0; i < size; i++) {
        if (contents[i].key == key) {
          contents[i].val = val;
          return;
        }
      }
      contents[size] = new KeyVal(key, val);
      size++;
    }

    public String toString() {
      StringBuffer s = new StringBuffer();
      for (int i = 0; i < size; i++) {
        s.append(contents[i].key + " => " + contents[i].val + " | ");
      }
      return s.toString();
    }
  }

  public static void main(String[] args) {
    HashMap<Integer, Integer> freqs = new HashMap<Integer, Integer>();
    freqs.put(8, 19);
    freqs.put(-28, 0);
    freqs.put(207, 1);
    freqs.put(-28, 23);

    System.out.println(freqs.toString());
    System.out.println("freq of 8 is " + freqs.get(8));
    System.out.println("freq of 207 is " + freqs.get(207));

    System.out.println();

    MyMap myfreqs = new MyMap();
    myfreqs.put(8, 19);
    myfreqs.put(-28, 0);
    myfreqs.put(207, 1);
    myfreqs.put(-28, 23);
    System.out.println(myfreqs);
    System.out.println("freq of 8 is " + myfreqs.get(8));
    System.out.println("freq of 207 is " + myfreqs.get(207));
  }
}
