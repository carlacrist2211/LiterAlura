package br.com.alura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Livros(
        @JsonAlias("id") Integer id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") String autor,
        @JsonAlias("name") String nome,
        @JsonAlias("birth-year") Integer anoNascimento, // Coloque dentro dos parênteses
        @JsonAlias("death-year") Integer anoFalecimento // Coloque dentro dos parênteses
) {

    @Override
    public String toString() {
        return String.format("id: %d titulo: %s nome: %s  anoNascimento: %d anoFalecimento: %d",
                id, titulo, nome, anoNascimento, anoFalecimento);
    }

    public String getId() {
        return "";
    }

    public String getTitle() {
        return "";
    }

    public String getAuthors() {
        return "";
    }

    public String getName() {
        return "";
    }

    public String getBirthYear() {
        return "";
    }

    public String getDeathYear() {
        return null;
    }
}
