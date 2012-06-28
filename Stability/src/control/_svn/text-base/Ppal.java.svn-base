package control;

import java.util.ArrayList;

public class Ppal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenerateStability stab=new GenerateStability("foo","da","gul");
		stab.evaluate();
		System.out.println(stab.getRo());
		System.out.println(stab.getValue());
		ArrayList<SnapshotEval> list=stab.getSnapshots();
		for(SnapshotEval s:list){
			System.out.println();
			System.out.println(s.getUri());
			System.out.println(s.getValue());
			System.out.println(s.getDate());
		}
		

	}

}
