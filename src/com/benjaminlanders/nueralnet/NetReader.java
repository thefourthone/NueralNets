package com.benjaminlanders.nueralnet;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class NetReader
{
	public static Net netreader(String name)
	{
		File nettxt = new File(name);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nettxt));
			String line = null;
			int i =0;
			Net output = null;
			Nueron temp;
			String[] holder, holder2;
			Nueron[] holder3 = null;
			while((line =reader.readLine()) != null)
			{
				if(output==null)
				{
					output = new Net(Integer.parseInt(line));
					holder3 = new Nueron[Integer.parseInt(line)];
				}else
				{
					holder = line.split("-");
					holder2 = holder[0].split(",");
					temp = Nueron.getNueron(Integer.parseInt(holder2[0]),Integer.parseInt(holder2[1]));
					int x = 0;
					for(String temp2: holder[1].split(","))
					{
						temp.setInput(x, holder3[Integer.parseInt(temp2)]);
					}
					holder3[i]=temp;
					i++;
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
}
