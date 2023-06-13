public class VeiculoNaoRemovidoException extends Exception {
    private String motivo;

    public VeiculoNaoRemovidoException(String motivo) {
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }
}
