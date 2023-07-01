package ifood.delivery.controller;
import ifood.delivery.model.Cliente;
import ifood.delivery.repository.ClienteRepository;
import ifood.delivery.model.Cliente;
import ifood.delivery.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController{
    @Autowired
    private ClienteRepository clienteRepository;
    private ClienteService clienteService;
    @GetMapping("texto1")
    public String mostrarTexto(){
        return "sejam bem vindos a minha primeira Api rest";
    }
    @PostMapping("salvar")
    public Cliente salvar (@RequestBody Cliente cliente){
      return clienteService.salvarCliente(cliente);
    }

    @GetMapping("listar-todos")
      public List<Cliente> listartodos(){
        return clienteRepository.findAll();
    }
    @GetMapping ("buscar/{id}")
    public Optional<Cliente> buscarporId(@PathVariable Long id){
        return clienteRepository.findById(id);
    }

    @DeleteMapping("delete-todos")
    public void deletartodos(){
        clienteRepository.deleteAll();
    }

    @DeleteMapping ("deletar/{id}")
    public void deletarPorId(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }

}




