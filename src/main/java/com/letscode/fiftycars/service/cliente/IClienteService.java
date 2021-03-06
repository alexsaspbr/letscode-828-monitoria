package com.letscode.fiftycars.service.cliente;

import com.letscode.fiftycars.domain.cliente.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> listarClientes();

    List<String> listarNomeClientes();

    Cliente buscarClientePorNome(String nome);
}
