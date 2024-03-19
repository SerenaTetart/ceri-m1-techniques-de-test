package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Pokedex implements IPokedex {

    private List<Pokemon> pokemonList;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemonList = new ArrayList<>();
    }

    @Override
    public int size() {
        return pokemonList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemonList.size()-1; // Index starts from 0
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemonList.size()) {
            throw new PokedexException("Invalid Pokemon index.");
        }
        return pokemonList.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemonList);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemonList);
        Collections.sort(sortedList, order);
        return Collections.unmodifiableList(sortedList);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        try {
            PokemonMetadata metadata = getPokemonMetadata(index);
            Random random = new Random();
            int atk = metadata.getAttack() + random.nextInt(16);
            int def = metadata.getDefense() + random.nextInt(16);
            int stamina = metadata.getStamina() + random.nextInt(16);
            pokemon = new Pokemon(index, metadata.getName(), atk, def, stamina, cp, hp, dust, candy, 50);
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
        return pokemon;
    }
}