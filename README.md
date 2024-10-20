# 🏨 Sistema de Servicios de Hospedaje y Gastronomía

---

## Alumno

**Nombre del alumno**: Cortes Malena Nahir

## 📄 Descripción del Proyecto

Este proyecto es un sistema de gestión diseñado para administrar servicios de hospedaje y gastronomía, implementando
conceptos de Programación Orientada a Objetos (POO) en Java. El objetivo es crear una aplicación que permita gestionar
estos servicios, calcular precios finales con promociones y aplicar validaciones utilizando excepciones.

### Objetivos

- Implementar un modelo orientado a objetos que refleje la gestión de servicios de hospedaje y gastronomía.
- Aplicar promociones y descuentos según las condiciones definidas.
- Validar la integridad de los datos utilizando excepciones específicas.

## 🛠️ Funcionalidades del Sistema

El sistema ofrece las siguientes funcionalidades:

### 1. Gestión de Servicios

- **Servicios de Hospedaje**: Administración de hospedajes como habitaciones o cabañas.
- **Servicios de Gastronomía**: Manejo de servicios gastronómicos como menús específicos.
- **Aplicación de Promociones**: Aplicación de descuentos según el día de la semana y si el servicio está en promoción.

### 2. Promociones y Descuentos

- Promociones aplicables a servicios de hospedaje durante días hábiles (lunes a viernes).
- Descuentos para servicios de gastronomía basados en el día de la semana seleccionado.

### 3. Validaciones

- Manejo de excepciones para situaciones como códigos de servicio inválidos o duplicados, parametros mal proporcionados y atributos que no cumplen con las reglas del negocio. Aquellas excepciones que se utilizan son IllegalArgumentException, NullPointerException, ListaException y Exception (En caso de haber un error no captado por las excepciones especificas anteriores).

- Ademas de un modulo llamado verificarSiExiste dentro de Sistema que tira la excepcion "ListaException" en caso de haber repetido un servicio dentro de la lista.

### 4. Cálculo de Precio Final

- Método para calcular el precio final del servicio, teniendo en cuenta promociones y descuentos según el día y el tipo de servicio. Tira NullPointerException en caso de pasar mal el parametro del dia.

## 📦 Estructura del Proyecto

El proyecto está compuesto por las siguientes clases y subclases:

### 1. **Servicio** (Clase Abstracta)

- **Atributos**:
    - `codServicio`: Código del servicio (6 caracteres, con validación, tambien para nulos).
    - `porcentajeDescuento`: Porcentaje de descuento aplicable al servicio (con validacion para negativos).
    - `enPromocion`: Indica si el servicio está en promoción.
- **Métodos Abstractos**:
    - `calcularPrecioFinal(LocalDate dia)`: Método abstracto para calcular el precio final del servicio, según el día, tira una NullPointerException.

### 2. **Hospedaje** (Subclase de Servicio)

- **Atributos Específicos**:
    - `hospedaje`: Tipo de hospedaje (ej. Cabaña, Habitación). (Con validacion para nulos)
    - `precioPorNoche`: Precio por noche de hospedaje.(con validacion para negativos)
- **Métodos**:
    - `calcularPrecioFinal(LocalDate dia)`: Aplica descuentos entre semana (lunes a viernes) si el servicio está en promoción. Valida que el dia no sea null.

### 3. **Gastronomía** (Subclase de Servicio)

- **Atributos Específicos**:
    - `gastronomia`: Tipo de servicio gastronómico (ej. desayuno, almuerzo). (Con validacion para nulos)
    - `precio`: Precio del servicio gastronómico. (con validacion para negativos)
    - `diaSemDesc`: Día de la semana en que se aplica el descuento. (Verifica que efectivamente sea un dia de semana, que sea un int del 1 al 7)
- **Métodos**:
    - `calcularPrecioFinal(LocalDate dia)`: Aplica el porcentaje de descuento si el día corresponde al día de descuento y si está en promoción. Valida que el dia no sea null

### 4. **Sistema** (Clase Principal)

- **Atributos**:
    - `lstServicio`: Lista de servicios disponibles (hospedaje y gastronomía).
    - `lstServicioEnPromocion`: Lista de servicios disponibles (hospedaje y gastronomía) y en promocion.
    - `lstServicioEnPromocionDia`: Lista de servicios disponibles (hospedaje y gastronomía), en promocion y segun el dia que apliquen descuentos.
- **Métodos**:
    - `traerServicio(String codServicio)`: Retorna un servicio específico según su código sino retorna null.
    - `traerServicio(boolean enPromocion)`: Retorna una lista de servicios que están en promoción.
    - `traerServicio(boolean enPromocion, LocalDate dia)`: Retorna una lista de servicios en promoción y que apliquen descuentos según la fecha.
    -`agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc)`:
    Agrega un servicio de gastronomía al sistema, hace uso de verificarSiExiste para la validacion sobre repetitivos, y salta la respectiva excepcion de IllegalArgumentException en caso de instanciar mal el objeto.
    - `agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche)`:
    Agrega un servicio de hospedaje al sistema, hace uso de verificarSiExiste para la validacion sobre repetitivos, y salta la respectiva excepcion de IllegalArgumentException en caso de instanciar mal el objeto.
    -
    - `verificarSiExiste(String codServicio)`: verifica si el objeto ya existe en la lista de servicios de sistemas. De lo contrario tira una excepcion llamada ListaException.

### 5. **ListaException** (Subclase de Exception)
    - `Constructor: ListaException`(String message).