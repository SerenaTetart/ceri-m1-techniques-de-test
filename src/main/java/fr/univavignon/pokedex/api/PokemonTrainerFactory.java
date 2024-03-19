package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Créez une instance de PokemonTrainer en utilisant les paramètres donnés
        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory()));
    }
}