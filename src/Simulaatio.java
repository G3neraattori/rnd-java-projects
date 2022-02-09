import java.util.Random;


public class Simulaatio {

    private Tyyppi[][] taulukko;
    private int leveys;

    public Simulaatio(int leveys, int korkeus) {
        this.taulukko = new Tyyppi[korkeus][leveys];
        for(int rivi = 0; rivi < this.taulukko.length; rivi++){
            for(int sarake = 0; sarake < this.taulukko[rivi].length; sarake++){
                this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
            }
        }
        this.leveys = leveys;
    }

    public void lisaa(int x, int y, Tyyppi tyyppi) {
        this.taulukko[y][x] = tyyppi;
    }

    public Tyyppi sisalto(int x, int y) {
        if(y >= this.taulukko.length || x >= this.leveys || x < 0 || y < 0){
            return Tyyppi.METALLI;
        }

        if(this.taulukko[y][x] == Tyyppi.HIEKKA){
            return Tyyppi.HIEKKA;
        }else if(this.taulukko[y][x] == Tyyppi.METALLI){
            return Tyyppi.METALLI;
        }else if(this.taulukko[y][x] == Tyyppi.VESI){
            return Tyyppi.VESI;
        }else if(this.taulukko[y][x] == Tyyppi.TYHJA){
            return Tyyppi.TYHJA;
        } else {
            return Tyyppi.TYHJA;
        }
    }

