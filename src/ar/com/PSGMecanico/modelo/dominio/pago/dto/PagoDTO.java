package ar.com.PSGMecanico.modelo.dominio.pago.dto;

import java.util.Date;

public class PagoDTO {
	private Long idPago;
	private Long idTrabajo;
	private Date fecha;
	private Double montoTotal;
	private String detalle;
	private String estadoPago;
	
	public PagoDTO() {
		super();
	}
	
	public PagoDTO(Long idPago, Long idTrabajo, Date fecha, Double montoTotal, String detalle, String estadoPago) {
		super();
		this.idPago = idPago;
		this.idTrabajo = idTrabajo;
		this.fecha = fecha;
		this.montoTotal = montoTotal;
		this.detalle = detalle;
		this.estadoPago = estadoPago;
	}

	public Long getIdPago() {
		return idPago;
	}

	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}

	public Long getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(Long idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(String estadoPago) {
		this.estadoPago = estadoPago;
	}
	
}
