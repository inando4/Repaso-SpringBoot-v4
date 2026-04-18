# Fase 1: Fundamentos de Spring Core - Apuntes

## 1. Inversión de Control (IoC) e Inyección de Dependencias (DI)
*   **IoC (Inversion of Control):** Spring toma el control de la creación y gestión del ciclo de vida de los objetos (Beans). En lugar de usar `new` en tu código, Spring lo hace por ti.
*   **DI (Dependency Injection):** Spring conecta los objetos entre sí de forma automática pasándoles las dependencias que necesitan.
*   **`@Component`:** Marca una clase propia para que Spring la registre en su contexto y la convierta en un Bean.
*   **Inyección por Constructor:** Es la mejor práctica recomendada. Si la clase tiene un solo constructor, Spring inyecta las dependencias automáticamente (ya no es estrictamente necesario poner `@Autowired`).
*   **`@Configuration` y `@Bean`:** Se usan para gestionar clases externas (librerías de terceros) que no podemos modificar. `@Configuration` va en la clase de configuración, y `@Bean` en el método que retorna la instancia creada manualmente (`new Objeto()`).

## 2. Application Context y Ciclo de Vida
*   **Application Context:** Es el contenedor principal de Spring (el "almacén"). Escanea, instancia, inyecta y registra todos los Beans.
*   **Ciclo de Vida Básico:**
    1. **Instanciación:** Se llama al constructor.
    2. **Inyección de Dependencias:** Spring asigna los Beans necesarios.
    3. **Inicialización:** Se ejecuta el método anotado con **`@PostConstruct`** (de `jakarta.annotation`). Ideal para lógica de arranque que depende de que el objeto ya esté construido.
    4. **Uso:** La aplicación utiliza el Bean.
    5. **Destrucción:** Al apagar la app, se ejecuta el método con **`@PreDestroy`** para liberar recursos limpiamente.
*   **`CommandLineRunner`:** Interfaz de Spring Boot. Su método `run()` se ejecuta automáticamente una única vez justo después de que el Application Context termina de cargar por completo. Útil para pruebas.

## 3. Scopes de los Beans (Alcance)
Define el tiempo de vida del objeto y cuántas instancias maneja Spring en memoria.
*   **Singleton (Por defecto):** Una única instancia compartida para toda la aplicación. Ideal para servicios sin estado (stateless) como Controladores o Repositorios.
*   **Prototype (`@Scope("prototype")`):** Crea una instancia totalmente nueva cada vez que el Bean es inyectado o solicitado.
*   **Request (`@RequestScope`):** Una instancia nueva por cada petición HTTP entrante. Se destruye al responder. (Requiere entorno web).
*   **Session (`@SessionScope`):** Una instancia nueva por cada sesión de usuario en el navegador. (Requiere entorno web).

## 4. Configuración Externa
Permite cambiar el comportamiento de la aplicación según el entorno (Dev, QA, Prod) sin recompilar el código. El archivo principal es `application.properties`.
*   **`@Value("${propiedad.nombre}")`:** Inyecta un valor individual directamente en una variable de tu Bean.
*   **`@ConfigurationProperties(prefix="prefijo")`:** Mapea un bloque completo de propiedades hacia los atributos de una clase (requiere métodos Getters y Setters). Es la forma más robusta.

## 5. AOP Básico (Programación Orientada a Aspectos)
Permite separar el "código transversal" (seguridad, auditoría, logs) de la lógica de negocio pura, manteniendo el código limpio y modular.
*   **Aspecto:** Un interceptor que vigila la ejecución de los métodos. Se define con las anotaciones `@Aspect` y `@Component`.
*   **`@Before`:** Ejecuta la lógica del aspecto *justo antes* del método interceptado. Útil para validaciones o auditoría.
*   **`@After`:** Ejecuta la lógica *justo después* del método interceptado.
*   **Pointcut Expression:** Es la sintaxis para definir la ruta de lo que queremos espiar. 
    *   Ejemplo: `execution(* com.paquete.Clase.metodo(..))` intercepta cualquier tipo de retorno (`*`), en esa clase/método exacto, sin importar los parámetros que reciba `(..)`.