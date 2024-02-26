package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
	
	public static final double COSTO_POR_KM = 1000;
	
	public CalculadoraTarifasTemporadaAlta() {};

	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int distancia = this.calcularDistanciaVuelo(vuelo.getRuta());
		return (int) (distancia * CalculadoraTarifasTemporadaAlta.COSTO_POR_KM);
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

}
