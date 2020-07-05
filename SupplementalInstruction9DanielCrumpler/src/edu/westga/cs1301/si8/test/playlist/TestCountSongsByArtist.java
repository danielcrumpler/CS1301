package edu.westga.cs1301.si8.test.playlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.si8.model.Playlist;
import edu.westga.cs1301.si8.model.Song;

/**
 * makes sure the method is correct....
 * 
 * @author csuser
 *
 */
public class TestCountSongsByArtist {

	@Test
	public void testArtistLastNameIsNullShouldNotWork() {
		// arrange
		Playlist playlist = new Playlist();
		// act & assert
		assertThrows(IllegalArgumentException.class, () -> {
			playlist.countSongsByArtist(null);
		});
	}

	@Test
	public void testArtistLastNameIsEmptyShouldNotWork() {
		// arrange
		Playlist playlist = new Playlist();
		// act & assert
		assertThrows(IllegalArgumentException.class, () -> {
			playlist.countSongsByArtist("");
		});
	}

	@Test
	public void testEmptyList() {
		// arrange
		Playlist playlist = new Playlist();
		// act
		int count = playlist.countSongsByArtist("Jackson");
		// assert
		assertEquals(0, count);
	}

	@Test
	public void testOneSongNoMatch() {
		// arrange
		Playlist playlist = new Playlist();
		Song song = new Song("Alicia", "Keys", 1);
		playlist.addSong(song);
		// act
		int count = playlist.countSongsByArtist("Jackson");
		// assert
		assertEquals(0, count);
	}

	@Test
	public void testOneSongAndMatches() {
		// arrange
		Playlist playlist = new Playlist();
		Song song = new Song("Alicia", "Keys", 1);
		playlist.addSong(song);
		// act
		int count = playlist.countSongsByArtist("Keys");
		// assert
		assertEquals(1, count);
	}
	
	@Test
	public void testMultipleSongsAndOneOccurrence() {
		// arrange
		Playlist playlist = new Playlist();
		Song song = new Song("Alicia", "Keys", 1);
		Song song1 = new Song("Kendrik", "Lamar", 1);
		Song song2 = new Song("Janet", "Jackson", 1);
		playlist.addSong(song);
		playlist.addSong(song1);
		playlist.addSong(song2);
		// act
		int count = playlist.countSongsByArtist("Keys");
		// assert
		assertEquals(1, count);
	}
	
	
	@Test
	public void testMultipleSongsAndMultipleOccurrences() {
		// arrange
		Playlist playlist = new Playlist();
		Song song = new Song("Janet", "Jackson", 1);
		Song song1 = new Song("Michael", "Jackson", 1);
		Song song2 = new Song("Alicia", "keYs", 1);
		playlist.addSong(song);
		playlist.addSong(song1);
		playlist.addSong(song2);
		// act
		int count = playlist.countSongsByArtist("Jackson");
		// assert
		assertEquals(2, count);
	}
}
