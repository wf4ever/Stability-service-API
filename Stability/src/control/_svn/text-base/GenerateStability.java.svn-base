package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import checklists.ChecklistEval;

public class GenerateStability {
	

	private String ro;
	private String minim;
	private String purpose;
	private double value;
	private ArrayList<SnapshotEval> snapshots;
	
	public GenerateStability(String ro,String minim, String purpose){
		this.ro=ro;
		//this.ro="http://www.wf4ever-project.com/fakeRO";
		this.minim=minim;
		this.purpose=purpose;
		snapshots=new ArrayList<SnapshotEval>();
	}
	
	//aquí debería meterse la info del minim y el checklist que se va a usar
	public void evaluate(){
		//de momento lo generamos random
		//hacer petición a minim (necesitamos RO, minim y purpose)
		//fillSnapshotsRandom();
		fillSnapshotsHandCrafted();
		calculateValue();
	}

	private void fillSnapshotsHandCrafted() {
		ChecklistEval chk=new ChecklistEval();
		addCase(chk,ro,minim,purpose);
		addCase(chk,"http://andros.zoo.ox.ac.uk/aleix/ro-catalogue/v0.1/wf74-repeat-fail/",minim,"Repeatable");
		addCase(chk,"http://andros.zoo.ox.ac.uk/aleix/ro-catalogue/v0.1/wf74-repeat-fail/",minim,"Reviewable");
		
		
	}

	private void addCase(ChecklistEval chk, String ro, String minim, String purpose) {
		try {
			SnapshotEval s=new SnapshotEval("snapshot//"+ro);
			double value=chk.getEvaluation(ro, minim, purpose);
			s.setValue(value);
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c1 = Calendar.getInstance();
			s.setDate(formatDate.format(c1.getTime()));
			snapshots.add(s);
		} catch (IOException e) {e.printStackTrace();}
		
	}

/*	private void fillSnapshotsRandom() {
		Random r=new Random();
		int numSnapshots=r.nextInt(10)+1;
		String fakeUriRoot="http://www.wf4ever-project.com/fakeRO/snapshot/";
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c1 = Calendar.getInstance(); 
		
		for (int i=0; i<numSnapshots; i++){
			SnapshotEval s=new SnapshotEval(fakeUriRoot+i);
			c1.add(Calendar.DATE,3);//add days
			s.setDate(formatDate.format(c1.getTime()));
			fakeValue(s);
			snapshots.add(s);
		}
		
	}
*/
	private void fakeValue(SnapshotEval s) {
		Random r=new Random();
		double value=r.nextDouble();
		s.setValue(value);
	}
	
	private void calculateValue() {
		double acum=0;
		double media=0;
		int cont=0;
		for(SnapshotEval s:snapshots){
			acum=acum+Math.pow(s.getValue(),2);
			media=media+s.getValue();
			cont++;
		}
		media=media/cont;
		acum=(acum/cont)-Math.pow(media, 2);
		acum=Math.sqrt(acum);
		this.value=1-acum;
		
	}
	
	public String getRo() {
		return ro;
	}

	public double getValue() {
		return value;
	}

	public ArrayList<SnapshotEval> getSnapshots() {
		return snapshots;
	}

}
