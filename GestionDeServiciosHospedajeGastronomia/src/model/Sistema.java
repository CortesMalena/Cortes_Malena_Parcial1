/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Sistema {
    private List<Servicio> lstServicio;
    private List<Servicio> lstServicioEnPromocion;
    private List<Servicio> lstServicioEnPromocionDia;

    public Sistema() {
        this.lstServicio = new ArrayList<Servicio>();
        this.lstServicioEnPromocion = new ArrayList<Servicio>();
        this.lstServicioEnPromocionDia = new ArrayList<Servicio>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sistema{");
        sb.append("lstServicio=");
        for (Servicio servicio : lstServicio) {
            sb.append("\n");
            sb.append(servicio.toString());
        }
        sb.append("\n");
        sb.append("lstServicioEnPromocion=");
        for (Servicio servicioPro : lstServicioEnPromocion) {
            sb.append("\n");
            sb.append(servicioPro.toString());
        }
        sb.append("\n");
        sb.append("lstServicioEnPromocionDia=");
        for (Servicio servicioProDia : lstServicioEnPromocionDia) {
            sb.append("\n");
            sb.append(servicioProDia.toString());
        }
        sb.append('}');
        return sb.toString();
    }
    
    public Servicio traerServicio (String codServicio) {
        Servicio servicioATraer = null;
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                servicioATraer = servicio;
                break;
            }
        }
        return servicioATraer;
    }
    
    public List<Servicio> traerServicio (boolean enPromocion) {
        
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                lstServicioEnPromocion.add(servicio);
            }
        }
        
        return lstServicioEnPromocion;
    }
    
    public List<Servicio> traerServicio (boolean enPromocion, LocalDate dia) throws NullPointerException {
        
        if (dia == null) {
            throw new NullPointerException("El dia no puede ser nulo");
        }
        
        for (Servicio servicioABuscar : lstServicio) {
            if (servicioABuscar.isEnPromocion() == enPromocion) {
                if (servicioABuscar instanceof Gastronomia && dia.getDayOfWeek().getValue() == ((Gastronomia) servicioABuscar).getDiaSemDesc()) {
                    lstServicioEnPromocionDia.add(servicioABuscar);
                }
            }
        }
        return lstServicioEnPromocionDia;
    }
    
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws ListaException, IllegalArgumentException{
        
        verificarSiExiste(codServicio);
        Servicio nuevoServicio = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
           
        lstServicio.add(nuevoServicio);
        
        
        return true; 
    }
    
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws ListaException, IllegalArgumentException{
        
        verificarSiExiste(codServicio);
        Servicio nuevoServicio = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
           
        lstServicio.add(nuevoServicio);
        
        
        return true;
    }
    
    public void verificarSiExiste(String codServicio) throws ListaException{
        Servicio existe = traerServicio(codServicio);
        
        if (existe != null) {
            throw new ListaException("El servicio ya se encuentra en la lista");
        }
    }
}
