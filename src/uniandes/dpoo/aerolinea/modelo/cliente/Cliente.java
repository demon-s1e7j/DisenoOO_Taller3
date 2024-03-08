package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	
	public Cliente() {
		this.tiquetesSinUsar = new ArrayList<Tiquete>();
		this.tiquetesUsados = new ArrayList<Tiquete>();
	}
	
	public abstract String getTipoCliente();
	
	public abstract String getIdentificador();
	
	public void agregarTiquete(Tiquete tiquete) {
		if (!tiquete.esUsado()) {
			this.tiquetesSinUsar.add(tiquete);
		} else {
			this.tiquetesUsados.add(tiquete);
		}
	}
	
	public int calcularValorTotalTiquetes() {
		int valor = 0;
		valor += this.tiquetesSinUsar.stream().mapToInt(e -> e.getTarifa()).sum();
		valor += this.tiquetesUsados.stream().mapToInt(e -> e.getTarifa()).sum();
		return valor;
	}
	
	public int calcularSaldo() {
		int valor = this.tiquetesSinUsar.stream().mapToInt(e -> e.getTarifa()).sum();
		return valor;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		Collection<Tiquete> tiquetes = vuelo.getTiquetes();
		this.tiquetesSinUsar.stream().forEach(tiquet -> {
			if (tiquetes.contains(tiquet)) {
				this.tiquetesUsados.add(tiquet);
				this.tiquetesSinUsar.remove(tiquet);
			}
		});
	}
}
