package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	private static final double IMPUESTO = 0.28;
	public CalculadoraTarifas() {}
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente) throws InformacionInconsistenteException;
	
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected int calcularValorImpuesto(int costoBase) {
		return (int) (CalculadoraTarifas.IMPUESTO * costoBase);
	}
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) throws InformacionInconsistenteException {
		int costoBase = this.calcularCostoBase(vuelo, cliente);
		int descuento = (int) (this.calcularPorcentajeDescuento(cliente) * costoBase);
		int impuesto = this.calcularValorImpuesto(costoBase - descuento);
		return (costoBase - descuento) + impuesto;
	}
	
	protected int calcularDistanciaVuelo(Ruta ruta) {
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto destino = ruta.getDestino();
		int distancia = Aeropuerto.calcularDistancia(origen, destino);
		return distancia;
	}
}
