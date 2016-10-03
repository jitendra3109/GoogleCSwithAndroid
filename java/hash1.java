import java.util.*;
/*
public class hash1
  {
  public static void main( String[] args )
    {
    HashSet set = new HashSet();
    set.add( new Integer( 6 ) );
    set.add( new Integer( 1 ) );
    set.add( new Integer( 4 ) );
    System.out.println( set );
    System.out.println();

    

    

    System.out.println( "Show that duplicates cannot be added." );
    Object value = set.add( new Integer( 8 ) );
    if ( value != null )
      System.out.println( "Could not add 8." );
    else
      {
      System.out.println( "Added 8" );
      System.out.println( "New contents are " + set );
      }

     Object value = set.add( new Integer( 2 ) );
    if ( value != null )
      System.out.println( "Could not add 2." );
    else
      {
      System.out.println( "Added 2." );
      System.out.println( "New contents are " + set );
      }
    }
  }  */

public class hash1{
	public static void main(String[] args) {
		//System.out.println(Q26.q26.ans);
     Scanner in=new Scanner(System.in);
     String str1=in.nextLine();
   
     String [] words =str1.split("");
     HashSet<String> uniq=new HashSet<String>();
     for (String word :words ) {
      	uniq.add(word);

      }
       
System.out.println(uniq);
	}
}

