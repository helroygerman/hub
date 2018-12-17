package org.gaahoo.helper;

public class SelectedHelper {

	
	public static int PlanningType(String type){
		if(type.contains("depense")){
			return 1;
		}else{
			return 0;
		}
	}
}
