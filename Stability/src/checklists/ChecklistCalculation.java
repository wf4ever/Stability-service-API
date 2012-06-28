package checklists;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;

public class ChecklistCalculation {
	
	public double getValue(Model model,String rdf){
	    model.read(rdf);
	    return getEvaluations(model);	
	}

	private double getEvaluations(Model model) {
		int satisfied=getNumRules(model, "http://purl.org/minim/minim#satisfied");
		int nonSatisfied=getNumRules(model,"http://purl.org/minim/minim#missingMust");
		nonSatisfied= nonSatisfied + getNumRules(model,"http://purl.org/minim/minim#missingShould");
		nonSatisfied= nonSatisfied + getNumRules(model,"http://purl.org/minim/minim#missingMay");
		
		double total=satisfied + nonSatisfied;
		return satisfied/total;
		
	}

	private int getNumRules(Model model, String property) {
		int num=0;
		Property p = model.getProperty(property);
		Property p2 = model.getProperty("http://purl.org/minim/minim#tryRequirement");
		NodeIterator n = model.listObjectsOfProperty(p);
		while (n.hasNext()){
        	RDFNode r = n.nextNode();
        	NodeIterator n2=model.listObjectsOfProperty((Resource)r, p2);
        	num=num+getSum(n2);
        }
		return num;
	}
	
	private int getSum(NodeIterator n) {
		int num=0;
		while (n.hasNext()){
        	n.nextNode();
        	num++;
        }
		return num;
	}
		

}
