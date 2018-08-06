package ar.com.PSGMecanico.modelo.dominio.pago.dto;

import java.util.Date;

public class PagoParcialesDTO {
	private Long idPagoParcial;
	private Double monto;
	private Date fecha;
	private String formaPago;

	public PagoParcialesDTO() {
		super();
	}

	public PagoParcialesDTO(Long idPagoParcial, Double monto, Date fecha, String formaPago) {
		super();
		this.idPagoParcial = idPagoParcial;
		this.monto = monto;
		this.fecha = fecha;
		this.formaPago = formaPago;
	}

	public Long getIdPagoParcial() {
		return idPagoParcial;
	}

	public void setIdPagoParcial(Long idPagoParcial) {
		this.idPagoParcial = idPagoParcial;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
}
