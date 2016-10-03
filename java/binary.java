import java.util.*;

public class binary{

	public static void main(String[] args) {
		int[] array ={1,2,3,4,5,6,7,8};
		int i,j,k,n,m,a,b;
	    int len=array.length;   //System.out.println(len);
         Random rand=new Random();
         int no = rand.nextInt(len);  
	    int search=array[no];
	    System.out.println("This no we want to search = "+search);
	    int first=0,last=len,mid=0;
	    for (i=0;i<len/2 ;i++) {
	    	  mid=(first+last)/2;
	       if(search > array[mid]){
	       	first=mid+1;
	       }
	       else if(search<array[mid]){
	       	last=mid-1;
	       }
	       else if(search!=array[mid] && mid ==0){
	       	System.out.println("Don't have this item in my array");
	       }
	       else if(search==array[mid]){
	       	 System.out.println("Yes you get it "+search);
	       	break;
	       }
	    }


	}
}