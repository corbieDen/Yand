package ru.my1.corbie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
    {
	private static Scanner sc;

	public static void main(String[] args)
	    {
		//счетчик максимальной цены
		//int costCounter = 0;
		
		sc = new Scanner(System.in);
		//предполагаем, что пользователь знает формат ввода данных
		System.out.println("¬ведите данные: "); 
		String a = sc.nextLine().trim() + " ";
		List<Short> b = new ArrayList<Short>();
				
		//обработка первой строки ввода
		StringBuilder sb = new StringBuilder();
		for (byte i=0; i < a.length(); i++)
		    {
			if (Character.isDigit(a.charAt(i)))
			    sb.append(a.charAt(i));
			else {
			    b.add(Short.parseShort(sb.toString()));
			    sb.delete(0, sb.length());
			    }
			}
		Short[] inner = b.toArray(new Short[4]);
		short k = inner[0];
		short U = inner[1];
		short M = inner[2];
		short D = inner[3];
		short T = inner[4];
	    }

    }
