package fr.univavignon.pokedex.api;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Implémentez la logique pour récupérer les métadonnées du Pokémon
        // Vous pouvez accéder à une source de données (par exemple une base de données, un fichier de configuration, etc.) pour obtenir les métadonnées
        // Ici, nous simulons simplement la création de métadonnées avec des valeurs arbitraires
        if (index < 0 || index >= 151) {
            throw new PokedexException("Invalid Pokemon index.");
        }
        return new PokemonMetadata(index, "tmp", 100, 100, 100);
    }
}
