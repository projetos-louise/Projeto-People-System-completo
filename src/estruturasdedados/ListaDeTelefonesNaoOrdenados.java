package estruturasdedados;

import composicoes.Telefone;

public class ListaDeTelefonesNaoOrdenados {
    //Vetor de telefones
    private Telefone[] telefones;
    //controle do tamanho = quantidade de  elementos
    private int tamanho;
    //Capacidade "inicial" (pode ser alterado depois)
    private static final int CAPACIDADE_PADRAO = 7;

    //Contrutor da LISTA
    public ListaDeTelefonesNaoOrdenados() {
        this.telefones = new Telefone[CAPACIDADE_PADRAO];
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }
    //Adicionar telefone com restrição de capacidade
    public void addTelefone1(Telefone telefone){
        //length ele pegar a capacidade atual em tempo de excução
        //Caso CAPACIDADE_PADRAO seja alterada
        if(tamanho == CAPACIDADE_PADRAO){
            System.out.println("Não há mais espaço!");
            //"mudar a capacidade" -> Futuro
        } else {
            telefones[tamanho] = telefone;
            this.tamanho = tamanho + 1;
        }
    }
    public void addTelefone(Telefone telefone){
        //length ele pegar a capacidade atual em tempo de excução
        //Caso CAPACIDADE_PADRAO seja alterada
        if(tamanho < CAPACIDADE_PADRAO){
            //Já que o tamanho é "index + 1",
            //podemos utilizar o bamanho para adicionar
            //no index vazio
            telefones[tamanho] = telefone;
            this.tamanho = tamanho + 1;
        } else {
            System.out.println("Não há mais espaço!");
        }
    }

    private int buscarTelefoneIndex(Telefone telefone) {
        for(int i = 0; i < tamanho; i++){
            //validar ser os telefones são iguais
            if(telefones[i].equals(telefone)){
                return i;
            }
        }
        System.out.println("Telefone não encontrado!");
        return -1;

    }
    public void removerTelefone(Telefone telefone){
        //Pegar o index do telefone na lista
        int index = buscarTelefoneIndex(telefone);
        //validar se foi encontrado ou não
        if(index != -1){
            for(int i = index; i < tamanho -1; i++){
                telefones[i] = telefones[i + 1];
            }
        }
        //Pego o úlitmo elemento e coloco null nele,
        //decremento o tamanho e atualizo no objeto
        this.tamanho = tamanho - 1;
        telefones[tamanho] = null;

        //Pegar o último elemento e "apagar"
        //E diminuir o tamanho
    }

    public void exibirTelefones(){
        for(int i = 0; i < tamanho; i++){
            System.out.println("Telefones da lista: "
            + telefones[i]);
        }
    }



}
