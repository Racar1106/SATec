package project.modelo;

public class Vehículo {
    private String placa;
    private TipoVehiculo tipoVehículo;
    
    public Vehículo(String p, TipoVehiculo tv){
        this.placa = p;
        this.tipoVehículo = tv;
    }

    public String getPlaca(){
        return placa;
    }
    public TipoVehiculo getTipoVehículo(){
        return tipoVehículo;
    }

    public void setPlaca(String p){
        this.placa = p;
    }
    public void setTipoVehículo(TipoVehiculo tp){
        this.tipoVehículo = tp;
    }
}
