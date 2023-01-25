package cinemaproject;

public class movie {
    private String name;
    private int ano;
    private int duracion;
    public movie(String name , int ano , int duracion ){
        this.ano=ano;
        this.name=name;
        this.duracion=duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return "el nombre de la pelicula es " + name + " del año " + ano + " y su duracion es " + duracion;
    }
    public boolean isEqual( movie M){
        String nameM= M.getName().toLowerCase();
        String namethis=this.getName().toLowerCase();

        if (nameM.equals(namethis) && M.getAno()==this.getAno() && (M.getDuracion()<=(this.getDuracion()+5) &&M.getDuracion()>=(this.getDuracion()-5) )){
            return true;

        }
        return false;

    }
}
