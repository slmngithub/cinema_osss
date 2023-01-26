package cinemaproject;

import java.util.ArrayList;

public class test {
    public static void main(String[]arg){
        movie m1 = new movie("avatar" , 2014 , 120);
        movie m2 = new movie("avatar2" , 2023 , 150);
        movie m3 = new movie("mr.nobody" , 2009 , 210);
        movie m4 = new movie("catsh if you can" , 2018 , 100);
        movie m5 = new movie("iron man" , 2011 , 115);
        movie m6 = new movie("captain america" , 2002 , 100);
        movie m7 = new movie("the mask" , 1995 , 130);
        cinema cine =new cinema("aflam oussama" , 7);
        ArrayList<movie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        movies.add(m4);
        movies.add(m5);
        movies.add(m6);
        movies.add(m7);
        cine.setMovies(movies);
        cine.addMovie(m1);
        cine.addMovie(m2);
        cine.addMovie(m3);
        cine.addMovie(m4 , 6);
        cine.addMovie(m5 , 5);
        System.out.println("----------[[[ LAS PELICULAS QUE TENEMOS]]]----------");
        cine.visualizacion();
        System.out.println("----------[[[ END ]]]----------");
        /*System.out.println(cine.roomOfMovie("avatar" , 2014 , 120));
        System.out.println(cine.roomOfMovie("the mask" , 1995 , 130));*/
        /*cine.removeMovie("iro");
        System.out.println("----------[[[ LAS PELICULAS QUE TENEMOS]]]----------");
        cine.visualizacion();
        System.out.println("----------[[[ END ]]]----------");
        System.out.println(cine.freeRooms());
        System.out.println(cine.roomOfMovie("catsh if you can" , 2018 , 100));
        System.out.println(cine.freeRooms());
        cine.changeRoom(m4);
        System.out.println(cine.roomOfMovie("catsh if you can" , 2018 , 100));
        System.out.println(cine.freeRooms());*/
        System.out.println(cine.moviesShorterThanMIN(105));
        System.out.println(cine.moviesShorterThanHORAS(1,59));








    }
}
