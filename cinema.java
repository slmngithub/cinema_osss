package cinemaproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class cinema {
    private String nameCine;
    private List<movie> movies;
    private movie []  busyRooms;

    public cinema(String nameCine  , int numsalas){
        this.movies= new ArrayList<>();
        busyRooms=new movie[numsalas];
        this.nameCine=nameCine;
    }
    public int roomOfMovie(String name , int ano , int duracion ){
        movie film=new movie(name,ano,duracion);
        if (searchmovie(film)){
            for (int i=0 ; i<busyRooms.length ; i++){
                if (busyRooms[i] != null && busyRooms[i].isEqual(film)){
                    return i;
                }
            }
        }

        return -1;

    }
    /*--------------------###ERROR IN THE NEXT METHOD###--------------------------------*/
    /*-----------------------------done , error corrected--------------------------------*/
    private boolean searchmovie(movie filmx){
        for (int i=0 ; i<movies.size() ; i++){
             if (movies.get(i).isEqual(filmx)){
                 return true;
             }

        }
        return false;
    }
    public void addMovie(movie film){
        if (searchmovie(film)){
            for (int i=0 ; i<busyRooms.length ; i++){
                if (busyRooms[i]==null){
                    busyRooms[i]=film;
                    break;
                }

            }
        }
        else {
            movies.add(film);
            addMovie(film);
        }

    }
    public void addMovie(movie film , int numsala){

        if (searchmovie(film)){
            if (this.busyRooms[numsala]==null){
                busyRooms[numsala]=film;
            }
            else System.out.println("la sala esta ocupada");
        }
        else {
            movies.add(film);
            addMovie(film,numsala);
        }

    }
    public void visualizacion(){
        System.out.println(getNameCine() + ":");
        for (int i=0;i<movies.size();i++){
            if (roomOfMovie(movies.get(i).getName() ,movies.get(i).getAno() ,movies.get(i).getDuracion() )!=-1){
                System.out.println(movies.get(i).getName() + "  - ROOM " +roomOfMovie(movies.get(i).getName() ,movies.get(i).getAno() ,movies.get(i).getDuracion()));

            } else {
                System.out.println(movies.get(i).getName());


            }
            ;
            /*System.out.print(movies.get(i).getName() + "  -");

            for (int j=0;j<busyRooms.length;j++){

                if (busyRooms[j] != null && busyRooms[j].isEqual(movies.get(i))){
                    System.out.println("ROOM : " + j );
                }
            }*/

        }




    }
    public void removeMovie(String subname){
        subname=subname.toLowerCase();
        int x=subname.length();
        String halfname;
        for (int i=0;i<movies.size();i++){
            halfname=movies.get(i).getName().substring(0 , x);
            if (halfname.equals(subname)){
                busyRooms[roomOfMovie(movies.get(i).getName() ,movies.get(i).getAno() ,movies.get(i).getDuracion() )]=null;
                movies.remove(i);

            }
        }
    }
    public ArrayList<Integer>  freeRooms(){
        ArrayList<Integer> freesalas=new ArrayList<>();
        for (int i=0 ; i<busyRooms.length ; i++){
            if (busyRooms[i]==null){
                freesalas.add(i);
            }
        }
        return freesalas;
    }
    public void changeRoom(movie film){
        int respuesta;
        int room=-1;
        if(searchmovie(film)){
            for (int i=0 ; i<busyRooms.length ; i++){
                if (busyRooms[i]!=null && busyRooms[i].isEqual(film)){

                        room=i;
                        break;
                }
            }
            Scanner sc=new Scanner(System.in);
            if (room!=-1){
                System.out.print(" esta pelicula esta el la habitacion "+  room+ " escribe el numero de otra habitación desea cambiarla : ");
                respuesta=sc.nextInt();
                while (!isfree(respuesta)){
                    System.out.print("este room esta ocupada , escribe otra : ");
                    respuesta=sc.nextInt();
                }
                busyRooms[room]=film;
                busyRooms[room]=null;

            } else if (room==-1) {
                System.out.println("esta pelicula no se esta proyectando , si quieres asignarla a una sala escribi el numero de la sala , si no escribe -1  ");
                respuesta= sc.nextInt();
                if (respuesta!=-1){
                    while (!isfree(respuesta)){
                        System.out.print("este room esta ocupada , escribe otra : ");
                        respuesta=sc.nextInt();
                    }
                    busyRooms[room]=film;
                    busyRooms[room]=null;
                }
            }
        }
        else System.out.print("esta pelicula no existe en el cine");
    }
    private boolean isfree(int r){

        if (r>=busyRooms.length){
            System.out.println("ESTE ROOM NO EXICTE");
        }
        else if(busyRooms[r]==null){
            return true;
        }


        return false;
    }
    public void resetCinema(){
        movies.clear();
        for (int i=0 ; i<busyRooms.length;i++){
            busyRooms[i]=null;
        }
    }
    public ArrayList moviesShorterThanMIN(int mint){
        ArrayList <String> film = new ArrayList<>();
        for (int i=0 ; i<movies.size() ; i++){
            if (movies.get(i).getDuracion()<mint){
                film.add(movies.get(i).getName());
            }
        }
        return film;
    }
    public ArrayList moviesShorterThanHORAS(int horas , int min){
        ArrayList <String> film = new ArrayList<>();
        int tiempo = min + (horas*60);
        for (int i=0 ; i<movies.size() ; i++){
            if (movies.get(i).getDuracion()<tiempo){
                film.add(movies.get(i).getName());
            }
        }
        return film;
    }


/*GET SET METHODOS*/
    public String getNameCine() {
        return nameCine;
    }

    public void setNameCine(String nameCine) {
        this.nameCine = nameCine;
    }


    public void setBusyRooms(movie[] busyRooms) {
        this.busyRooms = busyRooms;
    }

    public movie[] getBusyRooms() {
        return busyRooms;
    }

    public void setMovies(List<movie> movies) {
        this.movies = movies;
    }

    public List<movie> getMovies() {
        return movies;
    }
}
/*-------------------------------------------------*/
