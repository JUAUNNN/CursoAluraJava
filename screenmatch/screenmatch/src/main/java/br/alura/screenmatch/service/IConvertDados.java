package br.alura.screenmatch.service;

public interface IConvertDados {
    <T> T obterDados (String json, Class<T> classe);
}
