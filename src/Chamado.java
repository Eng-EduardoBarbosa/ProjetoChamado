public class Chamado {

    private int id;
    private String titulo;
    private String descricao;
    private String status;

    public Chamado(int id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = "Aberto";
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public void alterarStatus(String novoStatus) {
        this.status = novoStatus;
    }
}