public class Piloto extends Pessoa {
    
    private static final String STRING = "]";
    public int length;
    private int _matricula;
    private String _cnh;

    public Piloto(String nome, int matricula, String cnh, String cpf){
        super(nome, cpf);
        _matricula = matricula;
        _cnh = cnh;
    }

    public int getMatricula(){
        return _matricula;
    }

    public String getCnh(){
        return _cnh;
    }

    @Override
    public String toString() {
        return super.toString() + ":[matricula=" + _matricula + ", cnh=" + _cnh + STRING;
    }
}
