package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	private Avion avion;
	private String fecha;
	private Ruta ruta;
	private Map<String, Tiquete> tiquetes;
	
	public Vuelo(Avion avion, String fecha, Ruta ruta) {
		this.avion = avion;
		this.fecha = fecha;
		this.ruta = ruta;
		this.tiquetes = new HashMap<>();
	}

	public Avion getAvion() {
		return avion;
	}

	public String getFecha() {
		return fecha;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public Collection<Tiquete> getTiquetes() {
		return tiquetes.values();
	}
	
	public int venderTiquetes​(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws InformacionInconsistenteException, VueloSobrevendidoException {
		int capacidadRestante = this.avion.getCapacidad() - cantidad + this.tiquetes.size();
		if (capacidadRestante > 0) {
			throw new VueloSobrevendidoException(this, Math.abs(capacidadRestante));
		}
		int costo = 0;
		int tarifa;
		Tiquete tiquete;
		for (int i = 0; i < cantidad ; i++) {
			tarifa = calculadora.calcularTarifa(this, cliente);
			costo += tarifa;
			tiquete = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
			GeneradorTiquetes.registrarTiquete(tiquete);
			this.tiquetes.put(tiquete.getCodigo(), tiquete);
		}
		return costo;
	}
	
	@Override
	public boolean equals(java.lang.Object obj) {
		if (obj.getClass() != Vuelo.class) {
			return false;
		}
		if (!obj.equals(this)) {
			return false;
		}
		return true;
	}
}
