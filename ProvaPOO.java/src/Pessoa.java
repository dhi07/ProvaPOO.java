public class Pessoa {
    private String _nome;
    private String _cpf;

   
    public Pessoa(String _nome, String _cpf) {
        this.set_nome(_nome);
        this.set_cpf(_cpf);
    }


    public String get_cpf() {
        return _cpf;
    }


    public void set_cpf(String _cpf) {
        this._cpf = _cpf;
    }


    public String get_nome() {
        return _nome;
    }


    public void set_nome(String _nome) {
        this._nome = _nome;
    }
}
