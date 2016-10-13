package gurdat;

import java.util.Scanner;

public class Hanoi_Puzzle {
	
	  public static void main(String[] args) {
		  @SuppressWarnings("resource")
		Scanner user_input = new Scanner(System.in);
		  System.out.print("How many disk(s) are there on the orginal tower? ");
		    int disks = user_input.nextInt();
		    doTowers(disks, 'A', 'B', 'C');
		  }

		  public static void doTowers(int topN, char from, char inter, char to) {
		    if (topN == 1){
		      System.out.println("Disk 1 from " + from + " to " + to);
		    }else {
		      doTowers(topN - 1, from, to, inter);
		      System.out.println("Disk " + topN + " from " + from + " to " + to);
		      doTowers(topN - 1, inter, from, to);
		    }
		  }
		}