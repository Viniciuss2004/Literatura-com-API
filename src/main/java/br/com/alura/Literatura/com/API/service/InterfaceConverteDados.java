package br.com.alura.Literatura.com.API.service;

import com.fasterxml.jackson.core.type.TypeReference;

public interface InterfaceConverteDados {
    <T> T obterDados(String json, Class<T> classe);
    <T> T obterDados(String json, TypeReference<T> typeReference);
}
