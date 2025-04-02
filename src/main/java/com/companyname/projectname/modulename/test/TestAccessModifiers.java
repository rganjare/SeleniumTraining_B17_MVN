package com.companyname.projectname.modulename.test;

import com.companyname.projectname.modulename.accessmodifiers.Access_Modifiers_Public;

public class TestAccessModifiers extends Access_Modifiers_Public{

	public static void main(String[] args) {

		Access_Modifiers_Public amp = new Access_Modifiers_Public();
		amp.access_Modifiers_Public_Public_method();
	
		
		Access_Modifiers_Public.access_Modifiers_Public_Public_method_static();
		Access_Modifiers_Public.access_Modifiers_Public_protected_method_static();
		
		access_Modifiers_Public_Public_method_static();
		access_Modifiers_Public_protected_method_static();
		
		//Access_Modifiers_Default amd = new Access_Modifiers_Default();
		
//		amd.access_Modifiers_Default_Public_method();
//		amd.access_Modifiers_Default_Default_method();
//		amd.access_Modifiers_Default_protected_method();

	}

}
