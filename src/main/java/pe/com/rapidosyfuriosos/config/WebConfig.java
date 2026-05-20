package pe.com.rapidosyfuriosos.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
//Esta clase permite configurar el Thymeleaf para las interfaces graficas
//@Configuration -> se utiliza para que la clase sea una fuente de configuracion
@Configuration
//WebMvcConfigurer -> implementacion de una interfaz que permite configurar el Spring MVC
public class WebConfig implements WebMvcConfigurer {
	//creamos un metodo para definir la resolucion de plantillas
	//@Bean -> indica que devuelve un objeto que sera administrado por el contenedo de Spring
	@Bean
	public ClassLoaderTemplateResolver templateResolver() {
		//declaramos una vriablede tipo ClassLoaderTemplateResolver
		var templateResolver=new ClassLoaderTemplateResolver();
		//definimos la carpeta donde se van a encontrar las paginas web
		templateResolver.setPrefix("templates/");
		//deshabilitamos la opcion cacheable
		templateResolver.setCacheable(false);
		//definimos que tipo de paginas web van a cargar
		templateResolver.setSuffix(".html");
		//definimos el modo de plantilla de las paginas
		templateResolver.setTemplateMode("HTML");
		//definimos que permita caracteres especiales
		templateResolver.setCharacterEncoding("UTF-8");
		return templateResolver;
	}
	
	@Bean
	//creamos un metodo para definir el motor de integracion del Thymeleaf
	public SpringTemplateEngine templateEngine() {
		//declaramos una variable de tipo SpringTemplateEngine
		var templateEngine=new SpringTemplateEngine();
		//asignamos la resolucion de plantillas
		templateEngine.setTemplateResolver(templateResolver());
		return templateEngine;
	}
	
	@Bean
	//creamos un metodo para la resolucion de vistas
	public ViewResolver viewResolver() {
		//creamos un objeto de tipo ThymeleafViewResolver
		var viewResolver=new ThymeleafViewResolver();
		//asignamos el motor de integracion
		viewResolver.setTemplateEngine(templateEngine());
		//asignamos caracteres especiales
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}
	
	//sobrecargamos el metodo addResourceHandlers
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//asignamos la ubicacion de los recursos estaticos
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
}
