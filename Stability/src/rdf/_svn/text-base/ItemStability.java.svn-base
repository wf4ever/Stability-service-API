package rdf;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import control.SnapshotEval;

@XmlRootElement
@XmlType (propOrder={"ro","stabilityValue","listElements"})
public class ItemStability {
	
	private String ro;
	private String stabilityValue;
	private List<ItemSnapshot> listElements;
	
	public String getRo() {
		return ro;
	}
	public void setRo(String ro) {
		this.ro = ro;
	}
	public String getStabilityValue() {
		return stabilityValue;
	}
	public void setStabilityValue(String stabilityValue) {
		this.stabilityValue = stabilityValue;
	}
	public List<ItemSnapshot> getListElements() {
		return listElements;
	}
	public void setListElements(List<ItemSnapshot> listElements) {
		this.listElements = listElements;
	}
	
	public void fillInfo(String name, double val, ArrayList<SnapshotEval> list){
		setRo(name);
		setStabilityValue(Double.toString(val));
		ArrayList<ItemSnapshot> l=new ArrayList<ItemSnapshot>();
		
		for(SnapshotEval s: list){
			ItemSnapshot item=new ItemSnapshot();
			item.setUri(s.getUri());
			item.setValue(Double.toString(s.getValue()));
			item.setDate(s.getDate());
			l.add(item);
		}
		setListElements(l);
	}
	

}
