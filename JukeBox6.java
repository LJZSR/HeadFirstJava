import java.util.*;
import java.io.*;

class Song implements Comparable<Song> {
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
    return title;
  }

  public int compareTo(Song o) {
    return title.compareTo(o.getTitle());
  }

}

public class JukeBox6 {
  ArrayList<Song> songList = new ArrayList<Song>();

  public static void main(String[] args) {
    new JukeBox6().go();
  }

  public void go() {

    getSongs();

    System.out.println(songList);
    Collections.sort(songList);
    System.out.println(songList);

    HashSet<Song> songSet = new HashSet<Song>();
    songSet.addAll(songList);
    System.out.println(songSet);
  }

  public void getSongs() {
    try {
      File file = new File("SongListMore.txt");
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

  public void addSong(String line) {
    String[] tokens = line.split("/");
    songList.add(new Song(tokens[0], tokens[1], tokens[2], tokens[3]));
  }
}