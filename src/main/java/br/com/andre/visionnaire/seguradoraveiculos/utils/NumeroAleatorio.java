package br.com.andre.visionnaire.seguradoraveiculos.utils;

import br.com.andre.visionnaire.seguradoraveiculos.repository.ApoliceRepository;

import java.util.Random;

public class NumeroAleatorio {

    public static final int MAX = 1000000000;

    public static String gerarNumeroAleatorioValidoParaApolice(ApoliceRepository apoliceRepository) {
        String numeroValido = numeroAleatorio();
        return apoliceRepository.existsById(numeroValido) ?
                gerarNumeroAleatorioValidoParaApolice(apoliceRepository) :
                numeroValido;
    }

    public static String numeroAleatorio() {
        Random random  = new Random();
        return String.valueOf(random.nextInt(MAX));
    }
}
