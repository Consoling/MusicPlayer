package com.dartAriz;

import java.util.*;


public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String [] args) {
        Album album = new Album( "Album1",  "Coke Studio S-14");

        album.addSong("Thagyan", 5.17);
        album.addSong("Passori", 4.37);
        album.addSong("Tu Jhoom", 6.41);
        album.addSong("Beparwah", 4.38);
        albums.add(album);

        album =new Album("Album2", "Imran Khan");

        album.addSong("Amplifier", 3.52);
        album.addSong("Bewafa", 3.44);
        album.addSong("President Roley", 2.55);
        album.addSong("Knightridah", 3.10);
        album.addSong("Imaginary", 3.19);
        albums.add(album);

        album = new Album("Album3", "NEFFEX");
        album.addSong("Fight Back", 3.20);
        album.addSong("Rumours", 4.07);
        album.addSong("Grateful", 3.02);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Thagyan", playList_1);
        albums.get(0).addToPlayList("Pasoori", playList_1);
        albums.get(1).addToPlayList("Tu Jhoom", playList_1);
        albums.get(1).addToPlayList("Beparwah", playList_1);


        play(playList_1);

    }
    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist has no songs");
        }
        else {
            System.out.println("Now Playing" + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){

                        System.out.println("Now Playing" + listIterator.next().toString());
                    }
                    else{
                        System.out.println("No songs available, reached to the end of the list");
                        forward = false;
                    }
                    break;
                    case 2:
                if(forward){
                    if (listIterator.hasPrevious()){
                        listIterator.previous();
                    }
                    forward = false;
                }
                if(listIterator.hasPrevious()){
                    System.out.println("First Song");
                    forward = false;
                }
                break;

                case 3:
                    if(forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Playing" + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("List Starts");
                        }
                    }
                    else {
                            if(listIterator.hasNext()){
                                System.out.println("Now Playing" + listIterator.next().toString());
                                forward = true;
                            }
                            else{
                                System.out.println("End of the List");
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
                            if (playList.size() > 0){
                                listIterator.remove();
                                if(listIterator.hasNext()){
                                    System.out.println("Now Playing" + listIterator.next().toString());
                                    forward = true;
                                }
                                else {
                                    if(listIterator.hasPrevious())
                                        System.out.println("Now Playing" + listIterator.previous().toString());
                                }
                            }



            }
        }
    }



    private static void printMenu() {
        System.out.println("Available Options \n press");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list of all songs \n" +
                "5 - print all available options\n" +
                "6 - delete current song"
        );
    }
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("______________");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("________");
    }
    }
