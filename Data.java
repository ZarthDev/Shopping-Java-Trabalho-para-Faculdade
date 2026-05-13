public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data ( int dia, int mes, int ano ) {
        if (validarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida. Definindo data padrão 01/01/2000.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    private boolean validarData(int dia, int mes, int ano) {
    if (ano < 1 || mes < 1 || mes > 12 || dia < 1) return false;

    boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    int[] diasPorMes = {31, bissexto ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    return dia <= diasPorMes[mes - 1];
}

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}
