package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private List<PokemonMetadata> metadataList;

    public PokemonMetadataProvider() {
        this.metadataList = new ArrayList<>();
        metadataList.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
        metadataList.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
    }
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Implémentez la logique pour récupérer les métadonnées du Pokémon
        // Vous pouvez accéder à une source de données (par exemple une base de données, un fichier de configuration, etc.) pour obtenir les métadonnées
        // Ici, nous simulons simplement la création de métadonnées avec des valeurs arbitraires
        if (index < 0 || index >= 151) {
            throw new PokedexException("Invalid Pokemon index.");
        }
        PokemonMetadata metadata = metadataList.get(index);
        if(metadata == null) throw new PokedexException("Invalid Pokemon index.");
        return metadata;
    }
}
