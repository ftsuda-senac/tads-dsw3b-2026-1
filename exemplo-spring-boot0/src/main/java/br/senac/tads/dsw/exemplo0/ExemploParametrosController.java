package br.senac.tads.dsw.exemplo0;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parametros")
public class ExemploParametrosController {

    private AtomicInteger contador = new AtomicInteger(0);

    private Map<Integer, Exemplo> mapPessoas = new ConcurrentHashMap<>();

    // http://localhost:8080/parametros/ex01?nome=Enzo%20dos%20Santos&email=enzo@email.com
    @GetMapping("/ex01")
    public Exemplo ex01(@RequestParam("nome") String nome,
                        @RequestParam("email") String email,
                        @RequestParam(name = "dataNascimento", required = false) LocalDate dataNascimento,
                        @RequestParam(name = "time", defaultValue = "Sem time") String time) {
        Exemplo ex = new SuperExemplo(contador.incrementAndGet(), 
            nome, email, dataNascimento, time);
        mapPessoas.put(ex.getId(), ex);
        return ex;
    }

    @GetMapping("/ex01b")
    public Exemplo ex01b(@RequestParam String nome,
                        @RequestParam String email,
                        @RequestParam(required = false) LocalDate dataNascimento,
                        @RequestParam(defaultValue = "Sem time") String time) {
        Exemplo ex = new SuperExemplo(contador.incrementAndGet(), 
            nome, email, dataNascimento, time);
        mapPessoas.put(ex.getId(), ex);
        return ex;
    }

    @GetMapping("/ex02/{username}")
    public String ex02(@PathVariable("username") String username) {
    return "{ \"username\": \"%s\" }".formatted(username); 
    }

    @GetMapping("/ex03")
    public String exe03(@RequestHeader("user-agent") String userAgent) {
        return "{ \"user-agent\": \"%s\" }".formatted(userAgent); 
    }

}
