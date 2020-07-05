package edu.westga.cs1301.si8.model;

/**
 * Represents a song.
 * 
 * @author csuser
 * @version si8
 *
 */
public class Song {

	private int songLength;
	private String artistFirstName;
	private String artistLastName;

	/**
	 * Creates a song object with the given artist name.
	 * 
	 * @precondition name(s) != null && !name(s).isEmpty()
	 * @postcondition get<First/Last>Name().equals(<first/last>Name)
	 * @param firstName ...
	 * @param lastName  ...
	 */
	public Song(String firstName, String lastName, int length) {
		this.artistFirstName = firstName;
		this.artistLastName = lastName;
		this.songLength = length;
	}

	/**
	 * Returns the first name of the artist who wrote the song.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return firstName
	 */
	public String getArtistFirstName() {
		return this.artistFirstName;
	}

	/**
	 * Returns the last name of the artist who wrote the song.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return firstName
	 */
	public String getArtistLastName() {
		return this.artistLastName;
	}

	/**
	 * Returns the length of the song.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return songLength
	 */
	public int getLength() {
		return this.songLength;
	}
}
