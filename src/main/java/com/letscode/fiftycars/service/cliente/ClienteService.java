
package com.letscode.fiftycars.service.cliente;

import com.letscode.fiftycars.domain.cliente.Cliente;
import com.letscode.fiftycars.repository.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {


        return clienteRepository.findAll();
    }

    @Override
    public List<String> listarNomeClientes() {
        return clienteRepository.findAll().stream()
                .map(x -> x.getNome().toUpperCase())
                .collect(Collectors.toList());
    }

    @Override
    public Cliente buscarClientePorNome(String nome) {
        Optional<Cliente> optionalCliente = clienteRepository.findAll().stream()
                .filter(x -> x.getNome().equals(nome)) //Diego Neri
                .findFirst();

        //Existe um objeto dentro do optional

        /*if(optionalCliente.isPresent()){
            return optionalCliente.get();
        } else {
            //qualquer outra lógica
        }*/


        //Checar existencia de valor e determinar uma função para ser executada
        optionalCliente.ifPresent(value -> {
            System.out.println("[LOG] >> Cliente encontrado.");
        });

        //Retorna, caso exista, o objeto, senão retorna uma exception (precisa extender a classe Throwable)
        return optionalCliente.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        //Retorna, caso exista, o objeto, senão retorna a instância definida no "orElse"
        //return optionalCliente.orElse(new Cliente(0, "Cliente desconhecido.", LocalDate.of(1900, 01, 01), '?'));
        
    }
}
