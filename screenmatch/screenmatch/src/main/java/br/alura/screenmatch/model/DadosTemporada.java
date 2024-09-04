package br.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(@JsonAlias("season") String numeroEp, @JsonAlias("Episodes") List<DadosEpisodios> episodios) {
}
