package com.niit.util;

public class Util {

	
	public static String removeComman(String field)
	{
		return field.replace(",", "");
	}
	
	
	public static void main(String[] args) {
		
		String cid = ",mobile_category";
		
		System.out.println("cid before remove commaa" +cid);
	
	System.out.println("cid after remove commaa" +removeComman(cid));
	
	
}}
