package com.franklanches.exceptions;

public class AddressAlreadyRegisteredException extends RuntimeException {
    public AddressAlreadyRegisteredException(String cep, String number) {
        super("O endereço com CEP "+ cep.toString() + " e Nº" + number + " já cadastrado!");
    }
}
