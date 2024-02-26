package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	protected final int COSTO_POR_KM_CORPORATIVO = 900;
	protected final int COSTO_POR_KM_NATURAL = 600;
	protected final double DESCUENTO_GRANDES = 0.2;
	protected final double DESCUENTO_MEDIANAS = 0.1;
	protected final double DESCUENTO_PEQ = 0.02;
	
	public CalculadoraTarifasTemporadaBaja() {};
	
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) throws InformacionInconsistenteException {
		int distancia = this.calcularDistanciaVuelo(vuelo.getRuta());
		int costo = 0;
		switch (cliente.getTipoCliente()) {
		case ClienteCorporativo.CORPORATIVO:
			costo = this.COSTO_POR_KM_CORPORATIVO;
			break;
		case ClientePersonal.NATURAL:
			costo = this.COSTO_POR_KM_NATURAL;
			break;
		default:
			throw new InformacionInconsistenteException("El cliente no es de ningun tipo");
		}
		return distancia * costo;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		double descuento = 0;
		if (cliente.getTipoCliente().equals("Natural")) {
			return descuento;
		}
		switch (cliente.getTamanoEmpresa()) {
		case ClienteCorporativo.GRANDE:
			descuento = this.DESCUENTO_GRANDES;
			break;
		case ClienteCorporativo.MEDIANA:
			descuento = this.DESCUENTO_MEDIANAS;
			break;
		case ClienteCorporativo.PEQUENA:
			descuento = this.DESCUENTO_PEQ;
			break;
		default:
			throw new InformacionInconsistenteException("El tipo de la empresa no coincide con ninguna");
		}
		return descuento;
	}

}
