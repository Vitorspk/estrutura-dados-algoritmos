package com.vitor.estruturadados.vetor.teste;

import java.util.ArrayList;

public class Aula12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("A");
		arrayList.add("C");
		
		//passar e adicionar no index 1
				
		System.out.println(arrayList);
		
		arrayList.add(1, "B");
		
		System.out.println(arrayList);
		
		int pos = arrayList.indexOf("D");		
		if(pos > -1){
			System.out.println("Elemento existe no array");
		}else{
			System.out.println("Elemento nao existe no array " + pos);
		}
		
		System.out.println(arrayList.get(2));
		
		arrayList.remove(0);
		arrayList.remove("B");
		System.out.println(arrayList);
		
		System.out.println(arrayList.size());
	
	}

}
