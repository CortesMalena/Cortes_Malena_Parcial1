/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.time.LocalDate;
import java.time.Month;
import model.Gastronomia;
import model.Hospedaje;
import model.ListaException;
import model.Servicio;
import model.Sistema;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("1-1");
            Servicio gastronomia = new Gastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println("1-2");
            Servicio gastronomia = new Gastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            
            System.out.println("1-3");
            Servicio Hospedaje = new Hospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
            
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println("1-4");
            Servicio gastronomia = new Gastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            Servicio hospedaje = new Hospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
            
            System.out.println("2-1");
            double costoGast = gastronomia.calcularPrecioFinal(LocalDate.of(2020, 10, 28));
            System.out.println(costoGast);
            
            System.out.println("2-2");
            double costoHosp = hospedaje.calcularPrecioFinal(LocalDate.of(2020, 10, 27));
            System.out.println(costoHosp);
            
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println("3-1");
            Sistema sistema = new Sistema();
            
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3); //al ser agregacion se podria pasar directamente el objeto
            sistema.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, true, "Gaseosa", 120.0,3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0);
            
            System.out.println(sistema);
            System.out.println("\n");
            System.out.println(sistema.traerServicio(true));
            System.out.println("\n");
            System.out.println(sistema.traerServicio(true, LocalDate.of(2020, 10, 28)));
            
            System.out.println("\n");
            System.out.println(sistema);
            
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        } catch (ListaException e){
            System.out.println(e.getMessage());
        }
    }
    
}
