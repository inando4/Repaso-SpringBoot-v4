# Fase 2: Spring Boot Fundamentos - Apuntes

## 1. La Magia de `@SpringBootApplication`
Esta anotación principal es un "combo 3 en 1" que configura tu proyecto automáticamente:
*   **`@SpringBootConfiguration`:** Marca la clase como fuente principal de configuración (es un `@Configuration` especializado).
*   **`@ComponentScan`:** Es el "radar". Le dice a Spring que busque componentes (`@Component`, `@Service`, etc.) **solo en el paquete actual y sus sub-paquetes**. 
    *   *Solución a paquetes externos:* Usar `@SpringBootApplication(scanBasePackages = {"paquete1", "paquete2"})`.
*   **`@EnableAutoConfiguration`:** La verdadera magia. Spring Boot revisa qué dependencias (archivos JAR) tienes instaladas y configura automáticamente la aplicación basándose en ellas (ej. si ve Tomcat, levanta un servidor web).

## 2. Configuración Externa (Properties vs YAML) y Profiles
El código compilado (`.jar`) nunca debe cambiar entre entornos, solo su configuración.
*   **`.properties` vs `.yml`:** `.properties` es plano (llave=valor). `.yml` (YAML) es el estándar moderno, estructurado jerárquicamente mediante sangrías (espacios, no tabs), evitando la repetición de prefijos.
*   **Profiles (Perfiles de Entorno):** Permiten tener configuraciones distintas para `dev`, `prod`, `test`, etc.
    *   Convención de nombres: `application.yml` (base), `application-dev.yml`, `application-prod.yml`.
    *   **Merging (Fusión):** Spring lee el archivo base y luego el archivo del perfil activo, **sobreescribiendo** los valores que coincidan.
*   **Prioridad de Configuración:** Los argumentos pasados por línea de comandos al ejecutar el `.jar` (ej. `java -jar app.jar --server.port=9000`) **siempre vencen** a lo que esté escrito en los archivos YAML.

## 3. Starter Dependencies (Los Combos de Maven)
Los "Starters" (ej. `spring-boot-starter-web`) solucionan el "Dependency Hell".
*   **¿Qué son?** No contienen código Java. Son "descriptores" (archivos `pom.xml` internos) que agrupan un conjunto de librerías compatibles (ej. Tomcat + Spring MVC + Jackson).
*   **El Parent:** La etiqueta `<parent>` en tu `pom.xml` funciona como una Lista de Materiales (BOM). Dicta las versiones exactas que deben usar todos los Starters para garantizar compatibilidad absoluta.

## 4. Spring Boot Actuator (Signos Vitales)
El Starter `spring-boot-starter-actuator` proporciona "ventanas" (endpoints) para monitorear tu aplicación en producción.
*   **`/actuator/health`:** Muestra si la app está viva (`"status": "UP"`).
    *   **`liveness`:** Indica si la aplicación está corriendo y no se ha congelado (útil para que Kubernetes decida si reiniciar el contenedor).
    *   **`readiness`:** Indica si la aplicación ya terminó de cargar y está lista para recibir tráfico de usuarios.

## 5. DevTools (Live Reload)
Herramienta para acelerar el desarrollo local.
*   **Automatic Restart:** En lugar de detener y arrancar la app entera (que toma mucho tiempo), DevTools usa dos "Classloaders".
    *   *Base Classloader:* Carga librerías pesadas que no cambian (Tomcat, Hibernate). Nunca se reinicia.
    *   *Restart Classloader:* Carga tus clases. Se destruye y recrea instantáneamente cuando guardas/compilas un cambio en tu código.
*   **Seguridad:** DevTools se **autodestruye** automáticamente cuando ejecutas la aplicación compilada en producción (`java -jar`), evitando consumo extra de memoria.