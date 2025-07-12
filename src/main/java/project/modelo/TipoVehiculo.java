package project.modelo;

public enum TipoVehiculo {
    Automovil,
    Camioneta,
    Bus,
    Bicicleta;

    @Override
    public String toString() {
        switch (this) {
            case Automovil: return "Automóvil";
            case Camioneta: return "Camioneta";
            case Bus:       return "Bus";
            default:        return "Desconocido";
        }
    }
}
