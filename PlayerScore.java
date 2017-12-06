package snake;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @author Group Alpha
 * Date: 11/04/17
 * Class: CSIS 2450
 * Assignment: Group Project
 */
public class PlayerScore {

	/**
	 * Attributes
	 */
	private int score;
	
	private String name;
	
	private String scoreFile = "highscores.txt";
	
	private ArrayList<PlayerScore> highscores = new ArrayList<PlayerScore>();
	
	/**
	 * PlayerScore Constructor
	 * @param name is the name/initials of the player
	 * @param score is the score of the player
	 */
	public PlayerScore(String name, int score) {
		this.setName(name);
		this.score = score;
	}
	
	public ArrayList<PlayerScore> getHighScores(){
		highscores.clear();
		try {
	        BufferedReader reader = new BufferedReader(new FileReader(scoreFile));
	        String line = reader.readLine();	        
	        
	        while (line != null)                
	        {
	            try {
	            	String[] eachLine = line.split(Pattern.quote("\\t"));
	            	String name = eachLine[0];	            	
	                int score = Integer.parseInt(eachLine[1]);
	                highscores.add(new PlayerScore(name, score));
	                
	            } catch (NumberFormatException e1) {
	                System.out.println("Error reading line. Incorrect Format");
	            }
	            line = reader.readLine();
	        }
	        
	        reader.close();
	       

	    } catch (IOException ex) {	    	
	        System.err.println("ERROR: File does not exist.");	        
	    }
		return highscores;
		
	}
	
	public void setHighScores(ArrayList<PlayerScore> a){
		try {
			FileWriter writer = new FileWriter(new File(scoreFile));	
			String newScores = "";
			for(PlayerScore p : a){
				newScores += p.getName() + "\\t" + p.getScore() + "\n";			
			}			
			writer.write(newScores);
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Score Getter
	 * @return current score of the player
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Name Getter
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Name Setter
	 * @param name is the new player name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Method to increase player score
	 * @param points is the number of points the score is increased by
	 */
	public void increaseScore(int points) {
		this.score += points;
	}
	
	/**
	 * Method to decrease player score
	 * @param points is the number of points the score is decreased by
	 */
	public void decreaseScore(int points) {
		this.score -= points;
	}
	/**
	 * Method to reset score
	 * @param points
	 */
	public void resetScore() {
		this.score = 0;
	}
	/**
	 * Method to get score as a string
	 * @return
	 */
	public String getScoreString(){
		return this.score + "";
	}
	
	@Override
	public String toString(){
		return this.getName() + " " + this.getScore();
	}
}