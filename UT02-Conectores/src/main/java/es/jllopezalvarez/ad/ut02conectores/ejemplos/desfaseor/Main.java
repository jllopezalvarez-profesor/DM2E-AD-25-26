package es.jllopezalvarez.ad.ut02conectores.ejemplos.desfaseor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArtistDataAccess artistDataAccess = new ArtistDataAccess();
        List<ArtistInfo> info = artistDataAccess.getAllArtistInfo();
        for (ArtistInfo artistInfo : info) {
            System.out.println(artistInfo);
        }

        List<ArtistInfo> info2 = artistDataAccess.getAllArtistInfo();
        for (ArtistInfo artistInfo : info2) {
            System.out.println(artistInfo);
        }


    }
}
