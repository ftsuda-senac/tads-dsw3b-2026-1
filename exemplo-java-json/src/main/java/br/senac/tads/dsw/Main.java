package br.senac.tads.dsw;

public class Main {
    public static void main(String[] args) {

        Pessoa p = new Pessoa(1, "Fulano da Silva", "fulano@email.com");

        String json = """
                {
                    "id": %d,
                    "nome": "%s",
                    "email": "%s"
                }
                """;
        
        System.out.println(json.formatted(p.getId(), p.getNome(), p.getEmail()));
    }
}