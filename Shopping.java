public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int maxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[maxLojas];
    }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(int  tipo) {
        int cont = 0;
        for (Loja l : lojas) {
            if (tipo == 3 && l instanceof Cosmetico) cont++;
            else if (tipo == 5 && l instanceof Vestuario) cont++;
            else if (tipo == 2 && l instanceof Bijuteria) cont++;
            else if (tipo == 1 && l instanceof Alimentacao) cont++;
            else if (tipo == 4 && l instanceof Informatica) cont++;
        }
        return (cont == 0) ? -1 : cont;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica maisCara = null;
        for (Loja l : lojas) {
            if (l instanceof Informatica) {
                Informatica info = (Informatica) l;
                if (maisCara == null || info.getSeguroEletronicos() > maisCara.getSeguroEletronicos()) {
                    maisCara = info;
                }
            }
        }
        return maisCara;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }
}