package ifood.delivery.service;

import ifood.delivery.model.Cliente;
import ifood.delivery.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) {
       var clienteSalva = clienteRepository.findByDocumento(cliente.getDocumento());

        if (clienteSalva.isPresent()) {
            System.out.println("cliente existente. Não pode salvar");
        } else {
            return clienteRepository.save(cliente);
        }
            return new Cliente();
    }
}