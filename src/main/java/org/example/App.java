package org.example;

import java.util.*;

public class App 
{
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();

        Album album = new Album("Stormbringer", "Deep Purple");

        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("man", 4.3);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");

        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject", 3.33);
        albums.add(album);

        album = new Album("Elvator Music", "Various Artist");

        album.addSong("Observation Deck", 4.50);
        album.addSong("Swimming Pool", 2.20);
        album.addSong("casino", 2.22);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();

        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList("I put the finger on you", playList);
        albums.get(2).addToPlayList(1, playList);
        albums.get(2).addToPlayList("Swimming Pool", playList);
        albums.get(0).addToPlayList(3, playList);

        play(playList);
    }


    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> iterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("no songs in playlist");
            return;
        } else {
            System.out.println("Now play " + iterator.next().toString());
            printMenu();
        }
        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(iterator.hasNext()) {
                            iterator.next();
                        }
                        forward = true;
                    }
                    if(iterator.hasNext()) {
                        System.out.println("Now playing " + iterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        forward = false;
                    }
                    if(iterator.hasPrevious()) {
                        System.out.println("Now playing " + iterator.previous().toString());
                    } else {
                        System.out.println("We have reached the beginning of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(iterator.hasPrevious()) {
                            System.out.println("Now playing " + iterator.previous());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(iterator.hasNext()) {
                            System.out.println("Now replaying " + iterator.next());
                            forward = true;
                        } else {
                            System.out.println("We are at the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0) {
                        iterator.remove();
                        if(iterator.hasNext()) {
                            System.out.println("Now playing " + iterator.next());
                        } else if(iterator.hasPrevious()) {
                            System.out.println("Now playing " + iterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("\n======================================");
        System.out.println(playList.size() + " Song(s) in playlist");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("====================================");
    }
}
