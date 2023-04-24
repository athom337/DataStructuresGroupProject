package Manager;
public class LinkedEntry {

    private String key;
    private PassEntry value;
    private LinkedEntry next;

    LinkedEntry(String key, PassEntry value) 
    {
          this.key = key;
          this.value = value;
          this.next = null;
    }



    public PassEntry getValue() 
    {
          return value;
    }



    public void setValue(PassEntry value) 
    {
          this.value = value;
    }



    public String getKey() 
    {
          return key;
    }



    public LinkedEntry getNext() 
    {
          return next;
    }


    public void setNext(LinkedEntry next) 
    {
          this.next = next;
    }

}