package br.alura.screenmatch.service;

import br.alura.screenmatch.model.DadosEpisodios;
import br.alura.screenmatch.model.DadosSerie;
import br.alura.screenmatch.model.DadosTemporada;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsumoAPI {
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=suachave";
    private final String COMPLEMENTO = "&season=1&episode=1";
    private String json;
    private String buscar;

    ConverteDados converteDados = new ConverteDados();

    public void buscaDados() {
        Scanner pesquisa = new Scanner(System.in);
        System.out.println("Informe o nome da serie que deseja pesquisar");
        buscar = pesquisa.next();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ENDERECO + buscar.replace(" ", "+")+ API_KEY))
                .build();
        HttpResponse<String> response = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void dadosConvert() {
        System.out.println(json);
        String local = json;
        DadosSerie dados = converteDados.obterDados(local, DadosSerie.class);
        System.out.println(dados);
    }

    public void teste(){
        DadosSerie dados = new DadosSerie("",0,"");
        DadosEpisodios dadosEpisodios = converteDados.obterDados(json, DadosEpisodios.class);
        System.out.println(dadosEpisodios);

        List<DadosTemporada> temporadas = new ArrayList<>();
for(int i = 1; i<= dados.totalTemporadas(); i++) {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ENDERECO + buscar.replace(" ", "+") + "&Season=" + i + API_KEY))
                    .build();
            HttpResponse<String> response = null;
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
               String json1 = response.body();

            DadosTemporada dadosTemporada = converteDados.obterDados(json1, DadosTemporada.class);
            temporadas.add(dadosTemporada);}

            temporadas.forEach(System.out::println);

        /*for (int i = 0; i < dados.totalTemporadas(); i++) {
            List<DadosEpisodios> episodiosTemporada = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size() ; j++) {
                System.out.println(episodiosTemporada.get(j).titulo());
            }*/
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

    }
}
