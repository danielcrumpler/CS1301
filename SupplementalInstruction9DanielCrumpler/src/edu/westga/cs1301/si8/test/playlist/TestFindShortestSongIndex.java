package edu.westga.cs1301.si8.test.playlist;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.si8.model.Playlist;
import edu.westga.cs1301.si8.model.Song;

public class TestFindShortestSongIndex {

	@Test
	public void testPlaylistWithNoSongs() {
		Playlist playlist1 = new Playlist();

		int result = playlist1.findShortestSongIndex();
				
		assertEquals(-1, result);
	}
	
	@Test
	public void testPlaylistWithOneSong() {
		Playlist playlist1 = new Playlist();
		Song song1 = new Song("Firstname", "Lastname", 1);
		playlist1.addSong(song1);
		int result = playlist1.findShortestSongIndex();		
		assertEquals(0, result);
	}
	@Test
	public void testPlaylistWithMultipleSongsFirst() {
		Playlist playlist1 = new Playlist();
		Song song1 = new Song("Firstname", "Lastname", 1);
		Song song2 = new Song("Firstname", "Lastname", 5);
		Song song3 = new Song("Firstname", "Lastname", 10);
		playlist1.addSong(song1);
		playlist1.addSong(song2);
		playlist1.addSong(song3);
		int result = playlist1.findShortestSongIndex();		
		assertEquals(0, result);
	}
	@Test
	public void testPlaylistWithMultipleSongsMiddle() {
		Playlist playlist1 = new Playlist();
		Song song1 = new Song("Firstname", "Lastname", 10);
		Song song2 = new Song("Firstname", "Lastname", 1);
		Song song3 = new Song("Firstname", "Lastname", 5);
		playlist1.addSong(song1);
		playlist1.addSong(song2);
		playlist1.addSong(song3);
		int result = playlist1.findShortestSongIndex();		
		assertEquals(1, result);
	}
	@Test
	public void testPlaylistWithMultipleSongsLast() {
		Playlist playlist1 = new Playlist();
		Song song1 = new Song("Firstname", "Lastname", 5);
		Song song2 = new Song("Firstname", "Lastname", 10);
		Song song3 = new Song("Firstname", "Lastname", 1);
		playlist1.addSong(song1);
		playlist1.addSong(song2);
		playlist1.addSong(song3);
		int result = playlist1.findShortestSongIndex();		
		assertEquals(2, result);
	}
}
