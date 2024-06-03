package estruturasdedados;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTelefonesNaoOrdenados {
    private List<String> telefones;

    public ListaDeTelefonesNaoOrdenados() {
        this.telefones = new ArrayList<>();
    }

    public void adicionarTelefone(String telefone) {
        this.telefones.add(telefone);
    }

    @Override
    public String toString() {
        return "ListaDeTelefonesNaoOrdenados{" +
                "telefones=" + telefones +
                '}';
    }
}
