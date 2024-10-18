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
public class Gastronomia extends Servicio {
    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) {
        super(codServicio, porcentajeDescuento, enPromocion);
        setGastronomia(gastronomia);
        setPrecio(precio);
        setDiaSemDesc(diaSemDesc);
    }

    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) throws NullPointerException {
        if (gastronomia == null) {
            throw new NullPointerException("El hospedaje no puede ser nulo"); 
        }
        
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) throws IllegalArgumentException{
        if (precio < 1) {
            throw new IllegalArgumentException("el precio no puede ser menor a 1");
        }
        this.precio = precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    public void setDiaSemDesc(int diaSemDesc) {
        if (diaSemDesc < 1 || diaSemDesc > 7 ) {
            throw new IllegalArgumentException("el dia de semana nopuede ser menor a 1 o mayor a 7");
        }
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gastronomia{");
        sb.append("codServicio=").append(codServicio);
        sb.append(", porcentajeDescuento=").append(porcentajeDescuento);
        sb.append(", enPromocion=").append(enPromocion);
        sb.append(", gastronomia=").append(gastronomia);
        sb.append(", precio=").append(precio);
        sb.append(", diaSemDesc=").append(diaSemDesc);
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public double calcularPrecioFinal(LocalDate dia) throws NullPointerException {
        /**
        * calcula el precio final
        *
        * @param LocalDate dia al realizar la compra
        * @return doubleprecio
        * @throws NullPointerException en caso de pasar un dia nulo .
        */
        if (dia == null) {
            throw new NullPointerException("El dia no puede ser nulo");
        }
        
        int diaEnNumero = dia.getDayOfWeek().getValue();
        
        
        if (enPromocion) {
            if (diaEnNumero == diaSemDesc) {
                precio -= (precio * ( porcentajeDescuento/100));
            }
        }
        
        return precio;
    }
}
    

