package edu.westga.cs1301.si8.model;

import java.util.ArrayList;

/**
 * Represents a playlist...
 * 
 * @author csuser
 * @version
 *
 */
public class Playlist {

	private ArrayList<Song> songList;

	/**
	 * Creates a playlist object with no songs.
	 * 
	 * @precondition none
	 * @postcondition getNumberOfSongs() == 0
	 */
	public Playlist() {
		this.songList = new ArrayList<Song>();
	}

	/**
	 * Returns the number of songs in this song list
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the number of songs
	 */
	public int getNumberOfSongs() {
		return this.songList.size();
	}

	/**
	 * Counts the number of songs in the playlist that match a specified last name.
	 *
	 * @precondition artistLastName!= null && !artistLastName.isEmpty()
	 * @postcondition none
	 * @param artistLastName The last name of an artist.
	 * @return The number of songs that match the specified artist last name.
	 */
	public int countSongsByArtist(String artistLastName) {

		if (artistLastName == null) {
			throw new IllegalArgumentException("artistLastName cannot be null.");
		}
		if (artistLastName.isEmpty()) {
			throw new IllegalArgumentException("artistLastName cannot be empty.");
		}

		int count = 0;
		for (Song currentSong : this.songList) {
			if (currentSong.getArtistLastName().equalsIgnoreCase(artistLastName)) {
				count += 1;
			}
		}
		return count;

	}

	/**
	 * to-do
	 */
	public void addSong(Song song) {
		// to-do
		this.songList.add(song);
	}

	/**
	 * to-do
	 * 
	 * @param artistFirstName
	 * @param artistLastName
	 * @return
	 */
	public int countSongsByArtist(String artistFirstName, String artistLastName) {

		if (artistLastName == null) {
			throw new IllegalArgumentException("artistLastName cannot be null.");
		}
		if (artistLastName.isEmpty()) {
			throw new IllegalArgumentException("artistLastName cannot be empty.");
		}
		// to-do prec...

		int count = 0;
		for (Song currentSong : this.songList) {
			if (currentSong.getArtistLastName().equalsIgnoreCase(artistLastName)
					&& currentSong.getArtistFirstName().equalsIgnoreCase(artistFirstName)) {
				count += 1;
			}
		}
		return count;

	}

	/**
	 * Finds the length of the shortest song 
	 * @preconditon none 
	 * @postcondition none 
	 * 
	 * @return The length of the shortest song
	 */
	public int findShortestSongLength() {
		if (this.songList.isEmpty()) {
			return -1;
		}
		int shortestLength = Integer.MAX_VALUE;
		for (Song currentSong : this.songList) {
			if (currentSong.getLength() < shortestLength) {
				shortestLength = currentSong.getLength();
			}
		}
		return shortestLength;
	}

	/**
	 * Finds the shortest song if multiple songs have the same name than return the last indexed song with that length
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return The Song object with the shortest length
	 */
	public Song findShortestSong() {
		if (this.songList.isEmpty()) {
			return null;
		}
		Song shortestSong = this.songList.get(0);
		for (Song currentSong : this.songList) {
			if (currentSong.getLength() < shortestSong.getLength()) {
				shortestSong = currentSong;
			}
		}
		return shortestSong;
	}

	/**
	 * Finds the index of the shortest song 
	 * @precondition none * @postcondition
	 * none 
	 * @return The location of the Song object with the shortest length
	 */
	public int findShortestSongIndex() {
		int shortestSongIndex = -1;
		int shortestSongLength = Integer.MAX_VALUE;
		for (int index = 0; index < this.songList.size(); index++) {
			if (this.songList.get(index).getLength() < shortestSongLength) {
				shortestSongIndex = index;
				shortestSongLength = this.songList.get(index).getLength();
			}
		}
		return shortestSongIndex;
	}
}
