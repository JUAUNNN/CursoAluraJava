package br.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodios(@JsonAlias("Title")String titulo,@JsonAlias("episode") String episodio,
                             @JsonAlias("imdbRating") String avaliacao,@JsonAlias("Released") String anoDeLancamento) {
}
