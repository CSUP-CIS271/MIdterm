public class Book implements Comparable<Book>{

  private String title;
  private String authorFName;
  private String authorLName;

  public Book(){}

  public Book(String t, String fn, String ln){
    this.title=t;
    this.authorFName=fn;
    this.authorLName=ln;
  }

  public void setTitle(String t){
    this.title=t;
  }

  public void setFirstName(String fn){
    this.authorFName=fn;
  }

  public void setLastName(String ln){
    this.authorLName=ln;
  }

  public String getTitle(){
      return title;
    }

    public String getFirstName(){
      return authorFName;
    }

    public String getLastName(){
      return authorLName;
    }

    public String toString(Book b){
      return b.getTitle()+" written by: "+b.getFirstName()+" "+b.getLastName();
    }

    public String toString(){
      return title+" written by: "+authorFName+" "+authorLName;
    }

    public int compareTo(Book other){
      if(this.authorLName.compareTo(other.getLastName())==0)
        return this.authorFName.compareTo(other.getFirstName());
      else
        return this.authorLName.compareTo(other.getLastName());
    }
}
