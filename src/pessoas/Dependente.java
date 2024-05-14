package pessoas;

import java.util.UUID;

public class Dependente {
    private UUID id;
    private Cliente ClienteParente;

    public Cliente getClienteParente() {
        return ClienteParente;
    }

    public void setClienteParente(Cliente clienteParente) {
        ClienteParente = clienteParente;
    }
}
