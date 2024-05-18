package interfaces;

public interface Cadastramento {

    void cadastrar();

    /**
     * Realiza o cadastro de um novo cliente.
     */
    void realizarCadastroCliente();

    /**
     * Realiza o cadastro de um novo funcionário.
     */
    void realizarCadastroFuncionario();

    /**
     * Realiza o cadastro de um novo dependente.
     */
    void realizarCadastroDependente();
}
