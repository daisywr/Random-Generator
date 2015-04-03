import java.awt.MouseInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
 
public class random {
	public static void random(int lim) throws InterruptedException{
		try {
		PrintWriter write = new PrintWriter("randomBN.csv", "UTF-8");
		PrintWriter write2 = new PrintWriter("ImpRandom.csv", "UTF-8");
		int count=0;
		int[] resTmp=new int[lim];
		while(count<lim){
			//Thread.sleep(1);
			int x=(int)MouseInfo.getPointerInfo().getLocation().getX();// get x coordinates of mouse position
			int y=x%10%2;//extract the last digit of x coordinate and have the binary digit
			resTmp[count]=y;
			count++;
			System.out.println(count);
		}
		for(int i=0; i<lim;i++){
			write.println(resTmp[i]);//use to evaluate because generate much faster
			//*********next few lines is to do randomly sorting which************** 
			//*********is the final results but quite time consuming***************
			//*********when digits are huge. Evaluation could just be done*********
			//*********by the the first file***************************************
			//System.out.println("Evaluation File Done");
			//write2.println(shuffle(resTmp,lim)[i]);//the final result with random sort.
			//System.out.println("Final File Done");
		}
			write.close();
			write2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int[] shuffle(int[] resTmp, int lim){//shuffle the result array randomly(pseudo), since the velocity
		//of mouse movements could be very slow
		Random rand=new Random();
		int count=0;
		int[] res=new int[lim];
		ArrayList<Integer> rnum= new ArrayList<Integer>();
		while(count!=lim){//get random number with no same on any two
			int n=rand.nextInt(lim)+1;
			if(!rnum.contains(n)){
				count++;
				rnum.add(n-1);
			}
		}
		for(int i=0; i<lim; i++){
			res[i]=resTmp[rnum.get(i)];
		}
		return res;
	}
	public static void main(String[] args) throws InterruptedException{
		int lim=1000000;
		random(lim);
	}
}