package com.companyname.projectname.modulename.accessmodifiers;

public class Access_Modifiers_Public {
	
	public void access_Modifiers_Public_Public_method() {	
		System.out.println("I am in access_Modifiers_Public_Public_method");
		access_Modifiers_Public_private_method();
	}
	
	 void access_Modifiers_Public_Default_method() {	
		System.out.println("I am in access_Modifiers_Public_Default_method");
	}
	 
	 protected void access_Modifiers_Public_protected_method() {	
			System.out.println("I am in access_Modifiers_Public_protected_method");
	}
	 
	 private void access_Modifiers_Public_private_method() {	
			System.out.println("I am in access_Modifiers_Public_private_method");
	}
	 
	 //============ Static Methods =============================
	 
	 public static void access_Modifiers_Public_Public_method_static() {	
			System.out.println("I am in access_Modifiers_Public_Public_method_static");
		}
		
	 static void access_Modifiers_Public_Default_method_static() {	
			System.out.println("I am in access_Modifiers_Public_Default_method_static");
		}
		 
	protected static void access_Modifiers_Public_protected_method_static() {	
				System.out.println("I am in access_Modifiers_Public_protected_method_static");
		}
		 
	private static void access_Modifiers_Public_private_method_static() {	
				System.out.println("I am in access_Modifiers_Public_private_method_static");
		}
}
