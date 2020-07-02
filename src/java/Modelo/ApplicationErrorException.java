
package Modelo;

public class ApplicationErrorException extends Exception{
    private String lugar;
    private int codigo;
    public ApplicationErrorException(String mensaje,int codigo, String lugar) {
        super(mensaje); //ESTAMOS HEREDANDO DE EXCEPTION
        this.codigo=codigo;
        this.lugar=lugar;
    }
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
