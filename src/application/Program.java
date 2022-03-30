package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> totalVotes = new LinkedHashMap<>();
		
		System.out.print("Enter file full path: ");
		
		String file = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String line = br.readLine();
			
			while(line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				int votes = Integer.parseInt(fields[1]);
				
				if(totalVotes.containsKey(name)) {
					
					int moreVotes = totalVotes.get(name);
					totalVotes.put(name, votes + moreVotes);
				}
				
				else {
					totalVotes.put(name, votes);
				}
				
				line = br.readLine();
			}
			
			for(String key : totalVotes.keySet()) {
				System.out.println(key + ", " + totalVotes.get(key));
			}

			
		}
		catch(IOException e) {
			System.out.print("Error: " + e.getMessage());
		}
		
		
		
		
		
		
		
		sc.close();
	}

}
