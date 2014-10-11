package ru.my1.corbie;

import java.util.*;

public class Main
    {

	private static Scanner sc;

	public static void main(String[] args)
	    {
		// TODO Auto-generated method stub
		
		sc = new Scanner(System.in);
		//предполагаем, что пользователь знает формат ввода данных
		System.out.println("Введите данные: "); 
		String a = sc.nextLine().trim() + " ";
		List<Short> b = new ArrayList<Short>();
		
			//обработка первой строки ввода
			StringBuilder sb = new StringBuilder();
        		for (byte i=0; i < a.length(); i++)
        		    {
                		if (Character.isDigit(a.charAt(i)))
                		    sb.append(a.charAt(i));
                		else 	{
                        		    b.add(Short.parseShort(sb.toString()));
                        		    sb.delete(0, sb.length());
                			}
                		
        		    }
        		
        		Short[] inner = b.toArray(new Short[4]);
        		short m = inner[0];
        		short n = inner[1];
        		
        		//имитаци¤ двумерного массива
        		byte[][] parq = new byte[m][n];

        		//обработка последующих строк ввода			
        		for(short k=0; k < m; k++)
				{
				    String layer = sc.nextLine();
				    byte[] x = new byte[n];
					for (short j=0; j<n;j++)
						if (layer.charAt(j) == '.')
						    x[j] = 0;
						else x[j] = 1;
				     parq[k] = x;
				}
			    
			
			
			
			
			
			for(int i=0; i < parq.length; i++)
				{
					for(int j=0; j < parq[i].length; j++)
						System.out.printf("%2d", parq[i][j]);
					
					System.out.println();
					
				}   
			
	    }

    }
