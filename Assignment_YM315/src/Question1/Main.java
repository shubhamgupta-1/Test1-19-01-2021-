package Question1;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Merchandise> list = new ArrayList<>();
		
		File file = new File("input.txt");
		BufferedReader br;
		
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=br.readLine())!=null) {
				String []tokens=line.split(" ");
				Merchandise temp=new Merchandise(tokens[0], 
						Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
				list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Collections.sort(list);
		for(Merchandise merch: list) {
			System.out.println(merch.toString());
		}
		
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		
		Collections.sort(list, new priceComparator());
		for(Merchandise merch: list) {
			System.out.println(merch.toString());
		}
	}
}
