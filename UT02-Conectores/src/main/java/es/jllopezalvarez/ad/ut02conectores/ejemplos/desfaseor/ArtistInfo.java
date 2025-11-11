package es.jllopezalvarez.ad.ut02conectores.ejemplos.desfaseor;

import lombok.*;

import java.util.Objects;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ArtistInfo {
    @EqualsAndHashCode.Include
    private final int artistId;
    private final String artistName;
    private final int trackCount;

//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        ArtistInfo that = (ArtistInfo) o;
//        return artistId == that.artistId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(artistId);
//    }
}
