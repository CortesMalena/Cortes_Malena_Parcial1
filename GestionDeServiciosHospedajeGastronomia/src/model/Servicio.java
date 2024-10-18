/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public abstract class Servicio {
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) {
        setCodServicio(codServicio);
        setPorcentajeDescuento(porcentajeDescuento);
        this.enPromocion = enPromocion;
        
    }

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) throws IllegalArgumentException,NullPointerException {
        if (codServicio == null) {
            throw new NullPointerException("El servicio no puede ser nulo");
        }
        
        if (codServicio.length()!= 6) {
            throw new IllegalArgumentException("Los caracteres deben ser exactamente 6");
        }
        this.codServicio = codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 1) {
            throw new IllegalArgumentException("El porcentaje de descuento no puede ser negativo");
        }
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Servicio{");
        sb.append("codServicio=").append(codServicio);
        sb.append(", porcentajeDescuento=").append(porcentajeDescuento);
        sb.append(", enPromocion=").append(enPromocion);
        sb.append('}');
        return sb.toString();
    }
    
    public abstract double calcularPrecioFinal(LocalDate dia) throws NullPointerException;
    
}