    public void paivita() {
        //Change this mess, else if currently due as this was made originally on outdated jdk on buggy version of netbeans.
        //
        Random rnd = new Random();
        for(int rivi = this.taulukko.length - 2; rivi >= 0; rivi--){
            for(int sarake = 0; sarake <= this.taulukko[rivi].length - 1; sarake++){
                int suunta = rnd.nextInt(3);
                if(this.taulukko[rivi][sarake] == Tyyppi.HIEKKA && sarake - 1 >= 0 && sarake < this.taulukko[rivi].length - 1){
                    boolean useampi = (this.taulukko[rivi + 1][sarake -1] == Tyyppi.TYHJA && this.taulukko[rivi + 1][sarake] == Tyyppi.TYHJA)
                            ||(this.taulukko[rivi + 1][sarake -1] == Tyyppi.TYHJA && this.taulukko[rivi + 1][sarake + 1] == Tyyppi.TYHJA)
                            ||(this.taulukko[rivi + 1][sarake] == Tyyppi.TYHJA && this.taulukko[rivi + 1][sarake + 1] == Tyyppi.TYHJA)
                            ||(this.taulukko[rivi + 1][sarake -1] == Tyyppi.TYHJA && this.taulukko[rivi + 1][sarake + 1] == Tyyppi.TYHJA &&  this.taulukko[rivi + 1][sarake] == Tyyppi.TYHJA);


                    if(useampi){
                        if(suunta == 0 && this.taulukko[rivi + 1][sarake - 1] == Tyyppi.TYHJA && sarake - 1 >= 0){
                            this.taulukko[rivi + 1][sarake - 1] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(suunta == 1 && this.taulukko[rivi +1][sarake] == Tyyppi.TYHJA){
                            this.taulukko[rivi +1][sarake] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(suunta == 2 && this.taulukko[rivi + 1][sarake + 1] == Tyyppi.TYHJA){
                            this.taulukko[rivi + 1][sarake + 1] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }
                    }else {
                        if(this.taulukko[rivi + 1][sarake -1] == Tyyppi.TYHJA && sarake - 1 >= 0){
                            this.taulukko[rivi + 1][sarake - 1] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(this.taulukko[rivi +1][sarake] == Tyyppi.TYHJA){
                            this.taulukko[rivi +1][sarake] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(this.taulukko[rivi + 1][sarake + 1] == Tyyppi.TYHJA){
                            this.taulukko[rivi + 1][sarake + 1] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }
                    }


                    if(this.taulukko[rivi + 1][sarake] == Tyyppi.VESI){
                        this.taulukko[rivi + 1][sarake] = Tyyppi.HIEKKA;
                        this.taulukko[rivi][sarake] = Tyyppi.VESI;
                    }else if(this.taulukko[rivi + 1][sarake  - 1] == Tyyppi.VESI){
                        this.taulukko[rivi + 1][sarake - 1] = Tyyppi.HIEKKA;
                        this.taulukko[rivi][sarake] = Tyyppi.VESI;
                    }else if(this.taulukko[rivi + 1][sarake + 1] == Tyyppi.VESI ){
                        this.taulukko[rivi + 1][sarake + 1] = Tyyppi.HIEKKA;
                        this.taulukko[rivi][sarake] = Tyyppi.VESI;
                    }
                } else if(this.taulukko[rivi][sarake] == Tyyppi.HIEKKA && sarake == 0){
                    boolean useampi =(this.taulukko[rivi + 1][sarake] == Tyyppi.TYHJA && this.taulukko[rivi + 1][sarake + 1] == Tyyppi.TYHJA);
                    int uusi = rnd.nextInt(2);

                    if(useampi){
                        if(uusi == 0 && this.taulukko[rivi +1][sarake] == Tyyppi.TYHJA){
                            this.taulukko[rivi +1][sarake] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(uusi == 1 && this.taulukko[rivi + 1][sarake + 1] == Tyyppi.TYHJA){
                            this.taulukko[rivi + 1][sarake + 1] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }
                    }else {
                        if(this.taulukko[rivi +1][sarake] == Tyyppi.TYHJA){
                            this.taulukko[rivi +1][sarake] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(this.taulukko[rivi + 1][sarake + 1] == Tyyppi.TYHJA){
                            this.taulukko[rivi + 1][sarake + 1] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }
                    }


                    if(this.taulukko[rivi + 1][sarake] == Tyyppi.VESI){
                        this.taulukko[rivi + 1][sarake] = Tyyppi.HIEKKA;
                        this.taulukko[rivi][sarake] = Tyyppi.VESI;
                    }else if(this.taulukko[rivi + 1][sarake + 1] == Tyyppi.VESI ){
                        this.taulukko[rivi + 1][sarake + 1] = Tyyppi.HIEKKA;
                        this.taulukko[rivi][sarake] = Tyyppi.VESI;
                    }
                }else if(this.taulukko[rivi][sarake] == Tyyppi.HIEKKA){
                    boolean useampi =(this.taulukko[rivi + 1][sarake] == Tyyppi.TYHJA && this.taulukko[rivi + 1][sarake - 1] == Tyyppi.TYHJA);
                    int uusi = rnd.nextInt(2);

                    if(useampi){
                        if(uusi == 0 && this.taulukko[rivi +1][sarake] == Tyyppi.TYHJA){
                            this.taulukko[rivi +1][sarake] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(uusi == 1 && this.taulukko[rivi + 1][sarake - 1] == Tyyppi.TYHJA){
                            this.taulukko[rivi + 1][sarake - 1] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }
                    }else {
                        if(this.taulukko[rivi +1][sarake] == Tyyppi.TYHJA){
                            this.taulukko[rivi +1][sarake] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(this.taulukko[rivi + 1][sarake - 1] == Tyyppi.TYHJA){
                            this.taulukko[rivi + 1][sarake - 1] = Tyyppi.HIEKKA;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }
                    }


                    if(this.taulukko[rivi + 1][sarake] == Tyyppi.VESI){
                        this.taulukko[rivi + 1][sarake] = Tyyppi.HIEKKA;
                        this.taulukko[rivi][sarake] = Tyyppi.VESI;
                    }else if(this.taulukko[rivi + 1][sarake - 1] == Tyyppi.VESI ){
                        this.taulukko[rivi + 1][sarake - 1] = Tyyppi.HIEKKA;
                        this.taulukko[rivi][sarake] = Tyyppi.VESI;
                    }
                }


                if(sarake - 1 >= 0 && sarake < this.taulukko[rivi].length - 1) {
                    boolean taysi = this.taulukko[rivi +1][sarake + 1] != Tyyppi.TYHJA && this.taulukko[rivi +1][sarake] != Tyyppi.TYHJA && this.taulukko[rivi +1][sarake - 1] != Tyyppi.TYHJA && rivi + 1 <= this.taulukko.length && sarake - 1 >= 0;
                    boolean vetta = sisalto(sarake + 1, rivi - 1) != Tyyppi.VESI || sisalto(sarake + 1, rivi) != Tyyppi.VESI || sisalto(sarake + 1, rivi + 1) != Tyyppi.VESI;
                    if(this.taulukko[rivi][sarake] == Tyyppi.VESI){
                        if(suunta == 0 && this.taulukko[rivi + 1][sarake - 1] == Tyyppi.TYHJA && sarake - 1 >= 0){
                            this.taulukko[rivi + 1][sarake - 1] = Tyyppi.VESI;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(suunta == 1 && this.taulukko[rivi +1][sarake] == Tyyppi.TYHJA){
                            this.taulukko[rivi +1][sarake] = Tyyppi.VESI;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(suunta == 2 && this.taulukko[rivi + 1][sarake + 1] == Tyyppi.TYHJA){
                            this.taulukko[rivi + 1][sarake + 1] = Tyyppi.VESI;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(suunta == 2 && taysi && vetta && this.taulukko[rivi][sarake + 1] == Tyyppi.TYHJA){
                            this.taulukko[rivi][sarake + 1] = Tyyppi.VESI;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(suunta < 2 && taysi && vetta && sarake - 1 >= 0 && sisalto(sarake -1, rivi) == Tyyppi.TYHJA){
                            this.taulukko[rivi][sarake - 1] = Tyyppi.VESI;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }
                    }
                } else if(sarake == 0) {
                    boolean taysi = this.taulukko[rivi +1][sarake + 1] != Tyyppi.TYHJA && this.taulukko[rivi +1][sarake] != Tyyppi.TYHJA && rivi + 1 <= this.taulukko.length && sarake - 1 >= 0;
                    boolean vetta = sisalto(sarake + 1, rivi) != Tyyppi.VESI || sisalto(sarake + 1, rivi + 1) != Tyyppi.VESI;
                    int uusi = rnd.nextInt(2);
                    if(this.taulukko[rivi][sarake] == Tyyppi.VESI){
                        if(uusi == 0 && this.taulukko[rivi +1][sarake] == Tyyppi.TYHJA){
                            this.taulukko[rivi +1][sarake] = Tyyppi.VESI;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(uusi == 1 && this.taulukko[rivi + 1][sarake + 1] == Tyyppi.TYHJA){
                            this.taulukko[rivi + 1][sarake + 1] = Tyyppi.VESI;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(uusi == 1 && taysi && vetta && this.taulukko[rivi][sarake + 1] == Tyyppi.TYHJA){
                            this.taulukko[rivi][sarake + 1] = Tyyppi.VESI;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }
                    }
                }else{
                    boolean taysi = this.taulukko[rivi +1][sarake -1] != Tyyppi.TYHJA && this.taulukko[rivi +1][sarake] != Tyyppi.TYHJA && rivi + 1 <= this.taulukko.length && sarake - 1 >= 0;
                    boolean vetta = sisalto(sarake + 1, rivi) != Tyyppi.VESI || sisalto(sarake + 1, rivi - 1) != Tyyppi.VESI;
                    int uusi = rnd.nextInt(2);
                    if(this.taulukko[rivi][sarake] == Tyyppi.VESI){
                        if(uusi == 0 && this.taulukko[rivi +1][sarake] == Tyyppi.TYHJA){
                            this.taulukko[rivi +1][sarake] = Tyyppi.VESI;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(uusi == 1 && this.taulukko[rivi + 1][sarake - 1] == Tyyppi.TYHJA){
                            this.taulukko[rivi + 1][sarake - 1] = Tyyppi.VESI;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }else if(uusi == 1 && taysi && vetta && this.taulukko[rivi][sarake - 1] == Tyyppi.TYHJA){
                            this.taulukko[rivi][sarake - 1] = Tyyppi.VESI;
                            this.taulukko[rivi][sarake] = Tyyppi.TYHJA;
                        }
                    }
                }
            }
        }

    }
}

/*
TestMyCode
TMC
Organization MOOC
Course mooc-2019-ohjelmointi
Exercise osa14-Osa14_04.Hiekkaranta
Suggested solution
Solution for osa14-Osa14_04.Hiekkaranta
src/main/java/hiekkaranta/HiekkarantaSovellus.java
package hiekkaranta;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HiekkarantaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        int leveys = 200;
        int korkeus = 200;
        Simulaatio simulaatio = new Simulaatio(leveys, korkeus);

        final ToggleGroup valintaryhma = new ToggleGroup();

        RadioButton metalli = new RadioButton("Metalli");
        metalli.setToggleGroup(valintaryhma);
        metalli.setSelected(true);

        RadioButton hiekka = new RadioButton("Hiekka");
        hiekka.setToggleGroup(valintaryhma);

        RadioButton vesi = new RadioButton("Vesi");
        vesi.setToggleGroup(valintaryhma);

        Canvas piirtoalusta = new Canvas(leveys, korkeus);

        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        piirtoalusta.setOnMouseDragged((event) -> {
            double kohtaX = event.getX();
            double kohtaY = event.getY();

            for (int x = (int) kohtaX - 4; x < (int) kohtaX + 4; x++) {
                for (int y = (int) kohtaY - 4; y < (int) kohtaY + 4; y++) {
                    if (Math.random() < 0.4) {
                        continue;
                    }

                    if (valintaryhma.getSelectedToggle() == metalli) {
                        simulaatio.lisaa(x, y, Tyyppi.METALLI);
                    }
                    if (valintaryhma.getSelectedToggle() == hiekka) {
                        simulaatio.lisaa(x, y, Tyyppi.HIEKKA);
                    }
                    if (valintaryhma.getSelectedToggle() == vesi) {
                        simulaatio.lisaa(x, y, Tyyppi.VESI);
                    }

                }
            }
        }
        );

        // piirtäminen
        new AnimationTimer() {
            long edellinen = 0;

            @Override
            public void handle(long nykyhetki) {
                if (nykyhetki - edellinen < 100000000) {
                    return;
                }

                piirturi.setFill(Color.BLACK);
                piirturi.fillRect(0, 0, leveys, korkeus);

                for (int x = 0; x < leveys; x++) {
                    for (int y = 0; y < korkeus; y++) {
                        Tyyppi sisalto = simulaatio.sisalto(x, y);
                        if (sisalto == null || sisalto == Tyyppi.TYHJA) {
                            continue;
                        }

                        if (sisalto == Tyyppi.METALLI) {
                            piirturi.setFill(Color.WHITE);
                        } else if (sisalto == Tyyppi.HIEKKA) {
                            piirturi.setFill(Color.ORANGE);
                        } else if (sisalto == Tyyppi.VESI) {
                            piirturi.setFill(Color.LIGHTBLUE);
                        }

                        piirturi.fillRect(x, y, 1, 1);
                    }
                }

                this.edellinen = nykyhetki;
            }
        }.start();

        // animointi
        new AnimationTimer() {
            private long edellinen;

            @Override
            public void handle(long nykyhetki) {
                if (nykyhetki - edellinen < 1000000) {
                    return;
                }

                simulaatio.paivita();
                this.edellinen = nykyhetki;
            }
        }.start();

        BorderPane asettelu = new BorderPane();
        asettelu.setCenter(piirtoalusta);

        VBox napit = new VBox();
        napit.getChildren().addAll(metalli, hiekka, vesi);

        asettelu.setRight(napit);
        Scene nakyma = new Scene(asettelu);

        stage.setScene(nakyma);
        stage.show();
    }

    public static void main(String[] args) {
        launch(HiekkarantaSovellus.class);
    }
}


src/main/java/hiekkaranta/Piste.java
package hiekkaranta;

public class Piste {

    private int x;
    private int y;

    public Piste(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}


src/main/java/hiekkaranta/Simulaatio.java
package hiekkaranta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Simulaatio {

    private int leveys;
    private int korkeus;

    private Random random;
    private Tyyppi[][] alue;

    public Simulaatio(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;

        this.random = new Random();
        this.alue = new Tyyppi[leveys][korkeus];
        for (int x = 0; x < leveys; x++) {
            for (int y = 0; y < korkeus; y++) {
                this.alue[x][y] = Tyyppi.TYHJA;
            }
        }
    }

    public void lisaa(int x, int y, Tyyppi tyyppi) {
        if (x < 0 || y < 0 || x >= leveys || y >= korkeus) {
            return;
        }

        this.alue[x][y] = tyyppi;
    }

    public Tyyppi sisalto(int x, int y) {
        if (x < 0 || y < 0 || x >= leveys || y >= korkeus) {
            return Tyyppi.METALLI;
        }

        return this.alue[x][y];
    }

    public void paivita() {
        for (int x = 0; x < leveys; x++) {
            for (int y = korkeus - 1; y > 0; y--) {
                if (this.alue[x][y] == Tyyppi.TYHJA) {
                    continue;
                }

                if (this.alue[x][y] == Tyyppi.METALLI) {
                    continue;
                }

                if (this.alue[x][y] == Tyyppi.HIEKKA) {
                    siirraHiekkaa(x, y);
                    continue;
                }

                if (this.alue[x][y] == Tyyppi.VESI) {
                    siirraVetta(x, y);
                    continue;
                }
            }

        }
    }

    public boolean hiekkaSyrjayttaa(int x, int y) {
        if (x < 0 || y < 0 || x >= leveys || y >= korkeus) {
            return false;
        }

        if (this.alue[x][y] == Tyyppi.TYHJA) {
            return true;
        }

        if (this.alue[x][y] == Tyyppi.VESI) {
            return true;
        }

        return false;
    }

    public boolean vesiSyrjayttaa(int x, int y) {
        if (x < 0 || y < 0 || x >= leveys || y >= korkeus) {
            return false;
        }

        if (this.alue[x][y] == Tyyppi.TYHJA) {
            return true;
        }

        return false;
    }

    private void siirraHiekkaa(int x, int y) {
        List<Piste> vapaatAlla = kohdatAltaJoissa(x, y, Tyyppi.TYHJA, Tyyppi.VESI);
        if (vapaatAlla.isEmpty()) {
            return;
        }

        vaihdaSatunnaiseen(vapaatAlla, x, y);
    }

    private void siirraVetta(int x, int y) {
        List<Piste> vapaatAlla = kohdatAltaJoissa(x, y, Tyyppi.TYHJA);
        if (!vapaatAlla.isEmpty()) {
            vaihdaSatunnaiseen(vapaatAlla, x, y);
            return;
        }

        // katsotaan voiko mennä oikealle tai vasemmalle
        if (sisalto(x + 1, y) == Tyyppi.TYHJA) {
            vapaatAlla.add(new Piste(x + 1, y));
        }
        if (sisalto(x - 1, y) == Tyyppi.TYHJA) {
            vapaatAlla.add(new Piste(x - 1, y));
        }

        if (!vapaatAlla.isEmpty()) {
            vaihdaSatunnaiseen(vapaatAlla, x, y);
        }
    }

    private void vaihdaSatunnaiseen(List<Piste> vapaatAlla, int x, int y) {
        Collections.shuffle(vapaatAlla);
        Piste vaihtokohta = vapaatAlla.get(0);
        Tyyppi jemma = this.alue[x][y];
        this.alue[x][y] = this.alue[vaihtokohta.getX()][vaihtokohta.getY()];
        this.alue[vaihtokohta.getX()][vaihtokohta.getY()] = jemma;
    }

    public List<Piste> kohdatAltaJoissa(int x, int y, Tyyppi... tyypit) {
        List<Piste> kohdat = new ArrayList<>();

        for (int xMuutos = -1; xMuutos <= 1; xMuutos++) {
            Tyyppi sisalto = sisalto(x + xMuutos, y + 1);

            boolean loytyi = false;
            for (int i = 0; i < tyypit.length; i++) {
                Tyyppi tyyppi = tyypit[i];
                if (sisalto == tyyppi) {
                    loytyi = true;
                    break;
                }
            }

            if (loytyi) {
                kohdat.add(new Piste(x + xMuutos, y + 1));
            }
        }

        return kohdat;
    }
}


src/main/java/hiekkaranta/Tyyppi.java
package hiekkaranta;

public enum Tyyppi {
    TYHJA, METALLI, HIEKKA, VESI;
}




* */
