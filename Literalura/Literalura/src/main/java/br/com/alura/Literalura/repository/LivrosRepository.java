package br.com.alura.Literalura.repository;

import br.com.alura.Literalura.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface LivrosRepository extends JpaRepository<Livros, Long> {
    Optional<Livros> findByNomeContainingIgnoreCase(String nome);


    List<Livros> findByTitulo(String nome);

    List<Livros> findByIdioma(String idioma);

}

