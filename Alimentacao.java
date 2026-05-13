public class Alimentacao extends Loja {
    private Data dataAlvorada;

    public Alimentacao(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, Data dataAlvorada) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, 100);
        this.dataAlvorada = dataAlvorada;
    }

    public Data getDataAlvorada() {
        return dataAlvorada;
    }

    public void setDataAlvorada(Data dataAlvorada) {
        this.dataAlvorada = dataAlvorada;
    }

    @Override
    public String toString() {
        return super.toString() + "\nData de Alvorada: " + dataAlvorada;
    }
}
