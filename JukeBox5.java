import java.util.*;
import java.io.*;

class Song {
  String title;
  String artist;
  String rating;
  String bpm;

  public Song(String t, String a, String r, String b) {
    title = t;
    artist = a;
    rating = r;
    bpm = b;
  }

  public String getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  public String getRating() {
    return rating;
  }

  public String getBpm() {
    return bpm;
  }

  public String toString() {
    return artist;
  }

}

public class JukeBox5 {
  ArrayList<Song> songList = new ArrayList<Song>();

  class ArtistCompare implements Comparator<Song> {
    public int compare(Song o1, Song o2) {
      return o1.getArtist().compareTo(o2.getArtist());
    }
  }

  public static void main(String[] args) {
    new JukeBox5().go();
  }

  public void go() {
    getSongs();
    System.out.println(songList);
    ArtistCompare artistCompare = new ArtistCompare();
    Collections.sort(songList, artistCompare);
    System.out.println(songList);
  }

  public void getSongs() {
    try {
      File file = new File("SongList.txt");
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;
      while ((line = reader.readLine()) != null) {
        addSong(line);
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void addSong(String lineToParse) {
    String[] tokens = lineToParse.split("/");
    songList.add(new Song(tokens[0], tokens[1], tokens[2], tokens[3]));
  }

}