package app.richarddiaz.escalab;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Usuarios API", version = "1.0", description = "API para Usuarios"))
public class EscalabApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscalabApplication.class, args);
	}

}
