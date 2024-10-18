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
public class Hospedaje extends Servicio {
    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) {
        super(codServicio, porcentajeDescuento, enPromocion);
        setHospedaje(hospedaje);
        setPrecioPorNoche(precioPorNoche);
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) throws NullPointerException {
        if (hospedaje == null) {
            throw new NullPointerException("El hospedaje no puede ser nulo");
        }
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) throws IllegalArgumentException{
        if (precioPorNoche < 1) {
            throw new IllegalArgumentException("el precio por noche debe ser mayor a 1");
        }
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hospedaje{");
        sb.append("codServicio=").append(codServicio);
        sb.append(", porcentajeDescuento=").append(porcentajeDescuento);
        sb.append(", enPromocion=").append(enPromocion);
        sb.append(", hospedaje=").append(hospedaje);
        sb.append(", precioPorNoche=").append(precioPorNoche);
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public double calcularPrecioFinal(LocalDate dia) throws NullPointerException{
        
        if (dia == null) {
            throw new NullPointerException("El dia no puede ser nulo");
        }
        
        int diaEnNumero = dia.getDayOfWeek().getValue();
        
        if (this.enPromocion) {
            if (diaEnNumero != 6 || diaEnNumero != 7 ) {
                precioPorNoche -= (precioPorNoche * ( this.porcentajeDescuento/ 100));
            }
        }
        
        return precioPorNoche;
    }
    
}
