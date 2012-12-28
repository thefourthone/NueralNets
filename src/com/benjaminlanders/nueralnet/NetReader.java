package com.benjaminlanders.nueralnet;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * A class designed to hold static methods for loading nets from files without bloating other code
 * @author Benjamin Landers
 *
 */
public class NetReader
{
	/**
	 * Loads a neural net from rom in the following form <p>
	 * 1: 4 //A number to specify how many neurons <p>
	 * 2: 1 , 0 -  //1st number determines type, second determines max in for the neuron <p>
	 * 3: 0 , 1 - 0 //same as before but with a - then the line number - 2(to compensate for the 1st line and starting from 0) of an input neuron <p>
	 * 4: 0 , 1 - 0 // exact same type of neuron as made in line 3 <p>
	 * 5: 2 , 2 - 1 , 2 // an output neuron that takes the two previous sum neurons as inputs<p>
	 * @param name the name the leads to the file
	 * @return the net that is loaded (not done yet)
	 * @see Neuron
	 */
	public static Net netreader(String name)
	{
		File nettxt = new File(name);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nettxt));
			String line = null;
			int i = 0, x = 0;
			Net output = null;
			Neuron temp;
			String[] holder, holder2;
			Neuron[] holder3 = null;
			while((line =reader.readLine()) != null)
			{
				if(output==null)
				{
					output = new Net(Integer.parseInt(line));
					holder3 = output.getNeurons();
				}else
				{
					holder = line.split("-");
					holder2 = holder[0].split(",");
					temp = Neuron.getNeuron(Integer.parseInt(holder2[0]),Integer.parseInt(holder2[1]));
					x = 0;
					if(temp.getClass()!=InNeuron.class){
					for(String temp2: holder[1].split(","))
					{
						temp.setInput(x, holder3[Integer.parseInt(temp2)]);
						x++;
					}
					}
					holder3[i]=temp;
					i++;
				}
			}
			output.setNeurons(holder3);
			reader.close();	
			return output;
		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}

		
	}
}
