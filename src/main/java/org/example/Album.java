package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String song, double duration) {
        Song locatedSong = findSong(song);
        if(locatedSong == null) {
           this.songs.add(new Song(song, duration));
           return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for(Song checkedSong: songs) {
            if(checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumberOfSong, LinkedList<Song> playlist) {

        int indexOfSong = trackNumberOfSong - 1;
        if((indexOfSong>=0) && (indexOfSong <= songs.size())) {
            playlist.add(songs.get(indexOfSong));
           return true;
        }else {
            System.out.println("This album does not have a track " + trackNumberOfSong);
            return false;
        }

    }

    public boolean addToPlayList(String song, LinkedList<Song> playList) {
        Song songToAdd = findSong(song);
        if(!songToAdd.equals(null)) {
            playList.add(songToAdd);
            return true;
        }
        return false;
    }
}
