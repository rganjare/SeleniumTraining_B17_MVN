package com.companyname.projectname.modulename.accessmodifiers;

public class Test_Access_Modifiers {
	
	public static void main(String[] args) {
		
		Access_Modifiers_Public amp = new Access_Modifiers_Public();
		
		amp.access_Modifiers_Public_Public_method();
		amp.access_Modifiers_Public_Default_method();
		amp.access_Modifiers_Public_protected_method();
		
		
		Access_Modifiers_Public.access_Modifiers_Public_Public_method_static();
		Access_Modifiers_Public.access_Modifiers_Public_Default_method_static();
		Access_Modifiers_Public.access_Modifiers_Public_protected_method_static();
		
		
		Access_Modifiers_Default amd = new Access_Modifiers_Default();
		
		amd.access_Modifiers_Default_Public_method();
		amd.access_Modifiers_Default_Default_method();
		amd.access_Modifiers_Default_protected_method();
		
		Access_Modifiers_Default.access_Modifiers_Default_Public_method_static();
		Access_Modifiers_Default.access_Modifiers_Default_Default_method_static();
		Access_Modifiers_Default.access_Modifiers_Default_protected_method_static();
		
		
	}

}
